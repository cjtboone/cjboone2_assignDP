package main;

import java.util.Random;

public class Beediator {
    
    /**
     * Main job method for worker bees, checks if nearby
     * rooms are not yet built -- builds them if so, randomly
     * wanders otherwise until it reaches a viable room.
     * @param bee Worker bee currently taking a turn
     */
    public void buildRoom(Bee bee) {
        if (energyCheck(bee)) {
            if (bee.getCurrent().isUnbuilt(bee.getX(), bee.getY() + 1)) {
                bee.getCurrent().getRoom(bee.getX(), bee.getY() + 1).build(bee.getHive());
            } else {
                if (bee.getCurrent().isUnbuilt(bee.getX() + 1, bee.getY())) {
                    bee.getCurrent().getRoom(bee.getX() + 1, bee.getY()).build(bee.getHive());
                } else {
                    if (bee.getCurrent().isUnbuilt(bee.getX() - 1, bee.getY())) {
                        bee.getCurrent().getRoom(bee.getX() - 1, bee.getY()).build(bee.getHive());
                    } else {
                        if (bee.getCurrent().isUnbuilt(bee.getX(), bee.getY() - 1)) {
                            bee.getCurrent().getRoom(bee.getX(),
                                    bee.getY() - 1).build(bee.getHive());
                        } else {
                            randMove(bee);
                        }
                    }
                }
            }
        } else {
            getRest(bee);
        }
    }
    
    /**
     * Main job method for drone bees, checks if bee is 
     * already in hive and can deliver food or if it 
     * makes to leave the hive.
     * @param bee Drone bee currently taking a turn
     */
    public void findFood(Bee bee) {
        if (energyCheck(bee)) {
            if (bee.hasFood()) {
                if (bee.inHive()) {
                    bee.deliverFood();
                    //System.out.println(bee.getType() + " " + bee.getId()
                    //    + " delivered food!");
                } else {
                    moveTowards(bee, bee.getHive());
                }
            } else {
                if (bee.inHive()) {
                    leave(bee);
                } else {
                    if (bee.getCurrent().isFlower(bee.getX(), bee.getY())) {
                        bee.giveFood();
                    } else {
                        randMove(bee);
                    }
                }
            }
        } else {
            getRest(bee);
        }
    }
    
    /**
     * Main job method for warrior bees, checks if there are
     * any enemy bees on their current space, includes a unique 
     * travel method that includes the ability to enter other
     * hives.
     * @param bee Warrior bee currently taking turn
     */
    public void fightEnemy(Bee bee) {
        if (energyCheck(bee)) {
            if (bee.getCurrent().hasEnemy(bee.getX(), bee.getY(), bee)) {
                int damage;
                if (bee.getSpecies().contains(Species.KILLER)) {
                    damage = 20;
                } else {
                    damage = 10;
                }
                (bee.getCurrent().getEnemy(bee.getX(),
                        bee.getY(), bee)).takeHit(damage, bee.getHive());
            } else {
                warriorMove(bee);
            }
        } else {
            getRest(bee);
        }
    }
    
    /**
     * Main job method for queen bees, checks if the hive can support
     * another egg and then lays one if so.
     * @param bee Queen bee currently taking turn
     */
    public void layEgg(Bee bee) {
        if (!bee.getHive().isFull()) {
            Bee egg = new Bee(bee.getHive(), Type.EGG);
            bee.getCurrent().add(bee.getX(), bee.getY(), egg);
            bee.getHive().addBee(egg);
            Apiary.newBee(egg);
            System.out.println(bee.getType().toString() + " " + bee.getId() 
                + " of Hive " + bee.getHive().getFaction() + " laid an egg!");
        } else {
            //message space
        }
    }
    
