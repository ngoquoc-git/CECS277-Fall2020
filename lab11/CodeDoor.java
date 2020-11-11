import java.util.Arrays;
import java.util.Random;

public class CodeDoor implements Door {

    /**
     * User side keys
     */
    private char[] keys;
    /**
     * Random code to be matched
     */
    private char[] code;

    /**
     * Default Constructor
     * Creates a code door
     * Fixed values for keys and randomized code array
     */
    public CodeDoor() {

        keys = new char[]{'X', 'X', 'X'};

        String option = "XO";
        Random ran = new Random();
        char code1 = option.charAt(ran.nextInt(option.length()));
        char code2 = option.charAt(ran.nextInt(option.length()));

        //We only randomize the last two to prevent auto-opening
        code = new char[]{'O', code1, code2};

    }

    /**
     * Returns the door's description
     *
     * @return door's name and description
     */
    @Override
    public String examine() {
        return "You encounter a Code Door" +
                "A door with a coded keypad with three characters. " +
                "\nEach key toggles a value with X or O";
    }

    /**
     * Available options for users
     *
     * @return a set of options
     */
    @Override
    public String menu() {
        return "\n1. Press Key 1\n2. Press Key 2\n3. Press Key 3";
    }

    /**
     * Presses the key that the user selected
     * (If the key is selected again it will switch again)
     *
     * @param option Users' option from menu
     * @return User's action
     */
    @Override
    public String unlock(int option) {

        if (option == 1) {

            if (keys[0] == 'X') keys[0] = 'O';
            else if (keys[0] == 'O') keys[0] = 'X';

        } else if (option == 2) {

            if (keys[1] == 'X') keys[1] = 'O';
            else if (keys[1] == 'O') keys[1] = 'X';

        } else if (option == 3) {

            if (keys[2] == 'X') keys[2] = 'O';
            else if (keys[2] == 'O') keys[2] = 'X';

        } else return "Where are you pressing?, Try Again\n";

        return "You pressed key number " + option;
    }

    /**
     * Check if the door is open
     *
     * @return true if door is open, false otherwise
     */
    @Override
    public boolean open() {
        return Arrays.equals(keys, code);
    }

    /**
     * Clue appears when users failed to open the door
     *
     * @return help message
     */
    @Override
    public String clue() {

        int counter = 0;

        if (code[0] == keys[0]) counter++;
        if (code[1] == keys[1]) counter++;
        if (code[2] == keys[2]) counter++;

        return "Number of correct items: " + counter;
    }

    /**
     * Success message if door is open
     *
     * @return success message
     */
    @Override
    public String success() {
        return "Congratulations, you cracked the code and opened the door\n";
    }
}