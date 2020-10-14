import java.util.Random;
public class LockedDoor implements Door{
    
    private int keyLocation;

    private int keyChoice;

    public LockedDoor(){
        Random ran = new Random();
        keyLocation = ran.nextInt(2) + 1;
    }

    public String examine(){
        return "You reach a locked door.\nYou have to find the key.\n";
    }
    
    public String menu(){
        return "1.Look Under the Mat.\n2. Look Under the Flower Pot.\n3. Look Under Fake Rock.\n";
    }

    public String unlock(int option){
        if (option > 0 && option < 4){
            keyChoice = option;
            if (keyChoice == 1) return "You looked under the mat\n";
            else if (keyChoice == 2) return "You looked under the flower pot\n";
            else return "You looked under the fake rock\n";
        }
        return null;
    }

    public boolean open(){
        if (keyLocation == keyChoice) return true;
        return false;
    }

    public String clue(){
        return "The key is not here, try somewhere else.\n";
    }
    
    public String success(){
        return "You've successfully found the key, you may enter\n";
    }
}
