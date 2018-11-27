package main;

import java.util.ArrayList;

public class Space {

    private ArrayList<Bee> inside;
    private int capacity;
    private boolean isFlower;
    
    public Space() {
        inside = new ArrayList<>();
    }
    
    public void add(Bee bee) {
        inside.add(bee);
    }
    
    public void remove(Bee bee) {
        inside.remove(bee);
    }
    
    public boolean getFlower() {
        return isFlower;
    }
    
    public boolean isFull() {
        return (inside.size() >= capacity);
    }
}
