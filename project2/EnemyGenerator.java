import java.util.ArrayList;
import java.util.Random;
/** Generate each enemy from a given text file */
public class EnemyGenerator {
    
    /** a List of Enemy that store 4 different kinds of enemy in the dungeon */
    private ArrayList<Enemy> enemyList;
    /** Instance variable instance is initialized null */
    private static EnemyGenerator instance = null;

    /**
     * EnemyGenerator construtor that adds Froglock, Goblin , Orc , Troll to the enemyList
     */
    private EnemyGenerator() {
        enemyList = new ArrayList<Enemy>();
        enemyList.add(new Froglock());
        enemyList.add(new Goblin());
        enemyList.add(new Orc());
        enemyList.add(new Troll());
    }

    /**
     * getInstance method gets the instance of EnemyGenerator
     * @return instance of new EnemyGenerator
     */
    public static EnemyGenerator getInstance(){
        if (instance == null) instance = new EnemyGenerator();
        return instance;
    }

    /**
      * generateEnemy method that create an enemy 
     * @param level - level determines enemy's power
     * @return en - enemy after being generated
     */
    public Enemy generateEnemy(int level){
        Random rand = new Random();
        int eg = rand.nextInt(enemyList.size());
        Enemy en = enemyList.get(eg);

        if (en instanceof Froglock) en = new Froglock();
        else if (en instanceof Goblin) en = new Goblin();
        else if (en instanceof Orc) en = new Orc();
        else return new Troll();

        if(level > 1){
            int type = rand.nextInt(2);
            if(type == 0) en = new WarlockDecorator(en);
            else en = new WarriorDecorator(en);
        }

        if(level > 2){
            int type = rand.nextInt(2);
            if(type == 0) en = new WarlockDecorator(en);
            else en = new WarriorDecorator(en);
        }
        return en;
    }
}
