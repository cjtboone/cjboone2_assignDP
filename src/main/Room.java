package main;

import java.util.ArrayList;

public class Room {
    
    private ArrayList<Bee> inside;
    private int workLeft;
    private int capacity;
    private boolean built;
    private boolean isFlower;

    public Room() {
        inside = new ArrayList<>();
        built = false;
        workLeft = 100;
    }
    
    public Room(boolean mFlower) {
        inside = new ArrayList<>();
        built = true;
        workLeft = 0;
        isFlower = mFlower;
    }
    
    public void add(Bee bee) {
        inside.add(bee);
    }
    
    public void remove(Bee bee) {
        inside.remove(bee);
    }
    
    public void build() {
        workLeft--;
        if (workLeft <= 0) {
            built = true;
        }
    }
    
    public boolean getFlower() {
        return isFlower;
    }
    
    public boolean isFull() {
        return (inside.size() <= capacity);
    }
    
    public ArrayList<Bee> getInside() {
        return inside;
    }
    
    public boolean isBuilt() {
        return built;
    }
    
}
