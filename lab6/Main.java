import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Secret Decoder Ring:\n1.Encrypt\n2.Decrypt");
        int encryptOrDecrypt = CheckInput.getIntRange(1, 2);
        System.out.println("Enter Decryption Type:\n1.Atbash\n2.Caesar");
        int encryptOrDecryptType = CheckInput.getIntRange(1, 2);

        if (encryptOrDecrypt == 1 && encryptOrDecryptType == 1) {
            System.out.print("Enter message: ");
            String message = CheckInput.getString();
            Cipher c = new Cipher();
            String encryptedMsg = c.encrypt(message);
            printToFile(encryptedMsg);
        }
        else if (encryptOrDecrypt == 1 && encryptOrDecryptType == 2){
            System.out.print("Enter message: ");
            String message = CheckInput.getString();
            System.out.print("Enter shift value: ");
            int shift = CheckInput.getInt();
            CaesarCipher cc = new CaesarCipher(shift);
            String encryptedMsg = cc.encrypt(message);
            printToFile(encryptedMsg);
        }
        else if (encryptOrDecrypt == 2 && encryptOrDecryptType == 1){
            String message = readFile();
            System.out.println("Reading encrypted message from \"message.txt\"");
            Cipher c = new Cipher();
            System.out.println("Decrypted Message: " + c.decrypt(message));
        }
        else if (encryptOrDecrypt == 2 && encryptOrDecryptType == 2){
            String message = readFile();
            System.out.print("Enter shift value: ");
            int shift = CheckInput.getInt();
            CaesarCipher cc = new CaesarCipher(shift);
            System.out.println("Decrypted Message: " + cc.decrypt(message));
        }

    }
    public static void printToFile(String encryptedMsg){
        try {
            PrintWriter out = new PrintWriter("message.txt");
            out.println(encryptedMsg);
            System.out.println("Encrypted message saved to \"message.txt\".");
            System.out.println("Encrypted message written to file: " + encryptedMsg);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(){
        File inputFile = new File("message.txt");
        try{
            Scanner input = new Scanner(inputFile);
            String message = input.nextLine();
            return message;
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;// return value if there is no file
    }
}
