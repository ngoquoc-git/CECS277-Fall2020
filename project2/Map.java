import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Generate map fropm a given Map text file
public class Map {
    /** Create an axb map */
    private char[][] map;

    //location of that will be reveal
    private boolean[][] revealed;

    /** */
    private static Map instance = null;

    /**
     * Default constructor create a 5x5 map
     */
    private Map(){
        map = new char[5][5];
        revealed = new boolean[5][5];
    }

    /**
     * 
     * @return
     */
    public static Map getInstance(){
        if (instance == null) instance = new Map();
        return instance;
    }

    /**
     * Load the map based on given map numbers
     * @param mapNum determine which map will be loaded
     */
    public void loadMap(int mapNum){
        try {
            String mapLoad = "Map" + mapNum + ".txt";
            File mapReader = new File(mapLoad);
            Scanner myMap = new Scanner(mapReader);
            while (myMap.hasNextLine()) {
              for(int i = 0; i < map.length; i++){
                String line = myMap.nextLine().replace(" ", "");
                for (int j = 0; j < map.length; j++){
                    map[i][j] = line.charAt(j);
                    revealed[i][j] = false;
                }
              }
            }
          } 
          catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    /**
     * retrive the character at a specific location
     * @param p object's location x, y 
     * @return loc character at location x, y
     */
    public char getCharAtLoc(Point p){
        return map[p.x][p.y];
    }

    /**
     * Display the 5x5 map with given revealed positions
     * @param p object's location x, y
     */
    public void displayMap(Point p){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                if (i == p.x && j == p.y) System.out.print('*' + " ");
                else if(revealed[i][j]) System.out.print(map[i][j] + " ");
                else System.out.print('X' + " ");
            }
            System.out.println();
        }
    }

    /**
     * Find the strarting point by finding 's'
     * @return pt start point location
     */
    Point findStart(){
        Point pt = new Point(0,0);
        for(int i = 0; i< map.length; i++){
            for(int n = 0; n < map.length; n++){
                if(map[i][n] == 's'){
                    pt.x = i;
                    pt.y = n;
                }
            }
        }
        return pt;
    }

    /**
     * Set instance variable of boolean revealed of a specific location
     * @param p location of point that will be revealed
     */
    public void reveal(Point p){
        revealed[p.x][p.y] = true;
    }

    /**
     * remove a character at a location and replace to 'n'
     * @param p location of the removed character
     */
    public void removeCharAtLoc(Point p){
        map[p.x][p.y] = 'n';
    }
}
