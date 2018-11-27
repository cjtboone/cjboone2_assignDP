package main;

import java.util.ArrayList;

public class Room {
    
    private ArrayList<Bee> inside;
    private int workLeft;
    private int capacity;
    private boolean built;
    private boolean isFlower;
    private Hive hive;

    public Room() {
        inside = new ArrayList<>();
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
    
    public boolean hasHive() {
        return hive != null;
    }
    
    public Hive getHive() {
        return hive;
    }
    
    public void setWorkLeft(int work) {
        workLeft = work;
    }
    
    public void setCapacity(int cap) {
        capacity = cap;
    }
    
    public void setBuilt(boolean built) {
        this.built = built;
    }
    
    public void setFlower(boolean isFlower) {
        this.isFlower = isFlower;
    }
    
    public void setHive(Hive hive) {
        this.hive = hive;
    }
    
}
