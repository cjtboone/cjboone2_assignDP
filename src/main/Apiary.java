package main;

import java.util.ArrayList;

public class Apiary {

    private static Apiary instance;
    private static ArrayList<Bee> bees;
    private static ArrayList<Bee> update;
    private static ArrayList<Bee> delete;
    private static Map apiaryMap;
    private static Beediator beediator;
    private static int height;
    private static int width;
    
    private Apiary() {
        beediator = new Beediator();
        bees = new ArrayList<>();
        update = new ArrayList<>();
        delete = new ArrayList<>();
        apiaryMap = new Map(height, width);
    }
    
    /**
     * Singleton creational design pattern intended to prevent
     * more than one Apiary object from being created.
     * @return Apiary instance
     */
    public static Apiary getApiary() {
        if (instance == null) {
            instance = new Apiary();
        }
        return instance;
    }
    
    /**
     * Cycles through every bee and activates their turn, 
     * updates the bee data structure and prints the
     * overworld map.
     */
    public void buzz() {
        for (Bee bee : bees) {
            bee.takeTurn();
        }
        updateBees();
        printMap();
        
    }
    
    /**
     * Updates the main bees ArrayList by adding in new
     * bee entries from the update ArrayList and removes
     * dead bees using the delete ArrayList.
     */
    public void updateBees() {
        for (Bee bee : delete) {
            removeBee(bee);
        }
        for (Bee bee : update) {
            addBee(bee);
        }
        bees.trimToSize();
        delete.clear();
        update.clear();
    }
    
    public static Map getApiaryMap() {
        return apiaryMap;
    }
    
    public static String printMap() {
        return (apiaryMap.toString());
    }
    
    public static Beediator getMediator() {
        return beediator;
    }
    
    public static void setMapSize(int x, int y) {
        height = x;
        width = y;
    }
    
    public static int getMapHeight() {
        return height;
    }
    
    public static int getMapWidth() {
        return width;
    }
    
    public static void addBee(Bee bee) {
        bees.add(bee);
    }
    
    public static void removeBee(Bee bee) {
        bees.remove(bee);
    }
    
    public static void newBee(Bee bee) {
        update.add(bee);
    }
    
    public static void deadBee(Bee bee) {
        delete.add(bee);
    }
    
}
