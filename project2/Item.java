//Class holds Item's name
public class Item implements Cloneable{
    /**Item's name */
    private String name;
    /** */
    private int value;
    /** */
    private char type;

    /**
     * 
     * @param n
     * @param v
     * @param t
     */
    public Item(String n, int v, char t){
        name = n;
        value = v;
        type = t;
    }

    /**
     * 
     */
    @Override
    public Cloneable clone(){
        return new Item(this);
    }

    /**
     * get item's name for further use
     * @return string name item's name
     */
    public String getName(){
        return name;
    }

    /**
     * 
     * @return
     */
    public int getValue(){
        return value;
    }

    /**
     * 
     * @return
     */
    public char getType(){
        return type;
    }
}
