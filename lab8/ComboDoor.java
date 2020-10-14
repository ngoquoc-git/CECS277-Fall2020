import java.util.Random;
public class ComboDoor implements Door{
    
    private int comboValue;
    
    private int guess;

    public ComboDoor(){
        Random ran = new Random();
        comboValue = ran.nextInt(9) + 1;
    }

    public String examine(){
        return "This is a combo door, you have to dial to find the right number in order to pass.\n";
    }
    
    public String menu(){
        return "Enter an integer from 1 to 10: ";
    }

    public String unlock(int option){
        if(option > 0 && option < 11){
            guess = option;
            return "You dialed " + guess + ". ";
        }
        return null;
    }

    public boolean open(){
        if (guess == comboValue) return true;
        return false;
    }

    public String clue(){
        if(guess < comboValue) return "It's too low.\n";
        else if (guess > comboValue) return "It's too high.\n";
        else return success();
    }
    
    public String success(){
        return "It is the right number, door is opening";
    }
}
