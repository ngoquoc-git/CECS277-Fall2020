import java.util.Random;

public abstract class EnemyDecorator extends Enemy{
    
    /** */
    private Enemy en;
    
    /**
     * 
     * @param enemy
     * @param name
     * @param mHP
     */
    public EnemyDecorator(Enemy enemy, String name, int mHP){
        super(name, mHP, enemy.getItem());
        en = enemy;
    }

    /**
     * 
     * @param e
     * @return
     */
    public String attack(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(8);
        e.takeDamage(damage);
        if (damage == 0) return en.getName() + " hits you, but it is missed";
        return en.getName() + " hits you and does " + damage + " damages.\n";
    }
}
