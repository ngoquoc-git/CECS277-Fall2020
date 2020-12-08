//Class holds Item's name
public class Item {
    /**Item's name */
    private String name;
    /** */
    private int value;
    /** */
    private char type;

    /**
     * Pass item's name to the Sring name
     * @param name Item's name
     */
    public Item(String name){
        this.name = name;
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
