import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("Welcome to the Escape Room.");
        System.out.println("You must unlock 3 doors to escape...");

        for (int i = 0; i < 3; i++) {

            Door d;
            int door = (int) (Math.random() * 5) + 1;

            if (door == 1) {
                d = new BasicDoor();
                openDoor(d);
            } else if (door == 2) {
                d = new LockedDoor();
                openDoor(d);
            } else if (door == 3) {
                d = new DeadboltDoor();
                openDoor(d);
            } else if (door == 4) {
                d = new ComboDoor();
                openDoor(d);
            } else if (door == 5) {
                d = new CodeDoor();
                openDoor(d);
            }
        }

        System.out.println("Congratulations! You escaped...this time.");
    }

    public static void openDoor(Door d){
        Scanner sc = new Scanner(System.in);
        int decision;

        System.out.print(d.examine());
        System.out.print(d.menu());
        while (!d.open()){
            decision = sc.nextInt();
            d.unlock(decision);
            if(!d.open()) System.out.print(d.clue());
            else System.out.print(d.success());
        }
    }
}