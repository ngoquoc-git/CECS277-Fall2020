import java.util.Scanner;
public class Cat {
    
    private String name;
    private int hunger;

    /**
     * Constructor Cat is created 
     * @param n gets name of the cat
     * @return
     */
    publlic Cat(String n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name your kitty: ");
        n = sc.nextLine();
        name = n;
    }

    public String getName(){
        return name;
    }

    public getHunger(){
        return hunger;
    }

    protected incrementHunger(int val){

    }

    public String toString(){

    }

    public abstract String feed(Player P){

    }

    public abstract String play(Player p){

    }

    public abstract String pet(Player p){

    }
}
