public class Puppy{
    /** keeps track of state status*/
    private PuppyState state;
    /** Count eating times*/
    private int eatCount;
    /** COunt playing times*/
    private int playCount;
    
    /**
     * Constructor that create a puppy
     * set puppy in asleep state as default
     * set eat and play to 0
     */
    public Puppy() {
        state = new AsleepState(); 
        eatCount = 0;
        playCount = 0;
    }
    
    /**
     * Method to determine the next state of puppy
     * @param s puppy's next state
     */
    public void setState(PuppyState s) {state = s;}

    /**
     * Feed puppy action that will be called in main
     */
    public void feedPuppy() {state.feed(this);}

    /**
     * Play action that will be called in main
     */
    public void playWithPuppy() {state.play(this);}

    /**
     * Method to increase eat count by 1 
     */
    public void incrementEatCount() {eatCount++;}

    /**
     * Method to increase eat count by 1 
     */
    public void incrementPlayCount() {playCount++;}

    /**
     * Method that set bnoth eat count and play count to 0
     */
    public void reset(){
        eatCount = 0;
        playCount = 0;
    }

    /**
     * Method taht retrives eat count
     * @return eatCount to check if the puppy is full
     */
    public int getEatCount() {return eatCount;}

    /**
     * Method taht retrives play count
     * @return playCount to check if the puppy is tired
     */
    public int getPlayCount() {return playCount;}
}