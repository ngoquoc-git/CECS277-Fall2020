import java.util.Random;

public class Troll extends Enemy {

    public Troll(String n, int mHP, Item i) {
        super("Troll ", 4, i);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(4);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
