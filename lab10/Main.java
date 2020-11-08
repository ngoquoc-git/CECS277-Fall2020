import java.util.HashMap;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input, pattern = "";
        HashMap<String, Integer> prediction = new HashMap<>();
        int points = 0, rounds = 1;
        String comp;

        System.out.println("Mind Reader!");
        input = getInput();

        while (input != "Q"){
            comp = makePrediction(prediction, pattern);
            //System.out 
            if (input == comp) points++;
        } 
    }

    public static String makePrediction(HashMap<String, Integer> prediction, String pattern){
        String subpattern1 = pattern.substring(1);
        String subpattern2 = subpattern1;
        int guess1, guess2;

        subpattern1 += "X";
        subpattern2 += "O";

        guess1 = (int)prediction.get(subpattern1);
        guess2 = (int)prediction.get(subpattern2);
        
        if (guess1 > guess2) return "X";
        else if(guess2 > guess1) return "O";
        else {
            Random rand = new Random();
            int result = rand.nextInt(2);
            if (result == 1) return "O";
            else return "X";
        }
    }

    public static String getInput(){
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter X or O, or Q to quit.");
        String input = sc.nextLine().toUpperCase();
        
        while (input != "X" && input != "O" && input != "Q"){
            System.out.print("Invalid Input, try again: ");
            input = sc.nextLine().toUpperCase();
        }
        return input;
    }

    public static void storeHashMap(HashMap<String, Integer> prediction, String pattern){
        if (prediction.containsKey(pattern))  prediction.put(pattern,prediction.get(pattern) + 1);
        else prediction.put(pattern, 1);
    }
}