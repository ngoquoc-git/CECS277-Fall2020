import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        /**switch(action){
            case 1: printForward(); break;
            case 2: printReversed(); break;
            case 3: addWord(); break;
            case 4: removeWord(); break;
        }*/
    }

    public static List<String> readFile(){
        List<String> myList = new LinkedList<String>();
        ListIterator<String> moveIter = new ListIterator();
        try{
            File readMyFile = new File("words.txt");
            Scanner sc = new Scanner(readMyFile);
            while (sc.hasNextLine()){
                String readInput = sc.nextLine();
                myList.add(readInput);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File was not found");
            e.printStackTrace();
        }
        return myList;
    }

    public static void moveIter(){

    }

    public static void addWord(){

    }

    public static void removeWord(){

    }

    public static void printForward(){

    }

    public static void printReversed(){

    }

    public static int menu(){
        System.out.println("1. Display items.\n2. DisplayItems in reversed order.\n3. Add an item.\n4. Remove an item.");
        int action = CheckInput.getIntRange(1, 4);
        return action;
    }
}