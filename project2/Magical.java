// Interface holds Magical attacks for hero and enemies
public interface Magical {
    
    //Show magic skills to be used
    public static final String MAGIC_MENU = "1. Magical Missile.\n2. Fire Ball.\n3. Thunderclap.\n";

    /**
     * Use magical missile on entity e
     * @param e Enity that will be attacked
     * @return string status of the magical missile attack
     */
    public String magicalMissile(Entity e);
    
    /**
     * Use fire ball on entity e
     * @param e Enity that will be attacked
     * @return string status of the fire ball attack
     */
    public String fireBall(Entity e);

    /**
     * Use thunder clap on entity e
     * @param e Enity that will be attacked
     * @return string status of the thunder clap attack
     */
    public String thunderClap(Entity e);
}
