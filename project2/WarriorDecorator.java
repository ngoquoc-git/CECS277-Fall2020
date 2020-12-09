/** */
public class WarriorDecorator extends EnemyDecorator{
    
    /**
     * 
     * @param enemy
     */
    public WarriorDecorator(Enemy enemy) {
        super(enemy, enemy.getName() + "Warrior ", enemy.getMaxHP() + 2);
    }

    /**
     * 
     */
    public String attack(Entity e){
        return super.attack(e);
    }
    
}
