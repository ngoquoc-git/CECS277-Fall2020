import java.util.Random;
//Enemy representation which is inherited from class Enity
public class Enemy extends Entity{
    //item that enemy may hold
    private Item item;

    /**
     * Overloaded constructor
     * Hold Enemy information: name, maximum HP and item
     * @param n enemy's name
     * @param mHP enemy's maximum health points
     * @param i enemy's item
     */
    public Enemy(String n, int mHP, Item i){
        super(n, mHP);
        item = i;
    }

    /**
     * return value of the item
     * @return item's value
     */
    public Item getItem(){
        return item;
    }

    /**
     * Enemy attacks entity e
     * @param e entity that will be attcked
     * @return s String represents the attacking status 
     */
    @Override
    public String attack(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(8);
        e.takeDamage(damage);
        if (damage == 0) return "Enemy hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
}
