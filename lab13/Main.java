public class Main {
    public static void main(String[] args){
        int dec;
        Puppy pup = new Puppy();

        System.out.println("Congratulations on your new puppy!");
        System.out.println("What would you like to do?\n1. Feed.\n2. Play.");
        dec = CheckInput.getIntRange(1, 2);

        do{
            if(dec == 1) pup.feedPuppy();
            else if (dec == 2) pup.playWithPuppy();
            else System.out.println("Game Over.");
            System.out.println("What would you like to do?\n1. Feed.\n2. Play.\n3. Quit.");
            dec = CheckInput.getIntRange(1, 3);
        }while(dec != 3);
    }
}
