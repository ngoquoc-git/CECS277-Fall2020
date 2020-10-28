import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        LinkedList<String> theList = readFile();
		int action = menu();
        switch(action){
            case 1: printForward(theList); break;
            case 2: printReversed(theList); break;
            case 3: addWord(theList); break;
            case 4: removeWord(theList); break;
        }
    }

    /**
     * Read File and pass everything to a linked list
     * @return the linked list of string
     */
    public static LinkedList<String> readFile(){
        LinkedList<String> myList = new LinkedList<String>();
        ListIterator<String> it;
        try{
            File readMyFile = new File("words.txt");
            Scanner sc = new Scanner(readMyFile);
            it = (ListIterator<String>) myList.iterator();
            while (sc.hasNextLine()){
                moveIter(it, sc.nextLine());
                String word = sc.nextLine();
                it.add(word);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File was not found");
            e.printStackTrace();
        }
        return myList;
    }

    public static void moveIter(ListIterator<String> iter, String word){
        /**String wordAtIter = iter.next();
		if (word.compareTo(wordAtIter) > 0) {
			while(iter.hasNext() && word.compareTo(wordAtIter) > 0) {
				wordAtIter = iter.next();
			}
		} else {
			while(iter.hasPrevious() && word.compareTo(wordAtIter) <= 0) {
				wordAtIter = iter.previous();
			}
        }*/
        while(iter.hasNext() && iter.next().compareTo(word) != 0){
            if(iter.hasNext() && iter.next().compareTo(word) > 0) iter.previous();
            else if(iter.hasNext() && iter.next().compareTo(word) < 0) iter.next();

            if (iter.next().compareTo(word) > 0){
                iter.previous();
                if(iter.previous().compareTo(word) < 0){
                    iter.next();
                }else iter.next();
            }
            else iter.previous();
        }
    }

    /**
     * Add a string to the linked list in a alphabetical order
     * @param list store the current stringsd and the neew string
     */
    public static void addWord(LinkedList<String> list){
        ListIterator<String> it = (ListIterator<String>) list.iterator();
        System.out.println("Enter the word you would like to add: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
		moveIter(it, word);
    }

    public static void removeWord(LinkedList<String> list){
        ListIterator<String> it = list.listIterator();
        System.out.println("Remove Word: ");
        String usrstring = CheckInput.getString();
        while(it.hasNext()){
            if (it.next().equals(usrstring)){
                it.remove();
            }
        }
    }

    /**
     * Display the linked list in alphabetical order
     * @param list that will be displayed
     */
    public static void printForward(LinkedList<String> list){
        ListIterator<String> iter = (ListIterator<String>) list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
    }

    public static void printReversed(LinkedList<String> list){
        ListIterator<String> iter = list.listIterator(list.size()-1);
		while(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
		iter.remove();
    }

    /**
     * Display a menu and ask user for action
     * @return action number
     */
    public static int menu(){
        System.out.println("1. Display items.\n2. DisplayItems in reversed order.\n3. Add an item.\n4. Remove an item.");
        int action = CheckInput.getIntRange(1, 4);
        return action;
    }
}