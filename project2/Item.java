//Class holds Item's name
public class Item implements Cloneable{
    /**Item's name */
    private String name;
    /** */
    private int value;
    /** */
    private char type;

    /**
     * Constructor of an item
     * @param n item's name
     * @param v item's value in gold
     * @param t item's type
     */
    public Item(String n, int v, char t){
        name = n;
        value = v;
        type = t;
    }

    /**
     * get item's name for further use
     * @return string name item's name
     */
    public String getName(){
        return name;
    }

    /**
     * Get value of the item in order to sell
     * @return item's value
     */
    public int getValue(){
        return value;
    }

    /**
     * get type of the item
     * @return item's type in character
     */
    public char getType(){
        return type;
    }
}
