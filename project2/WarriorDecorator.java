/** */
public class WarriorDecorator extends EnemyDecorator{

    /**
     * 
     * @param en
     * @param name
     * @param mHP
     */
    public WarriorDecorator(Enemy en, String name, int mHP) {
        super(en, en.getName + "Warrrior ", mHP+2);
    }

    /**
     * 
     */
    public String attack(Entity e){
        return super.attack(e);
    }
    
}
