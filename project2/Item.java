public class Item {
    /**Item's name */
    private String name;

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
}
