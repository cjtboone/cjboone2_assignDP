package main;

import java.util.ArrayList;

public class Hive {

    private String faction;
    private int food;
    private ArrayList<Species> species;
    private ArrayList<Bee> bees;
    private Map hiveMap;
    private int x;
    private int y;
    
    public Hive() {
        bees = new ArrayList<>();
        species = new ArrayList<>();
    }
    
    public void hiveInit(int x, int y) {
        this.x = x;
        this.y = y;
        this.food = 50;
        this.hiveMap = new Map();
    }
    
    
    public ArrayList<Species> getSpecies() {
        return species;
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
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
