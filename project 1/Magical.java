public interface Magical {
    public static final String MAGIC_MENU = "1. Magical Missile.\n2. Fire Ball.\n3. Thunderclap.\n";

    /**
     * Use magical missile on entity e
     * @param e Enity that will be attacked
     * @return
     */
    public String magicalMissile(Entity e);
    
    /**
     * Use fire ball on entity e
     * @param e Enity that will be attacked
     * @return
     */
    public String fireBall(Entity e);

    /**
     * Use thunder clap on entity e
     * @param e Enity that will be attacked
     * @return
     */
    public String thunderClap(Entity e);
}