    private void moveTowards(Bee bee, Hive hive) {
        if (bee.getX() == hive.getX() && bee.getY() == hive.getY()) {
            if (hive.getFaction() == 0) {
                mapMove(bee, Apiary.getApiaryMap());
            } else {
                mapMove(bee, hive.getMap());
            }
        } else {
            if (Math.abs(bee.getX() - hive.getX()) 
                    > Math.abs(bee.getY() - hive.getY())) {
                if (bee.getX() - hive.getX() > 0) {
                    move(bee, -1, 0);
                } else {
                    if (bee.getX() - hive.getX() != 0) {
                        move(bee, 1, 0); 
                    }
                }  
            } else {
                if (bee.getY() - hive.getY() > 0) {
                    move(bee, 0, -1);
                } else {
                    if (bee.getY() - hive.getY() != 0) {
                        move(bee, 0, 1);
                    }
                }
                
            }
        }
    }
    
    private boolean energyCheck(Bee bee) {
        return (bee.getEnergy() > 0);
    }
    
    private void getRest(Bee bee) {
        //HEY CHECK FOR SPACE
        if (bee.inHive()) {
            if (bee.getHive().getFood() > 0) {
                bee.eatFood();
            } else {
                //message space
            }
        } else {
            if (bee.getCurrent() != Apiary.getApiaryMap()) {
                moveTowards(bee, new Hive(0, 0));
            } else {
                moveTowards(bee, bee.getHive());
            }
        }
    }
    
    private void move(Bee bee, int x, int y) {
        bee.getCurrent().remove(bee.getX(), bee.getY(), bee);
        bee.getCurrent().add(bee.getX() + x, bee.getY() + y, bee);
        bee.move(bee.getX() + x, bee.getY() + y);
    }
    
    private void randMove(Bee bee) {
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        switch (randInt + 1) {
            case 1: if (bee.getCurrent().isOpen(bee.getX(), bee.getY() + 1)) {
                    move(bee, 0, 1);
                } else {
                    randMove(bee);
                }
                    break;
            case 2: if (bee.getCurrent().isOpen(bee.getX() + 1, bee.getY())) {
                    move(bee, 1, 0);
                } else {
                    randMove(bee);
                }
                    break;
            case 3: if (bee.getCurrent().isOpen(bee.getX(), bee.getY() - 1)) {
                    move(bee, 0, -1);
                } else {
                    randMove(bee);
                }
                    break;
            case 4: if (bee.getCurrent().isOpen(bee.getX() - 1, bee.getY())) {
                    move(bee, -1, 0);
                } else {
                    randMove(bee);
                }
                    break;
            default:move(bee, 0, 0);
                    break; 
        }
    }
    
    private void warriorMove(Bee bee) {
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        if (bee.inHive() && bee.getX() == 0 && bee.getY() == 0) {
            if (randInt < 33) {
                mapMove(bee, Apiary.getApiaryMap());
            } else {
                randMove(bee);
            }
        } else {
            if (bee.inHive()) {
                randMove(bee);
            } else {
                if (bee.getCurrent().hasHive(bee.getX(), bee.getY()) 
                        && randInt < 50) {
                    mapMove(bee, bee.getCurrent().getHive(bee.getX(),
                            bee.getY()).getMap());
                } else {
                    randMove(bee);
                }
            }
        }
    }
    
    private void leave(Bee bee) {
        if (bee.getX() == 0 && bee.getY() == 0) {
            mapMove(bee, Apiary.getApiaryMap());
        } else {
            if (bee.getX() > 0 && bee.getCurrent().isOpen(bee.getX() - 1, bee.getY())) {
                move(bee, -1, 0);
            } else {
                if (bee.getY() > 0 && bee.getCurrent().isOpen(bee.getX(), bee.getY() - 1)) {
                    move(bee, 0, -1);
                } else {
                    //message or something
                }
            }
        }
    }
    
    private void mapMove(Bee bee, Map map) {
        bee.getCurrent().remove(bee.getX(), bee.getY(), bee);
        map.add(bee.getOverX(), bee.getOverY(), bee);
        bee.moveMap(bee.getOverX(), bee.getOverY(), map);
    }
    
}
