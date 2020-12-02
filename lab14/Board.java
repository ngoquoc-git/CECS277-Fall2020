public class Board {
    /**
     * 
     */
    private char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};

    /**
     * 
     * @param token
     * @param row
     * @param col
     * @return
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
     * 
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
     * 
     * @return
     */
    public Memento save(){
        return new Memento(board);
    }

    /**
     * 
     * @param object
     */
    public void restore(Memento m){
        board = m.getState();
    }

    /**
     * 
     * @return
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