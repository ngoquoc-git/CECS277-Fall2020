public class Main {
    public static void main(String[] args){
        
        Monster mon;
        int userInput;

        System.out.println("Monster Creator!");
        System.out.println("Choose a base monster:");
        System.out.println("1.Alien.\n2.Beast.\n3.Undead.");
        userInput = CheckInput.getIntRange(1,3);

        //Tried to use switch, but i caused error
        if(userInput == 1) mon = new Alien();
        else if(userInput == 2) mon = new Beast();
        else mon = new Undead();
        
        
        System.out.println(mon.getName() + " has " + mon.getHP() + " HP, and attacks for " + mon.attack() + " damage.");
        
       
        do{
            System.out.println( "Add an ability:\n1. Fire.\n2. Ice\n3. Electro.\n4. Quit." );

            userInput = CheckInput.getIntRange(1,4);
            switch( userInput ){
                case 1: mon = new Fire(mon);
                System.out.println(mon.getName() + " has " + mon.getHP() + " HP, and attacks for " + mon.attack() + " damage.");
                break;
                case 2:
                mon = new Ice(mon);
                System.out.println(mon.getName() + " has " + mon.getHP() + " HP, and attacks for " + mon.attack() + " damage.");
                break;
                case 3:
                mon = new Electro(mon);
                System.out.println(mon.getName() + " has " + mon.getHP() + " HP, and attacks for " + mon.attack() + " damage.");
                break;
                case 4: break;
            }
        }while (userInput != 4);
        System.out.println("Game Over.");
    }
}
