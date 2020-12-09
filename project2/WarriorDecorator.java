/** */
public class WarriorDecorator extends EnemyDecorator{

    public WarriorDecorator(Enemy enemy) {
        super(enemy);
    }

    public String attack(Entity e){
        return super.attack(e);
    }
    
}
