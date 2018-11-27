package main;

import java.util.Random;

public class Map {
    
    private Room[][] rooms;
    private boolean hiveMap;
    
    public Map(int x, int y) {
        rooms = new Room[x][y];
        this.overworldInit();
    }
    
    public Map() {
        rooms = new Room[20][20];
        hiveMap = true;
        this.hivemapInit();
    }
    
    public void makeRoom(HiveBuilder builder) {
        builder.setWorkLeft();
        builder.setCapacity();
        builder.setBuilt();
        builder.setFlower();
        builder.setHive();
        builder.getRoom();
    }
    
    private void overworldInit() {
        HiveBuilder owrb = new OverworldRoom();
        HiveBuilder frb = new FlowerRoom();
        HiveBuilder hrb = new HiveRoom();
        makeRoom(owrb);
        makeRoom(frb);
        makeRoom(hrb);
        Random rand = new Random();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                int randInt = rand.nextInt(100);
                if (randInt < 25) {
                    rooms[i][j] = frb.getRoom();
                } else {
                    rooms[i][j] = owrb.getRoom();
                }
            }
        }
        
        for (int k = 0; k < 4; k++) {
            int randi = rand.nextInt(rooms.length);
            int randi2 = rand.nextInt(rooms[0].length);
            rooms[randi][randi2] = hrb.getRoom();
            rooms[randi][randi2].getHive().hiveInit(randi, randi2);
        }
        
    }
    
    private void hivemapInit() {
        HiveBuilder ubrb = new UnbuiltRoom();
        HiveBuilder brb = new BuiltRoom();
        makeRoom(ubrb);
        makeRoom(brb);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                rooms[i][j] = brb.getRoom();
            }
        }
        
        for (int i2 = 4; i2 < rooms.length; i2++) {
            for (int j2 = 4; j2 < rooms[i2].length; j2++) {
                rooms[i2][j2] = ubrb.getRoom();
            }
        }
        
    }
    
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
    
    public void addHive(int x, int y) {
        if (!hiveMap) {
            rooms[x][y] = new Room();
        }
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
