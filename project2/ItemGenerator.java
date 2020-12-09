import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Generate Item from a given Item text file
public class ItemGenerator{
    //** */
    private static ItemGenerator instance = null;
    //Items are stored here after being read from ItemList text file
    private ArrayList<Item> itemList;

    /**
     * Default Constructor
     * Read through ItemList.txt file and pass each item to itemList
     */
    private ItemGenerator(){
        itemList = new ArrayList<Item>();
        File readItem = new File("ItemList.txt");
        try{
            Scanner items = new Scanner(readItem);
            while(items.hasNextLine()){
                String read = items.nextLine();
                String[] splitStr = read.split(",");
                itemList.add(new Item(splitStr[0], Integer.parseInt(splitStr[1]), splitStr[2].charAt(0))); 
            }
            items.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     */
    public static ItemGenerator getInstance(){
        if (instance == null) instance = new ItemGenerator();
        return instance; 
    }

    /**
     * 
     * @return
     */
    public Item generateItem(){
        Random rand = new Random();
        int itemGen = rand.nextInt(itemList.size());
        return (Item) itemList.get(itemGen).clone();
    }

    /**
     * 
     * @return
     */
    public Item getPotion() {
        Item potion = new Item(null, 0, ' ');
        for(int i=0; i < itemList.size(); i++) {
            if(itemList.get(i).getType() == 'p') {
                potion = itemList.get(i);
            }
        }
        return potion;   
    }
    
    /**
     * 
     * @return
     */
    public Item getKey() {
        Item key = new Item(null, 0, ' ');
        for(int i=0; i < itemList.size(); i++) {
            if(itemList.get(i).getType() == 'p') {
                key = itemList.get(i);
            }
        }
        return key;   
    }
}
