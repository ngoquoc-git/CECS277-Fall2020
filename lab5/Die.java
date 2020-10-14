/** 
 * Declare a die 
*/
public class Die {
    /** 
     * A die's number of sides 
    */
    private int sides;
    /** 
     * Value of the face-up side
    */
    private int dieValue;

    /** 
     * Default Constructor
     * A 6-sided dice
    */
    public Die(){
        sides = 6;
        roll();
    }

    /** 
     * Overload Constructor
     * 
     * @param s - Other dices have s number of sides
     */
    public Die(final int s) {
        if (s > 1) {
            sides = s;
        } else {
            sides = 6;
        }
        roll();
    }

    /** 
     * Roll the die
     * 
     * @return int - value of the face-up side of the die aftering being rolled
     */
    public int roll() {
        dieValue = (int) (Math.random() * sides) + 1;
        return dieValue;
    }

    /**
     * Get the value of the die
     * 
     * @return int - get the value of the face-up side of the die
     */
    public int getDieValue() {
        return dieValue;
    }

    /**
     * Check if the value of the die exceed the number of sides Make sure that the
     * value of the die cannot reach 0
     * 
     * @param value - value of the face-up side of the die
     * @return boolean - true if the value is within the sides limit
     */
    public boolean setDieValue(final int value) {
        return (value > 0 && value <= sides);
    }

    /**
     * Die's value in String
     * 
     * @return String - value of the die
     */
    public String toString() {
        return "" + dieValue;
    }

    /**
     * Check if the value of the face-up side of the die is equal to the given value
     * 
     * @param value - given value to compare to the dieValue
     * @return boolean - true if equal, false otherwise
     */
    public boolean equals(final int value) {
        return dieValue == value;
    }

    /**
     * Check if the value of the face-up side of the die is smaller than the given
     * value
     * 
     * @param value - given value to compare to the dieValue
     * @return boolean - true if less than, false otherwise
     */
    public boolean lessThan(final int value) {
        return dieValue < value;
    }
}