import java.util.Scanner;
public class Main{
    
    /**
     * The Cat Game is executed here
     * Create player and cat
     * @param args no argument will be provided
     */
    public static void main(String[] args){
        Cat myCat;
        Player player = new Player();
        Scanner scan = new Scanner(System.in);
        String catName;
        int catType = 0;

        System.out.println("Choose a kitty: ");
        System.out.println("1.Tabby Cat\n2.Ocelot\n3.Tiger");
        catType = scan.nextInt();
        System.out.println("Name your kitty: ");
        catName = CheckInput.getString();

        while (catType > 3 || catType < 1){
            System.out.print("Invalid Input, please try again: ");
            catType = scan.nextInt();
        }

        switch(catType){
            case 1: myCat = new Tabby(catName); while (!player.isDead()) interactCat(myCat, player); break;
            case 2: myCat = new Ocelot(catName); while (!player.isDead()) interactCat(myCat, player); break;
            case 3: myCat = new Tiger(catName); while (!player.isDead()) interactCat(myCat, player); break;
            default: break;
        }
    }

    public static void interactCat(Cat cat, Player player){
        int playerDecision;
        String catStatus = "";

        System.out.println(player.toString());
        System.out.println(cat.toString());
        System.out.println("1.Feed your cat\n2.Play with your cat\n3.Pet your cat");
        playerDecision = CheckInput.getIntRange(1,3);

        switch(playerDecision){
            case 1: catStatus = cat.feed(player); break;
            case 2: catStatus = cat.play(player); break;
            case 3: catStatus = cat.pet(player); break;
            default: break;
        }

        System.out.println(catStatus);
    }
}