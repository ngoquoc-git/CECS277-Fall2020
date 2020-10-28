import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

    }

    public static List<String> readFile(){
        List<String> myList = new LinkedList<String>();
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

    public static void printReserve(){

    }

    public static void menu(){

    }
}