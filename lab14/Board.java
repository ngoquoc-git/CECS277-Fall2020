/**
* this class creates a board for the game tic tac toe
*/
public class Board {
    /**
     * creates a board based on a 2D array for the game
     */
    private char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};

    /**
     * allows the player to choose where the token, x or o, will
     * be placed on the array, Board
     * @param token a character that is either x or o to be placed on 
     * the game Board
     * @param row the row number on the board to place the token
     * @param col the column number on the board to place the token
     * @return if the space is not taken on the board the value it true
     * if the space is taken it returns false
     */
    public boolean placeToken(char token, int row, int col){
        boolean isPlaced = false;
        if(board[row][col] == ' '){
            board[row][col] = token;
            return true;
        }
        return isPlaced;
    }

    /**
     * prints out the border, column and row number, for the
     * tic tac toe game
     */
    public void display(){
        System.out.println(" 0  1  2");
        System.out.println(" --------");
        for (int i = 0; i < board.length; i++){
            System.out.print(i + "|");
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println(" --------");
    }

    /**
     * Saves the board in the current state with characters on it
     * @return returns the current board with character on it
     */
    public Memento save(){
        return new Memento(board);
    }

    /**
     * the state of the previous board is saved
     * @param m the prevoius state of the board desired
     */
    public void restore(Memento m){
        board = m.getState();
    }

    /**
     * Check the winning conditions of the game
     * Either win or draw if the board is filled and no winners
     * @return character x for player 1 and o for player 2 or computer
     */
    public char winner(){
        boolean isFull = false;
        boolean isWin = false;
        boolean breakLoop = false;
        int i = 0, j = 0;
        int rw, cl;
        char winToken = ' ';

        //Check if the board is fully placed with tokens
        for (; i < board.length; i++){
            for(; j < board[i].length; j++){
                if (board[i][j] == ' ') break;
            }
            if (board[i][j] == ' ') {
                breakLoop = true;
                break;
            }
        }
        if (breakLoop == false) isFull = true;

        //Check win condition horizontally
        for (rw = 0; rw < 3; rw++){
            if(board[rw][0] == board[rw][1] && board[rw][0] == board[rw][2] && board[rw][0] != ' '){
                isWin = true;
                winToken = board[rw][0];
                break;
            }
        }
        //Check win condition vertically
        for (cl = 0; cl < 3; cl++){
            if(board[0][cl] == board[1][cl] && board[0][cl] == board[2][cl] && board[0][cl] != ' '){
                isWin = true;
                winToken = board[0][cl];
                break;
            }
        }
        //Check win condition diagonally
        if(board[1][1] == board[0][0] && board[1][1] == board[2][2] && board[1][1] != ' '){
            isWin = true;
            winToken = board[1][1];
        }
        if(board[1][1] == board[0][2] && board[1][1] == board[2][0] && board[1][1] != ' '){
            isWin = true;
            winToken = board[1][1];
        }

        if(isWin == true) return winToken;
        if(isFull == true) return 'c';
        return ' ';
    }
}