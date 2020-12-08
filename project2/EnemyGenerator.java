import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
//Generate each enemy from a given text file
public class EnemyGenerator {
    //Enemies that are read from EneemyList text file
    private ArrayList<Enemy> enemyList;
    // generate item to pass to enemy
    private static ItemGenerator ig;
    /** */
    private static EnemyGenerator instance = null;

    /**
     * Overloaded Constructor 
     * Get enemy from the nenemy list create them by given information
     * @param ig pass items to enemy
     */
    private EnemyGenerator(ItemGenerator ig) {
        EnemyGenerator.ig = ig;
        enemyList = new ArrayList<>();
        File enemyGene = new File("EnemyList.txt");
        try {
            Scanner enemy = new Scanner(enemyGene);
            while (enemy.hasNextLine()) {
                String properties = enemy.nextLine();
                String[] enemyInfo = properties.split(",");
                if (enemyInfo[2].equals("m")) {
                    Enemy magicE = new MagicalEnemy(enemyInfo[0], Integer.parseInt(enemyInfo[1]),
                            EnemyGenerator.ig.generateItem());
                    enemyList.add(magicE);
                } else {
                    //Enemy physE = new Enemy(enemyInfo[0], Integer.parseInt(enemyInfo[1]), EnemyGenerator.ig.generateItem());
                    //enemyList.add(physE);
                }
            }
            enemy.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     */
    public static EnemyGenerator getInstance(){
        if (instance == null) instance = new EnemyGenerator(ig);
        return instance;
    }

    /**
     * 
     * @return 
     */
    public Enemy generateEnemy(int level){
        return null;
    }
}
