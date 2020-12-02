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
        this.board = b;
    }

    /**
     * 
     * @return
     */
    public char[][] getState(){
        return board;
    }
}
