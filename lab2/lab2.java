/**
 *
 * @author Quoc Ngo
 */

import java.util.*;
import java.util.Scanner;

public class CECS277 {

    public static void main(String[] args) {

    // Declare all variables
    Scanner sc = new Scanner(System.in); // controller
    char bug = 'o', trail = 'X', direction = '.', finish = 'f';
    char moves;
    int x = 0, y = 0, pos = 0;
    //Create a 10x10 maze
    char [][] gridss = {{'.', '.', 'X', '.', '.', '.', '.', '.', '.', '.'},
                  {'X', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '.', 'X', '.', 'X', '.'},
                  {'.', '.', 'X', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', 'X', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '.', 'X', '.', '.', '.'},
                  {'.', '.', '.', 'X', '.', '.', '.', '.', 'X', '.'},
                  {'.', '.', '.', '.', '.', 'X', '.', '.', '.', '.'},
                  {'.', 'X', 'X', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};;
    gridss [x][y] = bug;
    gridss [9][9] = finish;
    
    displayMap(gridss);
    
    //Check if bug hits the finish point
    while (pos != 18){
        //Take inputs  
          System.out.print("\n...\nW. Up\nA. Left\nS. Down\nD. Right\nWhich Direction:");
          moves = sc.next().charAt(0);
        gridss[x][y] = trail;
        switch(moves){
          case 'W': x--; break;
          case 'S': x++; break;
          case 'D': y++; break;
          case 'A': y--; break;
        } 

        //Out of bounds Detection
        if(x > 9){ 
          System.out.println("Invalid input.");
          x--;
        }
        else if(y > 9){
          System.out.println("Invalid input.");
          y--;
        }
        else if(x < 0){
          System.out.println("Invalid input.");
          x++;
        }
        else if(y < 0){
          System.out.println("Invalid input.");
          y++;
        }
        
        //Hit the obstacle fouls
        while (gridss[x][y] == 'X' && x != 0 && y != 0){
          switch(moves){
          case 'W': {
            gridss[x+1][y] = '.';
            x++;} break;
          case 'S': {
            gridss[x-1][y] = '.';
            x--;} break;
          case 'D': {
            gridss[x][y-1] = '.';
            y--;} break;
          case 'A': {
            gridss[x][y+1] = '.';
            y++;} break;
          }

          System.out.println("Invalid input.");
        }
        
        gridss[x][y] = bug;
        direction = gridss[x][y];
        pos = x + y;
        displayMap(gridss); 
   }
   System.out.println("You Win!");
}
  public static void displayMap(char[][] arr){
    //resusable for loop to integrate print statement each time user input is detected
    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[i].length; j++){
        System.out.print(arr[i][j] + "\t");
      }
      System.out.print("\n");
    }
  }
}
