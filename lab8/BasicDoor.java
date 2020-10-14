public class BasicDoor implements Door{

    private boolean push;

    private boolean input;

    public BasicDoor(){
        push = true;
        input = true;
    }

    public String examine(){
        return "You reach a basic door\n";
    }
    
    public String menu(){
        return "1.Push\n2. Pull";
    }

    public String unlock(int option){
        String doorOpen;
        if(option == 1) {
            input = true;
            push = true;
            doorOpen = success();
        }
        else{
            input = false;
            push = false;
            System.out.println("Nothing happened, door remains close. Try again!");
            doorOpen = unlock(option);
        }
        return doorOpen;
    }

    public boolean open(){
        //if(input) return true;
        //return false;
        return input ? true : false;
    }

    public String clue(){
        return "You can either push it or pull it to open\n";
    }
    
    public String success(){
        return "You've successfully open this door.";
    }
}
