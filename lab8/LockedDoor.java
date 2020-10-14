import java.util.Random;
public class LockedDoor implements Door{
    
    /** Location that the tkey is hidden */
    private int keyLocation;
    /** Location that user decides to look for the key */
    private int keyChoice;

    /**
     * Default Contructor
     * Randomly generate a location to hide the key
     */
    public LockedDoor(){
        Random ran = new Random();
        keyLocation = ran.nextInt(2) + 1;
    }

    /**
     * Door representation
     * @return string door's introduction
     */
    @Override
    public String examine(){
        return "You reach a locked door.\nYou have to find the key.\n";
    }
    
    /**
     * Possible options
     * @return string list of options
     */
    @Override
    public String menu(){
        return "1.Look Under the Mat.\n2. Look Under the Flower Pot.\n3. Look Under Fake Rock.\n";
    }

    /**
     * Proccess user's action
     * @param option user's option
     * @return string associate to the action
     */
    @Override
    public String unlock(int option){
        if (option > 0 && option < 4){
            keyChoice = option;
            if (keyChoice == 1) return "You looked under the mat\n";
            else if (keyChoice == 2) return "You looked under the flower pot\n";
            else return "You looked under the fake rock\n";
        }
        return null;
    }

    /**
     * Check if the door is open
     * @return true if meet given condition, false otherwise
     */
    @Override
    public boolean open(){
        if (keyLocation == keyChoice) return true;
        return false;
    }

    /**
     * Give user a clue
     * @return string clue's message
     */
    @Override
    public String clue(){
        return "The key is not here, try somewhere else.\n";
    }
    
    /**
     * Let user know if the door is open
     * @return success message
     */
    @Override
    public String success(){
        return "You've successfully found the key, you may enter\n";
    }
}
