public class EatingState implements PuppyState{

    /**
     * 
     */
    @Override 
    public void feed(Puppy p) {
        if (p.getEatCount() < 3){
            System.out.println("The puppy continues to eat as you add another scoop of kibble to its bowl.");
            p.incrementEatCount();
        }
        else{
            System.out.println("The puppy ate so much it fell asleep!");
            p.reset();
            p.setState(new AsleepState());
        }
    }
    
    /**
     * 
     */
    @Override
    public void play(Puppy p) {
        System.out.println("The puppy looks up from its food and chases the ball you threw.");
        p.reset();
        p.incrementPlayCount();
        p.setState(new PlayingState());
    }
    
}
