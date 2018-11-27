package main;

import java.util.ArrayList;

public class Hive {

    private int faction;
    private int food;
    private ArrayList<Species> species;
    private ArrayList<Bee> bees;
    private Map hiveMap;
    private int x;
    private int y;
    private int popcap;
    
    private static int number = 0;
    
    public Hive() {
        bees = new ArrayList<>();
        species = new ArrayList<>();
        
    }
    
    public Hive(int x, int y) {
        this.x = x;
        this.y = y;
        this.faction = 0;
    }
    
    public void hiveInit(int x, int y) {
        this.x = x;
        this.y = y;
        this.food = 50;
        this.hiveMap = new Map();
        this.faction = ++number;
        this.popcap = 160;
        
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
    
    public void queenDeath(Hive hive) {
        for (Bee bee : bees) {
            bee.setHive(hive);
        }
    }
    
    public void addFood(int amount) {
        food += amount;
    }
    
    public void decFood() {
        food--;
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
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getFaction() {
        return faction;
    }
}
