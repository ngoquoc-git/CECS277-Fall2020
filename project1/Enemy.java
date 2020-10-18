import java.util.Random;
public class Enemy extends Entity{
    private Item item;

    /**
     * Default constructor
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
        if (damage == 0) return "Enemy hits you, but it is missed";
        return getName() + " hits you and does " + damage + " damages.\n";
    }
}
