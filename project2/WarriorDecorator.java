import java.util.Random;

/**
 * 
 */
public abstract class WarriorDecorator extends Enemy{

    /** */
    private Enemy em;

    /**
     * 
     * @param enemy
     * @param n
     * @param mHP
     * @param i
     */
    public WarriorDecorator(Enemy enemy, String n, int mHP, Item i) {
        super("Warrior " + n, mHP + 2, i);
        em = enemy;
    }

    public String attack(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(8);
        e.takeDamage(damage);
        if (damage == 0) return getName() + " hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
    
}
