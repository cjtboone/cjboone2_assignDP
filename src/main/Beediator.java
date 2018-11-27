package main;

import java.util.ArrayList;

public class Beediator {

    private ArrayList<Bee> bees;
    
    public void buildRoom(Bee bee) {
        
    }
    
    public void findFood(Bee bee) {
        if (bee.hasFood()) {
            if (bee.inHive()) {
                bee.deliverFood();
            } else {
                moveTowards(bee, bee.getHive());
            }
        } else {
            
        }
    }
    
    public void kill(Bee bee) {
        bees.remove(bee);
    }
    
    public void fightEnemy(Bee bee) {
        
    }
    
    public void layEgg(Bee bee) {
        
    }
    
    private void moveTowards(Bee bee, Hive hive) {
        
    }
    
    
}
