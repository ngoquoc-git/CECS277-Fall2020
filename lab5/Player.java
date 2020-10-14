/** 
 * Player class - player representation 
*/
public class Player {
    
    /** 
     * A set of dice(s) will be played by the player 
    */
    private Die[] dices;

    /** 
     * Point(s) that the player will get after rolling the dice(s) 
    */
    private int points;
    
    /** 
     * Constructor - Create a play with 3 dices and 0 points 
    */
    public Player(){
        final int noOfDices = 3;
        dices = new Die[noOfDices];
        Die dice;
        for (int i = 0; i < noOfDices; i++){
            dice = new Die();
            dices[i] = dice;
        }
        points = 0;
    }

    /** 
     * Sort the value of dices in ascending order
     */
    public void sort(){
        for (int i = 0; i < dices.length; i++){
            int min = i;
            for (int j = i + 1; j < dices.length; j++){
                if(dices[j].lessThan(dices[min].getDieValue())){
                    min = j;
                }
            }
            Die temp = dices[min];
            dices[min] = dices[i];
            dices[i] = temp;
        }
    }

     /** 
     * Check if the three dices have the same value
     * 
     * @return boolean - true if they are the same, false otherwise
     */

    /**public boolean threeOfaKind(){
        boolean die1ToDie2 = dices[0].equals(dices[1].getDieValue());
        boolean die2ToDie3 = dices[1].equals(dices[2].getDieValue());
        if (die1ToDie2 && die2ToDie3){
            points += 3;
            return true;
        } else{
            return false;
        }
    }*/

    /** 
     * Check if any two dices have the same value
     * 
     * @return boolean - true if any two dices' value are the same, false otherwise
     */
    public boolean twoOfaKind(){
        boolean die1ToDie2 = dices[0].equals(dices[1].getDieValue());
        boolean die2ToDie3 = dices[1].equals(dices[2].getDieValue());
        boolean die1ToDie3 = dices[0].equals(dices[2].getDieValue());
        if (die1ToDie2 || die2ToDie3 || die1ToDie3){          
            points += 1;
            return true;
        }else {
            return false;
        }
    }
    /**
     * Check if the results are in a series
     * 
     * @return boolean - true if the dices' values are in a series
     */
    public boolean series(){
        sort();
        if ((dices[1].getDieValue() - dices[0].getDieValue() == 1) && (dices[2].getDieValue() - dices[0].getDieValue() == 2)){
            points += 2;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Archive player's points
     * 
     * @return int - player's points
     */
    public int getPoints(){
        return points;
    }

    /** 
     * Value of every dice in String
     * 
     * @return String - dice's value
     */
    public String toString(){
        String diceVal = "";
        for (int i = 0; i < dices.length; i++){
            diceVal = diceVal + "D" + (i+1) + ": " + dices[i] + " ";
        }
        return diceVal;
    }

    /**
     * Rolls three dices 
     * Print out the result associates to a spoecific winning condition
     */
    public void takeTurn(){
        for (int i = 0; i < dices.length; i++) {
            dices[i].roll();
        }
        sort();
        System.out.print("Rolling Dice..." + toString());

        if (twoOfaKind()){
            System.out.println("You got a pair!");
            System.out.println("Score = " + points + " points");
        }
        else if(threeOfaKind()){
            System.out.println("You got three of a kind!");
            System.out.println("Score = " + points + " points");
        }
        else if(series()){
            System.out.println("You got a series of 3!");
            System.out.println("Score = " + points + " points");
        }
        else{
            System.out.println("Awww. Too Bad.");
            System.out.println("Score = " + points + " points");
        }
    }
    public boolean threeOfaKind(){
        return (this.dices[2].getDieValue() - this.dices[1].getDieValue() - this.dices[0].getDieValue()) == (this.dices[2].getDieValue() * -1);
    }
    //public boolean twoOfKind(){

    //}
}
