package main;

import java.util.ArrayList;
import java.util.Random;

public class Hive {

    private int faction;
    private int food;
    private ArrayList<Species> species;
    private ArrayList<Bee> bees;
    private Map hiveMap;
    private int xpos;
    private int ypos;
    private int popcap;
    private boolean alive;
    
    private static int number = 0;
    
    /**
     * Basic constructor for Hive object, simply initializes
     * the ArrayLists for bees and the bee species.
     */
    public Hive() {
        bees = new ArrayList<>();
        species = new ArrayList<>();
        alive = true;
        
    }
    
    /**
     * Utility constructor for Warrior bees, allows the creation
     * of a Hive with unique coordinates to direct the bee.
     * @param xpos x coordinate of destination
     * @param ypos y coordinate of destination
     */
    public Hive(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.faction = 0;
    }
    
    /**
     * Initializer for Hive separate from constructor, initializes
     * some attributes and creates the initial bees for the hive.
     * @param xpos x coordinate of hive on overworld map
     * @param ypos y coordinate of hive on overworld map
     */
    public void hiveInit(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.food = 50;
        this.hiveMap = new Map();
        this.faction = ++number;
        this.popcap = 160;
        
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        switch (randInt + 1) {
            case 1: species.add(Species.BREEDER);
                    break;
            case 2: species.add(Species.DEXTROUS);
                    break;
            case 3: species.add(Species.TOUGH);
                    break;
            case 4: species.add(Species.KILLER);
                    break;
            default:break;
        }
        
        Bee queenB = new Bee(this, Type.QUEEN);
        addBee(queenB);
        Apiary.addBee(queenB);
        hiveMap.add(queenB.getX(), queenB.getY(), queenB);
        
        for (int i = 0; i < 10; i++) {
            Bee warrior = new Bee(this, Type.WARRIOR);
            addBee(warrior);
            Apiary.addBee(warrior);
            hiveMap.add(warrior.getX(), warrior.getY(), warrior);
        }
        
        for (int j = 0; j < 20; j++) {
            Bee drone = new Bee(this, Type.DRONE);
            addBee(drone);
            Apiary.addBee(drone);
            hiveMap.add(drone.getX(), drone.getY(), drone);
        }
        
        for (int k = 0; k < 15; k++) {
            Bee worker = new Bee(this, Type.WORKER);
            addBee(worker);
            Apiary.addBee(worker);
            hiveMap.add(worker.getX(), worker.getY(), worker);
        }
        
    }
    
    public ArrayList<Species> getSpecies() {
        return species;
    }
    
    /**
     * Method for handling death of hive Queen, transfers
     * all hive bees over to conquering hive.
     * @param hive conquering hive
     */
    public void queenDeath(Hive hive) {
        for (Bee bee : bees) {
            bee.setHive(hive);
            alive = false;
        }
        System.out.println("A Queen died!");
    }
    
    public void addFood(int amount) {
        food += amount;
    }
    
    public void decFood() {
        food -= 3;
    }
    
    public int getFood() {
        return food;
    }
    
    public Map getMap() {
        return hiveMap;
    }
    
    public void setPopCap(int cap) {
        popcap = cap;
    }
    
    public int getPopCap() {
        return popcap;
    }
    
    public boolean isFull() {
        return (bees.size() >= popcap);
    }
    
    public ArrayList<Bee> getBees() {
        return bees;
    }
    
    public void addBee(Bee bee) {
        bees.add(bee);
    }
    
    public void removeBee(Bee bee) {
        bees.remove(bee);
    }
    
    public int getX() {
        return xpos;
    }
    
    public void setX(int xpos) {
        this.xpos = xpos;
    }
    
    public int getY() {
        return ypos;
    }
    
    public void setY(int ypos) {
        this.ypos = ypos;
    }
    
    public int getFaction() {
        return faction;
    }
    
    public boolean getAlive() {
        return alive;
    }
    
    public String toString() {
        return ("Faction " + faction + "\n" 
                + "Alive: " + bees.size());
    }
}
