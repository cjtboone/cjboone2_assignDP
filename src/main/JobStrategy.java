package main;
/**
 * Strategy pattern
 * Note the mediator object, pretty
 * much integrated it right into
 * this one. Picks different thing
 * to do each turn depending on the job
 * of the bee.
 *
 */

public abstract class JobStrategy {

    protected Beediator beediator;
    
    public JobStrategy(Beediator mediator) {
        beediator = mediator;
    }
    
    public abstract void doJob(Bee bee);
    
}

class WorkerStrategy extends JobStrategy {

    public WorkerStrategy(Beediator mediator) {
        super(mediator);
    }
    
    @Override
    public void doJob(Bee bee) {
        beediator.buildRoom(bee);
    }
    
}

class WarriorStrategy extends JobStrategy {
    
    public WarriorStrategy(Beediator mediator) {
        super(mediator);
    }
    
    @Override
    public void doJob(Bee bee) {
        beediator.fightEnemy(bee);
    }
    
}

class DroneStrategy extends JobStrategy {
    
    public DroneStrategy(Beediator mediator) {
        super(mediator);
    }
    
    @Override
    public void doJob(Bee bee) {
        beediator.findFood(bee);
    }
    
}

class QueenStrategy extends JobStrategy {
    
    public QueenStrategy(Beediator mediator) {
        super(mediator);
    }
    
    @Override
    public void doJob(Bee bee) {
        beediator.layEgg(bee);
    }
    
}

class EggStrategy extends JobStrategy {
    
    public EggStrategy(Beediator mediator) {
        super(mediator);
    }
    
    @Override
    public void doJob(Bee bee) {
        bee.grow();
    }
    
}
