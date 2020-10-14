import java.util.Random;
public class BasicDoor implements Door{

    private boolean push;

    private boolean input;

    public BasicDoor(){
        
        Random ran = new Random();
        int door = ran.nextInt(1);

        if (door + 1 == 0) push = true;
        else push = false;

        input = false;
    }

    public String examine(){
        return "You reach a basic door\n";
    }
    
    public String menu(){
        return "1.Push\n2. Pull";
    }

    public String unlock(int option){

        if (option == 1 && push) {
            input = true;
            return "You've pushed the door";
        }
        else if (option == 1 && !push){
            input = false;
            return "You've pushed the door";
        }
        else if (option == 2 && !push){
            input = true;
            return "You've pulled the door";
        }
        else{
            input = false;
            return "You've pulled the door";
        }
        
    }

    public boolean open(){
        if (input) return true;
        return false;
    }

    public String clue(){
        return "You can either push it or pull it to open\n";
    }
    
    public String success(){
        return "You've successfully open this door.";
    }
}
