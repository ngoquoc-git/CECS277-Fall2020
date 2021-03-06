import java.util.Random;

/** Froglock class that extends from Enemy , Froglock is an Enemy */
public class Froglock extends Enemy {

    /**
     * Froglock constructor construct the health and name of Froglock and generates item 
     */
    public Froglock() {
        super("Froglock ", 5, ItemGenerator.getInstance().generateItem());
    }

    /**
     * attack action method 
     * @param e Enity that will be attacked
	 * @return the name of the Enemy plus the amount of damage in a string 
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(6);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
