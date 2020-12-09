import java.util.Random;

/**WarlockDecorator class whoich extends EnemyDecorator and implements Magical */
public class WarlockDecorator extends EnemyDecorator implements Magical {

    /**
     * WarlockDecorator Constructor gets the name of the enemy and max health 	 points 
     * @param enemy - the enemy
     */
    public WarlockDecorator(Enemy enemy) {
        super(enemy, enemy.getName() + "Warlock ", enemy.getMaxHP()+1);
    }

    /**
     * attack action method 
     * @param e Enity that will be attacked
	 * @return the attack of the entity
     */
    public String attack(Entity e){
        return super.attack(e);
    }

    /**
     * Use magical missile on entity e
     * @param e Enity that will be attacked
     * @return string status of the magical missile attack
     */
    public String magicalMissile(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(e.getMaxHP()) + 1;
        e.takeDamage(damage);
        return getName() + " concentrates its mana and launch magical missiles that deals " + damage + " damages on " + e.getName();
    }
    
    /**
     * Use fire ball on entity e
     * @param e Enity that will be attacked
     * @return string status of the fire ball attack
     */
    public String fireBall(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(e.getMaxHP()) + 1;
        e.takeDamage(damage);
        return getName() + " throw a fire ball, it burns " + e.getName() + " for "+ damage + " damages.\n";
    }

    /**
     * Use thunder clap on entity e
     * @param e Enity that will be attacked
     * @return string status of the thunder clap attack
     */
    public String thunderClap(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(e.getMaxHP()) + 1;
        e.takeDamage(damage);
        return getName() + " throw a fire ball, it burns " + e.getName() + " for "+ damage + " damages.\n";
    }
}
