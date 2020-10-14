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
        return "You reach a basic door.\nYou can either push it or pull it to open.\n";
    }
    
    public String menu(){
        return "1.Push.\n2. Pull.\n";
    }

    public String unlock(int option){
        int doorInt = push ? 1 : 2;

        if(option == doorInt) input = true;
        else input = false;

        if (option == 1) return "You've pushed the door.\n";
        else if (option == 2) return "You've pulled the door.\n";
        else return null;
    }

    public boolean open(){
        if (input) {
            return true;
        }
        else{
            return false;
        }
    }

    public String clue(){
        return "The door stays still, try again.\n";
    }
    
    public String success(){
        return "You've successfully open this door.\n";
    }
}
