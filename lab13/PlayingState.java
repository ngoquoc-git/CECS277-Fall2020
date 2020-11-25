public class PlayingState implements PuppyState{
    /**
     * 
     */
    @Override 
    public void feed(Puppy p) {
        System.out.println("You give puppy a bowl full of treats.");
        p.reset();
        p.setState(new EatingState());
    }
    
    /**
     * e
     */
    @Override
    public void play(Puppy p) {
        if(p.getPlayCount() < 2){
            System.out.println("You throw the ball again and the puppy excitedly chases it.");
            p.incrementPlayCount();
        }
        else{
            System.out.println("The puppy played so much it fell asleep.");
            p.reset();
            p.setState(new AsleepState());
        }
    }
}
