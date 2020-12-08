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
                    Enemy physE = new Enemy(enemyInfo[0], Integer.parseInt(enemyInfo[1]), EnemyGenerator.ig.generateItem());
                    enemyList.add(physE);
                }
            }
            enemy.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static EnemyGenerator getInstance(){
        if (instance == null) instance = new EnemyGenerator(ig);
        return instance;
    }

    /**
     * Call a random enemy from the enemyList
     * Magical enemy may get stronger if its level is higher
     * @return either a physical enemy or a magical enemy
     */
    public Enemy generateEnemy(int level){
        Random rand = new Random();
        int enemyGen = rand.nextInt(enemyList.size());

        if(enemyList.get(enemyGen) instanceof MagicalEnemy){
            Enemy magicE = new MagicalEnemy(enemyList.get(enemyGen).getName(), enemyList.get(enemyGen).getMaxHP() + level, enemyList.get(enemyGen).getItem());
            return magicE;
        }
        else{
            Enemy physE = new Enemy(enemyList.get(enemyGen).getName(), enemyList.get(enemyGen).getMaxHP() + level, enemyList.get(enemyGen).getItem());
            return physE;
        }
    }
}
