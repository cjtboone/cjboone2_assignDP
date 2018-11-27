package main;

public abstract class HiveBuilder {
    
    public abstract void setWorkLeft();
    
    public abstract void setCapacity();
    
    public abstract void setBuilt();
    
    public abstract void setFlower();
    
    public abstract void setHive();
    
    public abstract Room getRoom();
    
}

class UnbuiltRoom extends HiveBuilder {

    private Room room = new Room();

    @Override
    public void setWorkLeft() {
        room.setWorkLeft(100);
       
    }

    @Override
    public void setCapacity() {
        room.setCapacity(0);
        
    }

    @Override
    public void setBuilt() {
        room.setBuilt(false);
        
    }

    @Override
    public void setFlower() {
        room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return room;
    }
    
}

class BuiltRoom extends HiveBuilder {
    
    private Room room = new Room();

    @Override
    public void setWorkLeft() {
        room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        room.setCapacity(10);
        
    }

    @Override
    public void setBuilt() {
        room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return room;
    }
    
}

class FlowerRoom extends HiveBuilder {
    
    private Room room = new Room();

    @Override
    public void setWorkLeft() {
        room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        room.setCapacity(10);
        
    }

    @Override
    public void setBuilt() {
        room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        room.setFlower(true);
        
    }

    @Override
    public void setHive() {
        room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return room;
    }
    
}

class OverworldRoom extends HiveBuilder {
    
    private Room room = new Room();

    @Override
    public void setWorkLeft() {
        room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        room.setCapacity(10);
        
    }

    @Override
    public void setBuilt() {
        room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return room;
    }
    
}

class HiveRoom extends HiveBuilder {

    private Room room = new Room();
    
    @Override
    public void setWorkLeft() {
        room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        room.setCapacity(10);
        
    }

    @Override
    public void setBuilt() {
        room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return room;
    }
    
}
