package main;

public abstract class JobStrategy {

    public abstract void doJob(Bee bee);
    
}

class WorkerStrategy extends JobStrategy {

    @Override
    public void doJob(Bee bee) {
        // TODO Auto-generated method stub
        
    }
    
}

class WarriorStrategy extends JobStrategy {
    
    @Override
    public void doJob(Bee bee) {
        // TODO Auto-generated method stub
        
    }
    
}

class DroneStrategy extends JobStrategy {
    
    @Override
    public void doJob(Bee bee) {
        beediator.findFood();
    }
    
}

class QueenStrategy extends JobStrategy {
    
    @Override
    public void doJob(Bee bee) {
        // TODO Auto-generated method stub
        
    }
    
}

class EggStrategy extends JobStrategy {
    
    @Override
    public void doJob(Bee bee) {
        bee.grow();
    }
    
}
