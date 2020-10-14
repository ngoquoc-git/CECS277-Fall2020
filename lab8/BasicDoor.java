import java.util.Random;
public class BasicDoor implements Door{

    private boolean push;

    private boolean input;

    public BasicDoor(){
        
        Random ran = new Random();
        int door = ran.nextInt(1) + 1;

        if (door == 1) push = true;
        else push = false;

        input = false;
    }

    public String examine(){
        return "You reach a basic door\nYou can either push it or pull it to open\n";
    }
    
    public String menu(){
        return "1.Push\n2. Pull";
    }

    public String unlock(int option){
        int doorInt = push ? 1 : 2;

        if(option == doorInt) input = true;
        else input = false;

        if (option == 1) return "You've pushed the door";
        else return "You've pulled the door";
    }

    public boolean open(){
        if (input) {
            success();
            return true;
        }
        else{
            clue();
            return false;
        }
    }

    public String clue(){
        return "The door stays still, try again.";
    }
    
    public String success(){
        return "You've successfully open this door.";
    }
}
