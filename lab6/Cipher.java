/** Cipher class - uses Atbash Cipher to encrypt and decrypt Strings char by char*/
public class Cipher {

    /**Array of alphabet used to encrypt and decrypt letters */
    protected char [] alphabet;
    
    /**Constructor - populates alphabet array with the whole alphabet*/
    public Cipher(){
        this.alphabet = new char[26];
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    /** Method to encrypt String that has been entered using 
     *  encryptLetter() method for each char in string 
     * @param msg String that will be encrypted 
     * @return String that has been encrypted
     */
    public String encrypt(String msg){
        msg = msg.toUpperCase();
        String encryptedMsg = "";
        for (int i = 0; i < msg.length(); ++i){
            encryptedMsg += encryptLetter(msg.charAt(i));
        }
        return encryptedMsg;
    }

    /** Method to decrypt String that has been entered using
     *  decryptLetter() method for each char in string
     * @param msg String that will be decrypted
     * @return String that has been decrypted
     */
    public String decrypt(String msg){
        msg = msg.toUpperCase();
        String decryptedMsg = "";
        for (int i = 0; i < msg.length(); ++i){
            decryptedMsg += decryptLetter(msg.charAt(i));
        }
        return decryptedMsg;
    }

    /** Method to encrypt individual char using corresponding 
     *  reverse alpabet array 
     * @param c char that will be encrypted
     * @return char encrypted with reverse alphabet
     */
    protected char encryptLetter(char c){
        if (Character.isAlphabetic((int) c)){
            char[] reverseAlpha = new char[26];
            int location = 0;
            for (int i = 0; i < this.alphabet.length; ++i) {
                reverseAlpha[i] = this.alphabet[alphabet.length - (i + 1)];
                if (this.alphabet[i] == c) {
                    location = i;
                }
            }
            return reverseAlpha[location];
        }
        return c;
      
    }

    /** Method to decrypt individual char using corresponding 
     *  reverse alphabet array
     * @param c char that will be decrypted
     * @return char decrypted
     */
    protected char decryptLetter(char c){
        if (Character.isAlphabetic((int) c)){
            char[] reverseAlpha = new char[26];
            int location = 0;
            for (int i = 0; i < this.alphabet.length; ++i) {
                reverseAlpha[i] = this.alphabet[alphabet.length - (i + 1)];
            }
            for (int i = 0; i < reverseAlpha.length; ++i) {
                if (reverseAlpha[i] == c) {
                    location = i;
                }
            }
            return this.alphabet[location];
        }
        return c;
    }
    
}
