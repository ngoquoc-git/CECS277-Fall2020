import java.util.Random;
public class ComboDoor implements Door {

    /** A random number needed to open the door*/
    private int comboValue;
    /** User's guesses */
    private int guess;

    /**
     * Default Constructor 
     * Randomly generate a number to open combo door
     * guess is set to 0 to make open() false the first time
     */
    public ComboDoor(){
        Random ran = new Random();
        comboValue = ran.nextInt(10) + 1;
        guess = 0;
    }

    /**
     * Door representation
     * @return string door's introduction
     */
    @Override
    public String examine(){
        return "This is a combo door, you have to dial to find the right number in order to pass.\n";
    }
    
    /**
     * Possible options
     * @return string list of options
     */
    @Override
    public String menu(){
        return "Enter an integer from 1 to 10: ";
    }

    /**
     * Proccess user's action
     * @param option user's option
     * @return string associate to the action
     */
    @Override
    public String unlock(int option){
        if(option > 0 && option < 11){
            guess = option;
            return "You dialed " + guess + ". ";
        }
        return "Wrong Input, ";
    }

    /**
     * Check if the door is open
     * @return true if meet given condition, false otherwise
     */
    @Override
    public boolean open(){
        if (guess == comboValue) return true;
        return false;
    }

    /**
     * Give user a clue
     * @return string clue's message
     */
    @Override
    public String clue(){
        if(guess != 0){
          if(guess < comboValue) return "It's too low.\n";
          else if (guess > comboValue) return "It's too high.\n";
          else return success();
        }
        else return "try again.\n";
    }
    
    /**
     * Let user know if the door is open
     * @return success message
     */
     @Override
    public String success(){
        return "It is the right number, door is opening";
    }
}
