package main;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    
    private Room[][] rooms;
    private ArrayList<Hive> hives;
    private int height;
    private int width;
    
    /**
     * Map constructor.
     * @param height height of new map
     * @param width width of new map
     */
    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        rooms = new Room[height][width];
        hives = new ArrayList<>();
        this.overworldInit();
    }
    
    /**
     * Map constructor for hive maps with preset dimensions.
     */
    public Map() {
        rooms = new Room[25][25];
        height = 25;
        width = 25;
        this.hivemapInit();
    }
    
    /**
     * Builder Design pattern director for creating different
     * room types, sets main attributes.
     * @param builder HiveBuilder object
     */
    public void makeRoom(HiveBuilder builder) {
        builder.setWorkLeft();
        builder.setCapacity();
        builder.setBuilt();
        builder.setFlower();
        builder.setHive();
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
                if (randInt < 13) {
                    rooms[i][j] = new Room(frb.getRoom());
                } else {
                    rooms[i][j] = new Room(owrb.getRoom());
                }
            }
        }
        
        for (int k = 0; k < 4; k++) {
            int randi = rand.nextInt(rooms.length);
            int randi2 = rand.nextInt(rooms[0].length);
            rooms[randi][randi2] = new Room(hrb.getRoom());
            rooms[randi][randi2].setHive(new Hive());
            rooms[randi][randi2].getHive().hiveInit(randi, randi2);
            hives.add(rooms[randi][randi2].getHive());
        }
        
    }
    
    private void hivemapInit() {
        HiveBuilder ubrb = new UnbuiltRoom();
        HiveBuilder brb = new BuiltRoom();
        makeRoom(ubrb);
        makeRoom(brb);
        
        for (int i2 = 0; i2 < rooms.length; i2++) {
            for (int j2 = 0; j2 < rooms[0].length; j2++) {
                rooms[i2][j2] = new Room(ubrb.getRoom());
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                rooms[i][j] = new Room(brb.getRoom());
            }
        }
        
    }
    
    public boolean isFlower(int x, int y) {
        return rooms[x][y].getFlower();
    }

    public Room getRoom(int x, int y) {
        return rooms[x][y];
    }
    
    /**
     * Method checking if a space has an enemy bee.
     * @param xpos current x coordinate position
     * @param ypos current y coordinate position
     * @param bee potential attacking bee for hive comparison
     * @return true if an enemy bee is occupying the same space
     */
    public boolean hasEnemy(int xpos, int ypos, Bee bee) {
        for (Bee bee2 : rooms[xpos][ypos].getInside()) {
            if (!bee.teamCheck(bee2)) {
                return true;
            }
        }
        return false;
    }
    
    /**Method for getting reference to enemy bee,
     * retrieves the first enemy Bee occupying the
     * same space.
     * @param xpos current x coordinate position
     * @param ypos current y coordinate position
     * @param bee attacking bee using for hive comparsion
     * @return reference to enemy Bee
     */
    public Bee getEnemy(int xpos, int ypos, Bee bee) {
        for (Bee bee2 : rooms[xpos][ypos].getInside()) {
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
    
    public ArrayList<Hive> getHives() {
        return hives;
    }
    
    /**
     * Method checking if a potential room has valid coordinates and is built.
     * @param xpos x coordinate of room to be checked
     * @param ypos y coordinate of room to be checked
     * @return true if valid room to move to
     */
    public boolean isOpen(int xpos, int ypos) {
        if (xpos >= 0 && xpos < rooms.length && ypos >= 0 && ypos < rooms[0].length) {
            return (rooms[xpos][ypos].isBuilt());
        } else {
            return false;
        }
    }

    /**
     * Method checking if a potential room has valid coordinates but is not built.
     * @param xpos x coordinate of room to be checked
     * @param ypos y coordinate of room to be checked
     * @return true if valid room but not built
     */
    public boolean isUnbuilt(int xpos, int ypos) {
        if (xpos >= 0 && xpos < rooms.length && ypos >= 0 && ypos < rooms[0].length) {
            return (rooms[xpos][ypos].isBuilt() == false);
        } else {
            return false;
        }
    }
    
    /**
     * toString method for Map, converts rooms to certain symbols on a grid to
     * create a primitive ASCII map.
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Room room = this.getRoom(i, j);
                if (room.hasBees()) {
                    buf.append("B ");
                } else {
                    if (room.getFlower()) {
                        buf.append("% ");
                    } else {
                        if (room.hasHive()) {
                            buf.append("& ");
                        } else {
                            buf.append("_ ");
                        }
                    }
                } 
            }
            buf.append("\n");
        }
        String output = buf.toString();
        return output;
    }
    
}
