import java.util.Random;
public class DeadboltDoor implements Door {

    /** First bolt toggle */
    private boolean bolt1;
    /** Second bolt toggle */
    private boolean bolt2;

    /**
     * Default constructor
     * Randomly set either bolt 1 or bolt 2 to true
     * bolts 1 and bolt 2 have to to different to each other
     */
    public DeadboltDoor(){
        Random ran = new Random();
        int switches = ran.nextInt(2);
        
        if (switches == 0)  bolt1 = true;
        else bolt1 = false;
        
        bolt2 = !bolt1;
        
    }

    /**
     * Door representation
     * @return string door's introduction
     */
    @Override
    public String examine(){
        return "A deadbolt door is encountered.\nAdjust the toggles to open the door.\n";
    }
    
    /**
     * Possible options
     * @return string list of options
     */
    @Override
    public String menu(){
        return "1. Toogle Bolt 1.\n2. Toggle Bolt 2.\n";
    }

    /**
     * Proccess user's action
     * @param option user's option
     * @return string associate to the action
     */
    @Override
    public String unlock(int option){
        if (option == 1) {
            bolt1 = !bolt1;
            return "You toggle the first bolt.\n";}
        else if(option == 2) {
            bolt2 = !bolt2;
            return "You toggle the second bolt.\n";}
        else return "Wrong input, try again.\n";
    }

    /**
     * Check if the door is open
     * @return true if meet given condition, false otherwise
     */
    @Override
    public boolean open(){
        if(bolt1 && bolt2) return true;
        return false;
    }

    /**
     * Give user a clue
     * @return string clue's message
     */
    @Override
    public String clue(){

        if(bolt1 || bolt2) return "One is in the correct position\n";
        return "Nothing happened, Try again.\n";
    }

    /**
     * Let user know if the door is open
     * @return success message
     */
    @Override
    public String success(){
        return "Zee...zee...zee, the door is open. You may enter.\n";
    }
}
