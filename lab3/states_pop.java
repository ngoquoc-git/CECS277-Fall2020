import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<Integer> populations = new ArrayList<Integer>();
        Scanner usrInput = new Scanner(System.in);
        ArrayList<Integer> options = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int num;
        readFile(states, populations);
        do{
            menu();
            num = usrInput.nextInt();
            while(!options.contains(num)){
                System.out.println("Please enter one of the above options");
                num = usrInput.nextInt();
            }
            if (num == 1){
                sortAlphabetical(states, populations);
                displayState(states, populations);
                System.out.println();
            }
            else if (num == 2){
                sortPopulation(states, populations);
                displayState(states, populations);
                System.out.println();
            }
            else if (num == 3){
                System.out.println("US Population: " + totalPopulation(populations));
                System.out.println();
            }
            else if (num == 4){
                System.out.print("Enter Population: ");
                int greaterThan = usrInput.nextInt();
                populationGreater(greaterThan, states, populations);
                System.out.println();
            }
        }while(num != options.get(4));
        usrInput.close();
    }

    public static void menu() {
        System.out.println("State Stats\n1.Display Sorted States\n2.Display Sorted Populations");
        System.out.println("3.Display Total US population\n4.Display State With Population Greater than\n5.Quit");
    }

    public static void readFile(ArrayList<String> states, ArrayList<Integer> populations) {
        File inputFile = new File("StatePops.txt");
        try {
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()){
                String line = input.nextLine();
                int i = 0;
                while(!Character.isDigit(line.charAt(i))){ //while loop to check where digit starts
                    i++;
                }
                states.add(line.substring(0,i-1));
                populations.add(Integer.parseInt(line.substring(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayState(ArrayList<String> states, ArrayList<Integer> populations){
        for (int i = 0; i < states.size(); i++) {
            System.out.printf("%-25s %,10d \n", states.get(i),populations.get(i));
        }
    }

    public static int totalPopulation(ArrayList<Integer> populations){
        int sum = 0;
        for(int statepop : populations){
            sum += statepop;
        }
        return sum;
    }

    public static void populationGreater(int greaterThan, ArrayList<String> states, ArrayList<Integer> populations) {
        for (int i = 0; i < states.size(); i++) {
            if (populations.get(i) > greaterThan) {
                System.out.printf("%s   %,d\n", states.get(i), populations.get(i));
            }
        }
    }

    public static void sortPopulation(ArrayList<String> states,ArrayList<Integer> populations){
        boolean swapped = false;
        do{
            swapped = false;
            for (int i =0; i < populations.size() - 1; i++){
                if(populations.get(i) > populations.get(i+1)){
                    int popSwap = populations.get(i);
                    populations.set(i,populations.get(i+1));
                    populations.set(i+1, popSwap);

                    String stateSwap = states.get(i);
                    states.set(i, states.get(i+1));
                    states.set(i+1, stateSwap);
                    swapped = true;
                }
            }
        }while(swapped);
    }

    public static void sortAlphabetical(ArrayList<String> states, ArrayList<Integer> populations){
        boolean swapped = false;
        do{
            swapped = false;
            for (int i = 0; i < states.size() - 1; i++){
                if(states.get(i).compareTo(states.get(i+1)) > 0){
                    int popSwap = populations.get(i);
                    populations.set(i, populations.get(i + 1));
                    populations.set(i + 1, popSwap);

                    String stateSwap = states.get(i);
                    states.set(i, states.get(i + 1));
                    states.set(i + 1, stateSwap);
                    swapped = true;
                }
            }
        }while(swapped);
    }

}