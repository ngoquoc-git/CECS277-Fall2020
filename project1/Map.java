import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Map {
    /** Create an axb map */
    private char[][] map;

    private boolean[][] revealed;

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
          } catch (FileNotFoundException e) {
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
        char loc = map[p.x][p.y];
        return loc;
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

    //Point findStart(){
    //    return p;
    //}


}
