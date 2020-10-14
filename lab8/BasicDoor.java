import java.util.Random;
public class BasicDoor implements Door{

    /** Door mechanism: push or pull */
    private boolean push;
    /** Check if input is true to open the door */
    private boolean input;

    /**
     * Default Constructor 
     * Randomly generate basic door mechanism push - pull
     * input will be false till user prompt an action
     */
    public BasicDoor(){
        
        Random ran = new Random();
        int door = ran.nextInt(1) + 1;

        if (door == 1) push = true;
        else push = false;

        input = false;
    }

    /**
     * Door representation
     * @return string door's introduction
     */
    @Override
    public String examine(){
        return "You reach a basic door.\nYou can either push it or pull it to open.\n";
    }
    
    /**
     * Possible options
     * @return string list of options
     */
    @Override
    public String menu(){
        return "1.Push.\n2. Pull.\n";
    }

    /**
     * Proccess user's action
     * @param option user's option
     * @return string associate to the action
     */
    @Override
    public String unlock(int option){
        if(option > 0 && option < 3){
            int doorInt = push ? 1 : 2;

            if(option == doorInt) input = true;
            else input = false;
        }
        if (option == 1) return "You've pushed the door.\n";
        else if (option == 2) return "You've pulled the door.\n";
        else return null;
    }

    /**
     * Check if the door is open
     * @return true if meet given condition, false otherwise
     */
    @Override
    public boolean open(){
        if (input) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Give user a clue
     * @return string clue's message
     */
    @Override
    public String clue(){
        return "The door stays still, try again.\n";
    }
    
    /**
     * Let user know if the door is open
     * @return success message
     */
    @Override
    public String success(){
        return "You've successfully open this door.\n";
    }
}
