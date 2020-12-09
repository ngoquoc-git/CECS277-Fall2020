import java.util.Random;

public class Orc extends Enemy {


    public Orc() {
        super("Orc ", 5, ItemGenerator.getInstance().generateItem());
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
