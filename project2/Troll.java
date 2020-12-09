import java.util.Random;

/** Troll class extends from Enemy, Troll is an Enemy*/
public class Troll extends Enemy {

    /**
     * Troll constructor construct the health and name of Troll and generates item  
     */
    public Troll() {
        super("Troll ", 5, ItemGenerator.getInstance().generateItem());
    }

    /**
     * attack action method 
     * @param e Enity that will be attacked
	 * @return the name of the Enemy plus the amount of damage in a string 
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(4);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
