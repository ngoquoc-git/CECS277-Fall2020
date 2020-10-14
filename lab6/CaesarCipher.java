public class CaesarCipher extends Cipher{

     /**Value that the cipher will be shifted */
     private int shift;

     /**Constructor - calls super constructor and updates the shift value */
     public CaesarCipher(int s){
         super();
         this.shift = s;
     }
 
     /** Method to encrypt char that is entered, uses ascii values to determine 
      *  how to calculate the corresponding encrypted char and type casts ascii value
      *  to actual char.
      * @param c char to be encrypted
      * @return char that has been encrypted
      */
     @Override
     protected char encryptLetter(char c){
         if(Character.isAlphabetic((int) c)){
             char encryptedChar = (char) (((int) c + this.shift - 65) % 26 + 65);
             return encryptedChar;
         }
         return c;
     }
 
     /** Method to decrypt char that is entered, uses ascii value to determine 
      *  how to calculate the corresponding decrypted char and type casts ascii value 
      *  to actual char.
      * @param c char to be decrypted
      * @return char that has been decrypted
      */
     @Override
     protected char decryptLetter(char c){
         if (Character.isAlphabetic((int) c)){
             char decryptedChar = (char) (((int) c - this.shift - 65) % 26 + 65);// 65 represents 'A' in ascii
             return decryptedChar;
         }
         return c;
     }  
}