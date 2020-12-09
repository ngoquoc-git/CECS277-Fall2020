import java.util.Random;

public class Froglock extends Enemy {

    public Froglock() {
        super("Froglock ", 2, i);
    }

    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(6);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
