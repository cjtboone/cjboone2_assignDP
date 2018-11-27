package main;

import java.util.ArrayList;
import java.util.Random;

public class Bee {

    
    private int id;
    private int health;
    private int energy;
    private int maxEnergy;
    private ArrayList<Species> species;
    private JobStrategy job;
    private Type beeType;
    private Hive home;
    private Map current;
    private int xpos;
    private int overX;
    private int ypos;
    private int overY;
    private int eggAge;
    private boolean food;
    
    private static int number = 0;
    
    /**
     * Bee constructor, uses Type enum to determine attributes.
     * @param hive home hive for the bee
     * @param beeType job type for the bee
     */
    public Bee(Hive hive, Type beeType) {
        id = incNumber();
        home = hive;
        current = home.getMap();
        species = home.getSpecies();
        overX = hive.getX();
        overY = hive.getY();
        this.beeType = beeType;
        switch (beeType) {
            case QUEEN: health = 200;
                    energy = 100;
                    maxEnergy = 100;
                    xpos = 3;
                    ypos = 3;
                    job = new QueenStrategy(Apiary.getMediator());
                    break;
            case WARRIOR: health = 150;
                    energy = 250;
                    maxEnergy = 250;
                    xpos = 0;
                    ypos = 0;
                    job = new WarriorStrategy(Apiary.getMediator());
                    break;
            case DRONE: health = 75;
                    energy = 100;
                    maxEnergy = 100;
                    xpos = 1;
                    ypos = 1;
                    job = new DroneStrategy(Apiary.getMediator());
                    break;
            case WORKER: health = 50;
                    energy = 100;
                    maxEnergy = 100;
                    xpos = 2;
                    ypos = 2;
                    job = new WorkerStrategy(Apiary.getMediator());
                    break;
            default:    health = 5;
                    energy = 0;
                    maxEnergy = 0;
                    xpos = 3;
                    ypos = 3;
                if (species.contains(Species.BREEDER)) {
                    eggAge = 8;
                } else {
                    eggAge = 12;
                }
                    job = new EggStrategy(Apiary.getMediator());
                    this.beeType = Type.EGG;
                    break;
        }
    }
    
    public void takeTurn() {
        job.doJob(this);
        energy--;
    }
    
    /**
     * Method for checking for enemy bees by comparing
     * the home hive attribute.
     * @param bee another bee occupying the same space
     * @return true if the other bee is part of the same
     *     hive/faction
     */
    public boolean teamCheck(Bee bee) {
        if (bee.getHive().equals(this.getHive())) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method for receiving damage based on an attack
     * from the mediator, there is a boost to damage
     * if the attacker is a TOUGH species. Also triggers
     * death procedures
     * @param damage amount of health taken away
     * @param hive the home hive of the attacker
     */
    public void takeHit(int damage, Hive hive) {
        if (species.contains(Species.TOUGH)) {
            health -= damage - 10;
        } else {
            health -= damage;
        }
        if (health <= 0) {
            if (beeType.equals(Type.QUEEN)) {
                home.queenDeath(hive);
            }
            current.remove(xpos, ypos, this);
            home.removeBee(this);
            Apiary.deadBee(this);
            System.out.println("Something died!");
        }
    }
    
    /**
     * Triggers a bee egg to grow every tick, and upon reaching
     * zero, is given a new bee type for its further turns.
     */
    public void grow() {
        eggAge--;
        if (eggAge == 0) {
            Random rand = new Random();
            int randInt = rand.nextInt(3);
            switch (randInt + 1) {
                case 1: beeType = (Type.WARRIOR);
                        energy = 250;
                        maxEnergy = 250;
                        job = 
                            new WarriorStrategy(Apiary.getMediator());
                        break;
                case 2: beeType = (Type.DRONE);
                        energy = 100;
                        maxEnergy = 100;
                        job = 
                            new DroneStrategy(Apiary.getMediator());
                        break;
                default:beeType = (Type.WORKER);
                        energy = 100;
                        maxEnergy = 100;
                        job = 
                            new WorkerStrategy(Apiary.getMediator());
                        break;
            }
        }
    }
    
    public void move(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }
    
    /**
     * Simple move function for switching between hive maps
     * and the overworld map.
     * @param xpos x position the bee will be moving to
     * @param ypos y position the bee will be moving to
     * @param map the new map object the bee is moving to
     */
    public void moveMap(int xpos, int ypos, Map map) {
        overX = this.xpos;
        this.xpos = xpos;
        overY = this.ypos;
        this.ypos = ypos;
        current = map;
    }
    
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    public Hive getHive() {
        return home;
    }
    
    public boolean hasFood() {
        return food;
    }
    
    public void giveFood() {
        food = true;
    }
    
    /**
     * When a drone carrying food reaches the hive,
     * it will increase the food amount for the whole
     * hive, with a boost if it is a DEXTROUS species.
     */
    public void deliverFood() {
        if (species.contains(Species.DEXTROUS)) {
            home.addFood(2);
        } else {
            home.addFood(1);
        }
        food = false;
    }
    
    public void eatFood() {
        home.decFood();
        setEnergy(maxEnergy);
    }
    
    /**
     * Method for checking if a bee is at home as opposed to
     * the overworld map.
     * @return true is the bee is in its home hive, false otherwise
     */
    public boolean inHive() {
        if (home.getMap().equals(current)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setHive(Hive hive) {
        this.home = hive;
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getX() {
        return xpos;
    }
    
    public int getOverX() {
        return overX;
    }
    
    public int getY() {
        return ypos;
    }
    
    public int getOverY() {
        return overY;
    }
    
    public Map getCurrent() {
        return current;
    }
    
    public int getId() {
        return id;
    }
    
    public Type getType() {
        return beeType;
    }
    
    public ArrayList<Species> getSpecies() {
        return species;
    }
    
    public static int incNumber() {
        return ++number;
    }
}
