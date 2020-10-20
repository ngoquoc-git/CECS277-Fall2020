import java.util.Random;
public class MagicalEnemy extends Enemy implements Magical{
    
    /**
     * Overloaded Constructor
     * create an enemy that deal magical attacks
     * @param n name of the magical enemy
     * @param mHP maximum heath points of the magiocal enemy
     * @param i item that this 
     */
    public MagicalEnemy(String n, int mHP, Item i){
        super(n, mHP, i);
    }

    /**
     * Methods that let magical enemies use their skills
     * @param e the entity that is being attacked
     * @return magicalAttack damages and attacks status
     */
    public String attack (Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(3) + 1;
        String magicalAttack;
        
        if(damage == 1) magicalAttack = magicalMissile(e);
        else if (damage == 2) magicalAttack = fireBall(e);
        else magicalAttack = thunderClap(e);

        return magicalAttack;
    }

    /**
     * Skill fire ball deals damage equals to entity's maxHP + 1
     * @param e the entity that will be attacked
     * @return fire ball attack status
     */
    @Override
    public String fireBall(Entity e){
        e.takeDamage(e.getMaxHP() + 1);
        return getName() + " throw a fire ball, it burns " + e.getName() + " for 6 damages.\n";
    }

    /**
     * Skill thunder clap deals damage equals to entity's maxHP
     * @param e the entity that will be attacked
     * @return thunder clap attack status
     */
    @Override
    public String thunderClap(Entity e){
        e.takeDamage(e.getMaxHP());
        return getName() + "'s hand are fully charged, it uses thunder clap and zap " + e.getName() + " for 4 damages.\n";
    }

    /**
     * Skill magical missiles deals damage equals to entity's maxHP + 2
     * @param e the entity that will be attacked
     * @return magical missiles attack status
     */
    @Override
    public String magicalMissile(Entity e) {
        e.takeDamage(e.getMaxHP() + 2);
        return getName() + " concentrates its mana and launch magical missiles that deals 9 damages on " + e.getName();
    }
}
