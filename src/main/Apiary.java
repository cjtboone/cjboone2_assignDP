package main;

import java.util.ArrayList;

public class Apiary {

    private static Apiary instance;
    private static ArrayList<Bee> bees;
    private static ArrayList<Bee> update;
    private static Map apiaryMap;
    private static Beediator beediator;
    private static int height;
    private static int width;
    
    private Apiary() {
        beediator = new Beediator();
        bees = new ArrayList<>();
        update = new ArrayList<>();
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
        System.out.println(bees.size());
        
    }
    
    public void updateBees() {
        for (Bee bee : update) {
            addBee(bee);
        }
    }
    
    public static Map getApiaryMap() {
        return apiaryMap;
    }
    
    public static String mapToString() {
        String output = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Room room = apiaryMap.getRoom(i, j);
                if (room.hasBees()) {
                    output += "B ";
                } else {
                    if (room.getFlower()) {
                        output += "% ";
                    } else {
                        if (room.hasHive()) {
                            output += "& ";
                        } else {
                            output += "_ ";
                        }
                    }
                } 
            }
            output += "\n";
        }
    return output;
    }
    
    public static void printMap() {
        System.out.println(mapToString());
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
    
}
