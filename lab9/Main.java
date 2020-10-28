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
        ListIterator<String> it;
        try{
            File readMyFile = new File("words.txt");
            Scanner sc = new Scanner(readMyFile);
            it = (ListIterator<String>) myList.iterator();
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

    public static void moveIter(ListIterator<String> iter, String word){
        String wordAtIter = iter.next();
		if (word.compareTo(wordAtIter) > 0) {
			while(iter.hasNext() && word.compareTo(wordAtIter) > 0) {
				wordAtIter = iter.next();
			}
		} else {
			while(iter.hasPrevious() && word.compareTo(wordAtIter) <= 0) {
				wordAtIter = iter.previous();
			}
		}
    }

    public static void addWord(LinkedList<String> list){

    }

    public static void removeWord(LinkedList<String> list){
        System.out.println("Enter the word you would like to remove: ");
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		ListIterator<String> iter = list.listIterator(0);
		boolean found = false;
		boolean stop = false;
		int i = 0;
		while (iter.hasNext() && !stop) {
			 if (word.compareTo(iter.next()) < 0) {
				 i++;
			 }
			 else if (word.compareTo(iter.next()) == 0) {
				 found = true;
				 list.remove(i);
			 } else {
				 stop = true;
			 }
		 }
            if (!found) {
                System.out.println("The word \"" + word + "\" was not found");
            }
    }

    public static void printForward(LinkedList<String> list){
        ListIterator<String> iter = list.listIterator(list.size()-1);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		iter.remove();
    }

    public static void printReversed(LinkedList<String> list){
        ListIterator<String> iter = list.listIterator(list.size()-1);
		while(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
		iter.remove();
    }

    public static int menu(){
        System.out.println("1. Display items.\n2. DisplayItems in reversed order.\n3. Add an item.\n4. Remove an item.");
        int action = CheckInput.getIntRange(1, 4);
        return action;
    }
}