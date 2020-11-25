public class Puppy{
    /** keeps track of each state */
    private PuppyState state;
    private int eatCount;
    private int playCount;
    
    public Puppy() {
        state = new AsleepState(); 
        eatCount = 0;
        playCount = 0;
    }
    
    public void setState(PuppyState s) {state = s;}

    public void feedPuppy(){
        state.feed(this);
    }

    public void playWithPuppy(){
        state.play(this);
    }

    public void incrementEatCount(){
        eatCount++;
    }
    public void incrementPlayCount(){
        playCount++;
    }
    public void reset(){
        eatCount = 0;
        playCount = 0;
    }
    public int getEatCount(){
        return eatCount;
    }
    public int getPlayCount(){
        return playCount;
    }
}