import java.util.Arrays;
import java.util.Random;

public class CodeDoor implements Door {

    private char[] keys;
    private char[] code;

    public CodeDoor() {

        keys = new char[]{'X', 'X', 'X'};

        String option = "XO";
        Random ran = new Random();
        char code1 = option.charAt(ran.nextInt(option.length()));
        char code2 = option.charAt(ran.nextInt(option.length()));

        code = new char[]{'O', code1, code2};

    }

    @Override
    public String examine() {
        return "A door with a coded keypad with three characters. " +
                "\nEach key toggles a value with X or O";
    }

    @Override
    public String menu() {
        return "\n1. Press Key 1\n2. Press Key 2\n3. Press Key 3\n";
    }

    @Override
    public String unlock(int option) {

        if (option == 1) {

            if (keys[0] == 'X') keys[0] = 'O';
            else if (keys[0] == 'O') keys[0] = 'X';

        } else if (option == 2) {

            if (keys[1] == 'X') keys[1] = 'O';
            else if (keys[1] == 'O') keys[1] = 'X';

        } else {
            //TODO check for input
            if (keys[2] == 'X') keys[2] = 'O';
            else if (keys[2] == 'O') keys[2] = 'X';
        }

        return "You pressed key number " + option;
    }

    @Override
    public boolean open() {
        return Arrays.equals(keys, code);
    }

    @Override
    public String clue() {

        int counter = 0;

        if (code[0] == keys[0]) counter++;
        if (code[1] == keys[1]) counter++;
        if (code[2] == keys[2]) counter++;

        return "Number of correct items: " + counter;
    }

    @Override
    public String success() {
        return "Congratulations, you cracked the code and opened the door";
    }
} 