package main;

import java.util.ArrayList;

public class Apiary {

    private static Apiary instance;
    private Hive[][] hives;
    private ArrayList<Bee> bees;
    private Map apiaryMap;
    
    private Apiary() {
        
    }
    
    public static Apiary getApiary() {
        if (instance == null) {
            instance = new Apiary();
        }
        return instance;
    }
    
    public void Construct(HiveBuilder builder) {
        
    }
    
    public void buzz() {
        for (Bee bee : bees) {
            bee.takeTurn();
        }
    }
    
}
