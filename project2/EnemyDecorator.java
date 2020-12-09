import java.util.Random;

public abstract class EnemyDecorator {
    private Enemy en;
    private String n;
    private 
    public EnemyDecorator(Enemy enemy, String name, int mHP){
        en = enemy;
        
    }
    public String attack(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(8);
        e.takeDamage(damage);
        if (damage == 0) return en.getName() + " hits you, but it is missed";
        return en.getName() + " hits you and does " + damage + " damages.\n";
    }
}
