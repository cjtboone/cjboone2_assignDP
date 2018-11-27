package main;

import java.util.ArrayList;

public class Apiary {

    private static Apiary instance;
    private static ArrayList<Bee> bees;
    private static Map apiaryMap;
    
    private Apiary() {
        
        apiaryMap = new Map(20, 20);
        
        
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
    }
    
    public static Map getApiaryMap() {
        return apiaryMap;
    }
    
    public static String mapToString() {
        return null;
    }
    
}
