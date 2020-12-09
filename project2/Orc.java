import java.util.Random;

/**Orc class extends from Enemy, Orc is an Enemy */
public class Orc extends Enemy {

    /**
     * Orc constructor construct the health and name of Orc and  generates item 
     */
    public Orc() {
        super("Orc ", 5, ItemGenerator.getInstance().generateItem());
    }

    /**
     * attack action method 
     * @param e Enity that will be attacked
	 * @return the name of the Enemy plus the amount of damage in a string 
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(2);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
