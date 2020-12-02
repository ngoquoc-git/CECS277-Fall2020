public class Memento {
    /**
     * 
     */
    private char[][] board;

    /**
     * 
     * @param b
     */
    public Memento(char[][] b){
        for(int i = 0; i < b.length; i++){
            for (int j = 0; j < b[i].length; j++){
                this.board[i][j] = b [i][j];
            }
        }
    }

    /**
     * 
     * @return
     */
    public char[][] getState(){
        return board;
    }
}
