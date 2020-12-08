import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Generate Item from a given Item text file
public class ItemGenerator extends Item{
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
                Item currItem = new Item(items.nextLine());
                itemList.add(currItem);
            }
            items.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private ItemGenerator(ItemGenerator ig){

    }

    /**
     * 
     */
    @Override
    public Item clone(){
        return new ItemGenerator(getInstance());
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
     * Call a random item from itemList in order to pass to an enemy 
     * @return a random item
     */
    public Item generateItem(){
        Random rand = new Random();
        int itemGen = rand.nextInt(itemList.size());
        Item item = new Item(itemList.get(itemGen).getName());
        return item;
    }


}
