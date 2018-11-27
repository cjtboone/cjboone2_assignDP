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
    
    public Room(Room room) {
        this.inside = new ArrayList<>();
        this.workLeft = room.getWorkLeft();
        this.capacity = room.getCapacity();
        this.built = room.isBuilt();
        this.isFlower = room.getFlower();
        this.hive = room.getHive();
    }
    
    public void add(Bee bee) {
        inside.add(bee);
    }
    
    public void remove(Bee bee) {
        inside.remove(bee);
    }
    
    public void build(Hive hive) {
        workLeft--;
        if (workLeft <= 0) {
            built = true;
            hive.setPopCap(hive.getPopCap() + this.capacity);
        }
    }
    
    public boolean getFlower() {
        return isFlower;
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
    
    public int getWorkLeft() {
        return workLeft;
    }
    
    public void setWorkLeft(int work) {
        workLeft = work;
    }
    
    public int getCapacity() {
        return capacity;
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
    
    public boolean hasBees() {
        return inside.size() > 0;
    }
    
}
