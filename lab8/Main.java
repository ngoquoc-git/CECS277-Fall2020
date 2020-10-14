import java.util.Scanner;
public class Main{
    public static void main(String[] args){

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