/** WarriorDecorator class that extends from EnemyDecorator , warrior is an 			enemy*/
public class WarriorDecorator extends EnemyDecorator{
    
    /**
     * WarriorDecorator constructor gets the name of the Enemy and the max healthpoints 
     * @param enemy
     */
    public WarriorDecorator(Enemy enemy) {
        super(enemy, enemy.getName() + "Warrior ", enemy.getMaxHP() + 2);
    }

    /**
     * attack action method 
	 * @param e - Enity that will be attacked 
	 * @return the attack of the entity
     */
    public String attack(Entity e){
        return super.attack(e);
    }
    
}
