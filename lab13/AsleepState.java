/**
 * what do we do in the asleep state when the other states are called
 *
 */
public class AsleepState implements PuppyState{
    /**
     * 
     */
    @Override 
    public void feed(Puppy p) {
        System.out.println("The puppy wakes up and comes running to eat.");
        p.setState(new EatingState());
    }
    
    /**
     * 
     */
    @Override
    public void play(Puppy p) {
        System.out.println("The puppy is asleep.  It doesn't want to play right now.");
    }
}
