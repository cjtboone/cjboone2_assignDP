package main;

import java.util.ArrayList;

public class Bee {

    private int health;
    private int energy;
    private ArrayList<Species> species;
    private JobStrategy job;
    private Hive home;
    private Map current;
    private int x;
    private int overX;
    private int y;
    private int overY;
    private int eggAge;
    private boolean food;
    
    public Bee(Hive hive) {
        eggAge = 10;
        health = 5;
        energy = 0;
        species = home.getSpecies();
        home = hive;
        current = home.getMap();
        overX = hive.getX();
        overY = hive.getY();
    }
    
    public Bee(Hive hive, Type beeType) {
        home = hive;
        current = home.getMap();
        species = home.getSpecies();
        overX = hive.getX();
        overY = hive.getY();
        switch (beeType) {
        case QUEEN: health = 200;
                    energy = 100;
                    x = 3;
                    y = 3;
                    job = new QueenStrategy();
                    break;
        case WARRIOR: health = 150;
                    energy = 100;
                    x = 0;
                    y = 0;
                    job = new WarriorStrategy();
                    break;
        case DRONE: health = 75;
                    energy = 100;
                    x = 1;
                    y = 1;
                    job = new DroneStrategy();
                    break;
        case WORKER: health = 50;
                    energy = 100;
                    x = 2;
                    y = 2;
                    job = new WorkerStrategy();
                    break;
        default:    health = 5;
                    energy = 0;
                    x = 3;
                    y = 3;
                    job = new EggStrategy();
                    break;
        }
    }
    
    public void takeTurn() {
        job.doJob(this);
    }
    
    public boolean teamCheck(Bee bee) {
        if (bee.getHive().equals(this.getHive())) {
            return true;
        } else {
            return false;
        }
    }
    
    public void takeHit(int damage) {
        if (species.contains(Species.TOUGH)) {
            health -= damage + 10;
        } else {
            health -= damage;
        }
        if (health <= 0) {
            
        }
    }
    
    public void grow() {
        eggAge--;
        if (eggAge == 0) {
            //type selection
        }
    }
    
    public void move(int mX, int mY) {
        x = mX;
        y = mY;
        energy--;
    }
    
    public void moveMap(int mX, int mY, Map map) {
        overX = x;
        x = mX;
        overY = y;
        y = mY;
        current = map;
        energy--;
    }
    
    public void setEnergy(int mEnergy) {
        energy = mEnergy;
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
    
    public void deliverFood() {
        home.addFood(1);
        food = false;
    }
    
    public void eatFood() {
        home.decFood();
        setEnergy(100);
    }
    
    public boolean inHive() {
        if (home.getMap().equals(current)) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getX() {
        return x;
    }
    
    public int getOverX() {
        return overX;
    }
    
    public int getY() {
        return y;
    }
    
    public int getOverY() {
        return overY;
    }
    
    public Map getCurrent() {
        return current;
    }
    
    public ArrayList<Species> getSpecies() {
        return species;
    }
}
