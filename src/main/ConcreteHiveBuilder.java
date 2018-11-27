package main;

public class ConcreteHiveBuilder extends HiveBuilder {

    @Override
    public void buildHive(Map hive, int x, int y) {
        hive.getRoom(x, y).build();
        
    }
    
}
