import java.util.Scanner;
public abstract class Cat {
    
    /**
     * Cat's name
     */
    private String name;

    /**
     * Cat's hunger levels that determine its action
     * Hunger levels are between 0-10
     */
    private int hunger;

    /**
     * Overloaded constructor Cat is created 
     * @param n gets teh name of the cat
     */
    public Cat(String n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name your kitty: ");
        n = sc.nextLine();
        name = n;
        hunger = 6;
    }
    /**
     * Get cat's name
     * @return string cat's name for displaying
     */
    public String getName(){
        return name;
    }

    /**
     * Cat hunger levels are used to determine cat's action
     * @return cat's hunger levels
     */
    public int getHunger(){
        return hunger;
    }
    
    /**
     * Adjust level of hunger based on player's action
     * @param val different actions leads to different values
     * @return int current hunger
     */
    protected int incrementHunger(int val){
        hunger += val;
        if (hunger < 1) return 1;
        else if (hunger > 10) return 10;
        else return hunger;
    }

    /**
     * display cat's current state based on hunger levels
     * return String representations of hunger levels
     */
    public String toString(){
        if(hunger > 0 && hunger <5) return name + " is hungry";
        else if (hunger < 9)  return name + " is satisfied";
        else return name + " is full";
    }

    /**
     * Player feeds cat
     * @param P the player
     */
    public abstract String feed(Player P);

    /**
     * Player plays with cat
     * @param P the player
     */
    public abstract String play(Player p);

    /**
     * Player pets cat
     * @param P the player
     */
    public abstract String pet(Player p);
}
