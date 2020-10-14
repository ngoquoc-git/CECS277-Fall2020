package lab1;

/* author:      Quoc Ngo, Jacob Sunia
 * Date:        08/25/2020
 *Description:  CECS 277 Lab1
 */

import java.util.Scanner;

public class PostalCodePrinter {

    public static void main(String[] args) {
        String zip;
        int zipInt, checkDigit, sum;
        int digit1, digit2, digit3, digit4, digit5, remainder;
        
        System.out.print("Please Enter a 5 Digit Zip Code: ");
        zip = getZip();
        
        zipInt = Integer.parseInt(zip);        
        digit5 = zipInt % 1000; 
        remainder = zipInt - digit5;        
        digit4 = (zipInt % 100) / 10;
        remainder = remainder - (digit4 * 10);        
        digit3 = (zipInt % 1000) / 100;
        remainder = remainder - (digit3 * 100);        
        digit2 = (zipInt % 10000) / 1000;
        remainder = remainder - (digit2 * 1000);
        digit1 = zipInt/ 10000;
        
        sum = digit1 + digit2 + digit3 + digit4 +digit5;
        checkDigit = calcCheckDigit(sum);
        
        System.out.print("|");
        printBarCode(zip);
        printDigit(checkDigit);
        System.out.print("|\n");
        
    }
    public static String getZip() {
        Scanner scan = new Scanner(System.in);
        String zip = scan.nextLine();
        return zip;
    }
    public static void printDigit(int d) {
        switch(d){
            case 1: System.out.print("...||"); break;
            case 2: System.out.print("..|.|"); break;
            case 3: System.out.print("..||."); break;
            case 4: System.out.print(".|..|"); break;
            case 5: System.out.print(".|.|."); break;
            case 6: System.out.print(".||.."); break;
            case 7: System.out.print("|...|"); break;
            case 8: System.out.print("|..|."); break;
            case 9: System.out.print("|.|.."); break;
            case 0: System.out.print("||..."); break;
        }
    }
    public static int calcCheckDigit(int sum){
        int roundUpDigit, checkDigit;
        roundUpDigit = (sum / 10 + 1) * 10;
        checkDigit = roundUpDigit - sum;
        
        return checkDigit;  
    }
    public static void printBarCode(String zip) {
        char[] ch = new char[zip.length()];
        
        for (int i = 0; i < zip.length(); i++) {
            char di = zip.charAt(i);
            int zipInt = Integer.parseInt(String.valueOf(di));
            switch(zipInt){
            case 1: System.out.print("...||"); break;
            case 2: System.out.print("..|.|"); break;
            case 3: System.out.print("..||."); break;
            case 4: System.out.print(".|..|"); break;
            case 5: System.out.print(".|.|."); break;
            case 6: System.out.print(".||.."); break;
            case 7: System.out.print("|...|"); break;
            case 8: System.out.print("|..|."); break;
            case 9: System.out.print("|.|.."); break;
            case 0: System.out.print("||..."); break;
            }
        }  
    }
}
