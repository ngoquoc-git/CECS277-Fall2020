import java.util.Random;

public class Orc extends Enemy {

    public Orc(String n, int mHP, Item i) {
        super("Orc ", 6, i);
    }

    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(2);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
