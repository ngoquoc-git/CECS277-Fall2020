//Quoc Ngo
//Alnahwi Abdullah
//CECS227-lab4

import java.util.ArrayList;
import java.util.Scanner;
class Main {
  
  /**
   * main method is used to run the program
   * the grid, ArrayList Rectangles, and rectangele representation is created
   * a new data type Rect is used
   * @param args does not need to be used in the command line
   */
  public static void main(String[] args) {
    // initiate variables
    Scanner sc = new Scanner(System.in);
    ArrayList <Rect> Rectangles = new ArrayList <Rect>();
    final int gridCols = 30, gridRows = 30;
    char [][] grid = new char [gridRows][gridCols];
    char[] rectRep = {'O', 'X', '*', '!', '#'};
    int countRects;
    

    //Adds '.' to the array grid
    for (int i = 0; i < gridRows; i++){
      for (int n = 0; n < gridCols; n++){
        grid[i][n] = '.';
      }
    }
  
    System.out.print("\nHow many rectangles would you like to draw (1-5)? ");
    countRects = getIntRange(1,5);
      
    for (int i = 1; i<= countRects; i++){
      Rectangles.add(getRect(i));
      fillRect(grid, Rectangles.get(i-1), rectRep[i-1]);
    }
    
    //display grid
    displayGrid(grid);
  }

/**
 *displays the grid for the rectangles 
 *@param grids
 */
  public static void displayGrid(char[][] grids){
    final int gridCols = 30, gridRows = 30; 
    for (int i = 0; i < gridRows; i++){
      for (int n = 0; n < gridCols; n++){
        System.out.print(grids[i][n]);
      }
      System.out.println();
    }
  }

/**
 *promts the user to input values for x , y width and height 
 *@param thisRect
 */
  public static Rect getRect(int thisRect){
    Scanner sc = new Scanner(System.in);
    int x = 0, y = 0, width = 0, height = 0;
    System.out.print("\nPlease enter x location of rectangle " + thisRect + " (1-30): ");
    x = getIntRange(1, 30);
    System.out.print("\nPlease enter y location of of rectangle " + thisRect + " (1-30): ");
    y = getIntRange(1, 30);
    System.out.print("\nPlease enter the width of rectangele " + thisRect + "(1-" + (30 - x + 1) + "): ");
    width = getIntRange(1, 30 - x + 1);
    System.out.print("\nPlease enter the height of rectangle " + thisRect + " (1-" + (30 - y + 1) +"): ");
    height = getIntRange(1, 30 - y + 1);

    Rect r = new Rect(x, y, width, height);
    return r;
  }
  
  /**
   *fills in the 2d array with characters 
   *@param recatngles
   *@param grid
   *@param c : characters
   *@return users input 
   */
  public static void fillRect(char grid[][], Rect Rectangles, char c){
    for (int i = 0; i<Rectangles.getWidth(); i++){
      for(int j = 0; j<Rectangles.getHeight(); j++){
        grid[(Rectangles.getY()-1) + j][(Rectangles.getX()-1) + i] = c;
      }
    }
  }
  
  /** 
   *method that set the limit of inputs
   *@param low the lowest possible input
   *@param high the highest possible input
   *@return input take the input as a scanner
   */
  public static int getIntRange(int low, int high) {
    Scanner sc = new Scanner(System.in);
    int input = 0;
    boolean valid = false;
    while (!valid) {
      if (sc.hasNextInt()) {
        input = sc.nextInt();
        if (input <= high && input >= low) {
          valid = true;
        } 
        else {
          System.out.print("Invalid Input, try again: ");
        }
      } 
      else {
        sc.next(); 
        System.out.print("Invalid Input, try again: ");
        valid = false;
      }
    }
    return input;
  }
}

