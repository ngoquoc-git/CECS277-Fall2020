import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
//Generate each enemy from a given text file
public class EnemyGenerator {
    
    private ArrayList<Enemy> enemyList;
    /** */
    private static EnemyGenerator instance = null;

    /**
     * 
     */
    private EnemyGenerator() {
        enemyList = new ArrayList<Enemy>();
        enemyList.add(new Froglock());
        enemyList.add(new Goblin());
        enemyList.add(new Orc());
        enemyList.add(new Troll());
    }

    /**
     * 
     * @return
     */
    public static EnemyGenerator getInstance(){
        if (instance == null) instance = new EnemyGenerator();
        return instance;
    }

    /**
     * 
     * @param
     * @return 
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
