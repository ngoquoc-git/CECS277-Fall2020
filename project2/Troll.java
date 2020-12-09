import java.util.Random;

/** */
public class Troll extends Enemy {

    /**
     * 
     */
    public Troll() {
        super("Troll ", 5, ItemGenerator.getInstance().generateItem());
    }

    /**
     * 
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
