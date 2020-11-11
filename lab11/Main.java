import java.util.Random;
public class Main {
    public static void main(String[] args){
        DoorFactory doors = new DoorFactory();
        Random rand = new Random();
        int level = 1;
        int doorType = rand.nextInt(5) + 1;

        while (level < 4){
            System.out.println("You have reached level "+ level);
            doors.openDoor(doorType);
            level+=1;
            doorType = rand.nextInt(5) + 1;
        }

        System.out.println("Congratulation, you have successfully finish the escape room.");
    }
}
