package main;

import java.util.ArrayList;

public class Hive {

    private String faction;
    private int food;
    private ArrayList<Species> species;
    private Room[][] rooms;
    private ArrayList<Bee> bees;
    private Map hiveMap;
    
    public int getFood() {
        return food;
    }
    
    public void eatFood(Bee bee) {
        food--;
        bee.giveEnergy(100);
    }
    
    public ArrayList<Species> getSpecies() {
        return species;
    }
    
    public void addFood(int amount) {
        food += amount;
    }
    
    public Map getMap() {
        return hiveMap;
    }
}
