public class Map {
    /** Create an axb map */
    private char[][] map;

    private boolean revealed;

    /**
     * Default constructor create a 5x5 map
     */
    public Map(){
        map = new char[5][5];
        
    }

    /**
     * 
     * @param mapNum
     */
    public void loadMap(int mapNum){

    }

    /**
     * retrive the character at a specific location
     * @param p object's location x, y 
     * @return loc character at location x, y
     */
    public char getCharAtLoc(Point p){
        char loc = map[p.x][p.y];
        return loc;
    }

    /**
     * 
     * @param p object's location x, y
     */
    public void displayMap(Point p){

    }

    Point findStart(){
        return p;
    }


}
