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
        System.out.println("------");
        for (int i = 0; i < board.length; i++){
            System.out.print(i + "|");
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + "|");
            }
        }
        System.out.println("------");
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
     * @param m
     */
    public void restore(Memento m){
        board = m.getState();
    }

    public char winner(){
        
        return 'a';
    }
}