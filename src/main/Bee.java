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
    private int y;
    private int eggAge;
    private boolean food;
    
    public Bee(Hive hive) {
        eggAge = 10;
        home = hive;
        species = home.getSpecies();
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
            health -= damage + 5;
        } else {
            health -= damage;
        }
        if (health <= 0) {
            
        }
    }
    
    public void rest() {
        if (home.getFood() > 0) {
            home.eatFood(this);
        }
    }
    
    public void grow() {
        eggAge--;
        if (eggAge == 0) {
            
        }
    }
    
    public void move(int mX, int mY) {
        x = mX;
        y = mY;
        energy--;
    }
    
    public void moveMap(int mX, int mY, Map map) {
        x = mX;
        y = mY;
        current = map;
        energy--;
    }
    
    public void giveEnergy(int calories) {
        energy += calories;
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
    
    public boolean inHive() {
        if (home.getMap().equals(current)) {
            return true;
        } else {
            return false;
        }
    }
}
