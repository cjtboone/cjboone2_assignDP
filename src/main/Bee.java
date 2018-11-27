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
        x = mX;
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
    
    public int getY() {
        return y;
    }
    
    public Map getCurrent() {
        return current;
    }
    
    public ArrayList<Species> getSpecies() {
        return species;
    }
}
