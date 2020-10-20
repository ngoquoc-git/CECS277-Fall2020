import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
public class EnemyGenerator {
    
    private ArrayList<Enemy> enemyList;

    private ItemGenerator ig;

    /**
     * Overloaded Constructor
     * Get enemy from the nenemy list
     * create them by given information
     * @param ig pass items to enemy
     */
    public EnemyGenerator(ItemGenerator ig){
        this.ig = ig;
        enemyList = new ArrayList<>();
        File enemyGene = new File("EnemyList.txt");
        try{
            Scanner enemy = new Scanner(enemyGene);
            while(enemy.hasNextLine()){
                String properties = enemy.nextLine();
                String[] enemyInfo = properties.split(",");
                if(enemyInfo[2] == "m"){
                    Enemy magicE = new MagicalEnemy(enemyInfo[0], Integer.parseInt(enemyInfo[1]), ig.generateItem());
                    enemyList.add(magicE);
                }
                else{
                    Enemy physE = new Enemy(enemyInfo[0], Integer.parseInt(enemyInfo[1]), ig.generateItem());
                    enemyList.add(physE);
                }
            }


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
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
            Enemy physE = new Enemy(enemyList.get(enemyGen).getName(), enemyList.get(enemyGen).getMaxHP(), enemyList.get(enemyGen).getItem());
            return physE;
        }
    }
}
