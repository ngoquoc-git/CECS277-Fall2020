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
        super(n, mHP + 2, i);
        em = enemy;
    }

    public String attack(Entity e){
        //e.takeDamage(2);
        return null;
    }
    
}
