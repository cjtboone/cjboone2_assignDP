package main;

public class Map {
    
    private Room[][] rooms;
    
    public void moveTo(int x, int y, Bee bee) {
        rooms[x][y].add(bee);
    }
    
    public void enterHive(int x, int y, Bee bee) {
        
    }
    
    public boolean isFlower(int x, int y) {
        return rooms[x][y].getFlower();
    }

    public Room getRoom(int x, int y) {
        return rooms[x][y];
    }
    
    public boolean isFull(int x, int y) {
        return (rooms[x][y].isFull());
    }
    
    public boolean hasEnemy(int x, int y, Bee bee) {
        for (Bee bee2 : rooms[x][y].getInside()) {
            if (!bee.teamCheck(bee2)) {
                return true;
            }
        }
        return false;
    }
    
    public Bee getEnemy(int x, int y, Bee bee) {
        for (Bee bee2 : rooms[x][y].getInside()) {
            if (!bee.teamCheck(bee2)) {
                return bee2;
            }
        }
        return null;
    }
    
    public void add(int x, int y, Bee bee) {
        rooms[x][y].add(bee);
    }
    
    public void remove(int x, int y, Bee bee) {
        rooms[x][y].remove(bee);
    }
    
    public boolean hasHive(int x, int y) {
        return rooms[x][y].hasHive();
    }
    
    public Hive getHive(int x, int y) {
        return rooms[x][y].getHive();
    }
    
    public boolean isOpen(int x, int y) {
        if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length) {
            return (rooms[x][y].isBuilt() && !rooms[x][y].isFull());
        } else {
            return false;
        }
    }
    
}
