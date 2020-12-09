import java.util.Random;
//Enemy representation which is inherited from class Enity
public abstract class Enemy extends Entity{
    //item that enemy may hold
    private Item item;

    /**
     * Overloaded constructor
     * Hold Enemy information: name, maximum HP and item
     * @param n enemy's name
     * @param mHP enemy's maximum health points
     * @param i enemy's item
     */
    public Enemy(String name, int mHP, Item it) {
        super(name, mHP);
        item = it;
	}

	/**
     * return value of the item
     * @return item's value
     */
    public Item getItem(){
        return item;
    }

    /**
     *
     */    
    public abstract String attack(Entity e);
}
