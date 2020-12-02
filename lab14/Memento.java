/**
* this class allows the board to revert back to its previous state
*/
public class Memento {
    /**
     * 3x3 char array to store the state of the board
     */
    private char[][] board = new char[3][3];

    /**
     * places the charaters that were previously on the board
     * and makes a copy of the array
     * @param b passes a board to store
     */
    public Memento(char[][] b){
        for(int i = 0; i < b.length; i++){
            for (int j = 0; j < b[i].length; j++){
                this.board[i][j] = b[i][j];
            }
        }
    }

    /**
     * shows the character array of the board
     * @return board returns the char array
     */
    public char[][] getState(){
        return board;
    }
}
