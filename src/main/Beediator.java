package main;

import java.util.ArrayList;

public class Beediator {

    private ArrayList<Bee> bees;
    
    public void buildRoom(Bee bee) {
        if (energyCheck(bee)) {
            if (bee.getCurrent().hasUnbuilt()) {
                
            }
        } else {
            getRest(bee);
        }
    }
    
    public void constructRoom(HiveBuilder builder) {
        
    }
    
    public void findFood(Bee bee) {
        if (energyCheck(bee)) {
            if (bee.hasFood()) {
                if (bee.inHive()) {
                    bee.deliverFood();
                } else {
                    moveTowards(bee, bee.getHive());
                }
            } else {
                if (bee.inHive()) {
                    leave(bee);
                } else {
                    if (bee.getCurrent().isFlower(bee.getX(), bee.getY())) {
                        gatherFood(bee);
                    } else {
                        randMove(bee);
                    }
                }
            }
        } else {
            getRest(bee);
        }
    }
    
    public void kill(Bee bee) {
        bees.remove(bee);
    }
    
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
                        bee.getY(), bee)).takeHit(damage);
            } else {
                warriorMove(bee);
            }
        } else {
            getRest(bee);
        }
    }
    
    public void layEgg(Bee bee) {
        if (!bee.getCurrent().isFull(bee.getX(),bee.getY())) {
            bee.getCurrent().add(bee.getX(), bee.getY(), 
                    new Bee(bee.getHive()));
        } else {
            //message space
        }
    }
    
    private void moveTowards(Bee bee, Hive hive) {
        if (bee.getX() == hive.getX() && bee.getY() == hive.getY()) {
            if (!hive.getMap().isFull(0,0)) {
                mapMove(bee, hive.getMap());
            } else {
                //message space
            }
        } else {
            if (Math.abs(bee.getX() - hive.getX()) > 
                Math.abs(bee.getY() - hive.getY())) {
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
    
    private void leave(Bee bee) {
        
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
            moveTowards(bee, bee.getHive());
        }
    }
    
    private void move(Bee bee, int x, int y) {
        
    }
    
    private void randMove(Bee bee) {
        
    }
    
    private void warriorMove(Bee bee) {
        
    }
    
    private void mapMove(Bee bee, Map map) {
        
    }
    
}
