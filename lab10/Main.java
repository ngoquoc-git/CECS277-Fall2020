import java.util.HashMap;
import java.util.HashMap;
import java.util.Random;
class Main{
    public static void main(String[] args){

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

    public static String checkInput(){
        String result = "";

        return result;
    }

    public static void storeHashMap(HashMap<String, Integer> prediction, String pattern){

    }
}