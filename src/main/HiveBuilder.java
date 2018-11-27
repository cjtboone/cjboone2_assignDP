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

    private Room _room = new Room();

    @Override
    public void setWorkLeft() {
        _room.setWorkLeft(100);
       
    }

    @Override
    public void setCapacity() {
        _room.setCapacity(0);
        
    }

    @Override
    public void setBuilt() {
        _room.setBuilt(false);
        
    }

    @Override
    public void setFlower() {
        _room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        _room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return _room;
    }
    
}

class BuiltRoom extends HiveBuilder {
    
    private Room _room = new Room();

    @Override
    public void setWorkLeft() {
        _room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        _room.setCapacity(40);
        
    }

    @Override
    public void setBuilt() {
        _room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        _room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        _room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return _room;
    }
    
}

class FlowerRoom extends HiveBuilder {
    
    private Room _room = new Room();

    @Override
    public void setWorkLeft() {
        _room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        _room.setCapacity(20);
        
    }

    @Override
    public void setBuilt() {
       _room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        _room.setFlower(true);
        
    }

    @Override
    public void setHive() {
        _room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return _room;
    }
    
}

class OverworldRoom extends HiveBuilder {
    
    private Room _room = new Room();

    @Override
    public void setWorkLeft() {
        _room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        _room.setCapacity(40);
        
    }

    @Override
    public void setBuilt() {
        _room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        _room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        _room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return _room;
    }
    
}

class HiveRoom extends HiveBuilder {

    private Room _room = new Room();
    
    @Override
    public void setWorkLeft() {
        _room.setWorkLeft(0);
        
    }

    @Override
    public void setCapacity() {
        _room.setCapacity(40);
        
    }

    @Override
    public void setBuilt() {
        _room.setBuilt(true);
        
    }

    @Override
    public void setFlower() {
        _room.setFlower(false);
        
    }

    @Override
    public void setHive() {
        _room.setHive(null);
        
    }

    @Override
    public Room getRoom() {
        return _room;
    }
    
}
