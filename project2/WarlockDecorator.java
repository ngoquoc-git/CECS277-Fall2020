import java.util.Random;

/** */
public class WarlockDecorator extends EnemyDecorator implements Magical {

    /**
     * 
     * @param en
     * @param name
     * @param mHP
     */
    public WarlockDecorator(Enemy en, String name, int mHP) {
        super(en, en.getName() + "Warlock ", mHP+2);
    }

    /**
     * 
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
