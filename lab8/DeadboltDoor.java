import java.util.Random;
public class DeadboltDoor implements Door{
    
    private boolean bolt1;

    private boolean bolt2;

    public DeadboltDoor(){
        Random ran = new Random();
        int switches = ran.nextInt(1);
        
        if (switches == 0)  bolt1 = true;
        else bolt1 = false;
        
        bolt2 = !bolt1;
        
    }
    public String examine(){
        return "A deadbolt door is encountered.\nAdjust the toggles to open the door.\n";
    }
    
    public String menu(){
        return "Toogle Bolt 1.\n2. Toggle Bolt 2.\n";
    }

    public String unlock(int option){
        if (option == 1) {
            bolt1 = !bolt1;
            return "You toggle the first bolt.\n";}
        else if(option == 2) {
            bolt2 = !bolt2;
            return "You toggle the second bolt.\n";}
        else return null;
    }

    public boolean open(){
        if(bolt1 && bolt2) return true;
        return false;
    }

    public String clue(){
        return "Nothing happened, try the other option.\n";
    }
    
    public String success(){
        return "Zee...zee...zee, the door is open. You may enter.\n";
    }
}
