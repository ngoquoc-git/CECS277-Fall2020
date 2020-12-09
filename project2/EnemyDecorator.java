import java.util.Random;

/** abstract class EnemyDecorator which extends from Enemy */
public abstract class EnemyDecorator extends Enemy{
    
    /** instance variable en which represent enemy */
    private Enemy en;
    
    /**
     * EnemyDecorator constructor - create a template for Warlock and Warrior
     * @param enemy - the enemy
     * @param name - enemy's name
     * @param mHP - enemy's initial health points
     */
    public EnemyDecorator(Enemy enemy, String name, int mHP){
        super(name, mHP, enemy.getItem());
        en = enemy;
    }

    /**
     * Attack action that deal damage to an entity
     * @param e entity that will take damage
     * @return attack status in String
     */
    public String attack(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(8);
        e.takeDamage(damage);
        if (damage == 0) return en.getName() + " hits you, but it is missed";
        return en.getName() + " hits you and does " + damage + " damages.\n";
    }
}
