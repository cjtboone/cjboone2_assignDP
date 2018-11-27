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
    
    public static Apiary getApiary() {
        if (instance == null) {
            instance = new Apiary();
        }
        return instance;
    }
    
    public void buzz() {
        for (Bee bee : bees) {
            bee.takeTurn();
        }
        updateBees();
        printMap();
        
    }
    
    public void updateBees() {
        for (Bee bee : delete) {
            removeBee(bee);
        }
        for (Bee bee : update) {
            addBee(bee);
        }
    }
    
    public static Map getApiaryMap() {
        return apiaryMap;
    }
    
    
    
    public static String printMap() {
        return (apiaryMap.mapToString());
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
