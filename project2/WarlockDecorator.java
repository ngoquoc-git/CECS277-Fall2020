import java.util.Random;

/** */
public abstract class WarlockDecorator extends Enemy implements Magical {
    
    /** */
    private Enemy em;

    /**
     * 
     * @param enemy
     * @param n
     * @param mHP
     * @param i
     */
    public WarlockDecorator(Enemy enemy, String n, int mHP, Item i) {
        super(n, mHP+1, i);
        em = enemy;
    }
    
    /**
     * 
     * @param
     * @return
     */
    public String attack(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(3) + 1;
        String magicalAttack;
        
        if(damage == 1) magicalAttack = magicalMissile(e);
        else if (damage == 2) magicalAttack = fireBall(e);
        else magicalAttack = thunderClap(e);

        return magicalAttack;
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
