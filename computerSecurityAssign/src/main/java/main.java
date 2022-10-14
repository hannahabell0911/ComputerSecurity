import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

   public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

   public static String encrypt(String data, int shiftKey) {
       data.toLowerCase();
       String encryptStr = "";
       for (int i = 0; i < data.length(); i++) {
           int pos = alpha.indexOf(data.charAt(i));

           int encryptPos = (shiftKey + pos) % 26;
           char encryptChar = alpha.charAt(encryptPos);
           encryptStr += encryptChar;
       }
       return encryptStr;
   }
   public static String decrypt(String data, int shiftkey){
       data = data.toLowerCase();
       String decryptStr ="";
       for(int i =0; i < data.length(); i++){
           int pos = alpha.indexOf(data.charAt(i));
           int decryptPos = (pos - shiftkey) % 26;

           if(decryptPos < 0){
               decryptPos = alpha.length() + decryptPos;
           }
           char decryptChar = alpha.charAt(decryptPos);
           decryptStr += decryptChar;
       }
       return decryptStr;
   }


    public static void main(String[] args) {

        String data = null;
        int shiftKey = 3;
        try {
            File text = new File("C:\\Users\\hanna_7mp7rjp\\IdeaProjects\\computerSecurityAssign\\src\\main\\resources\\ciphertext.txt");
            Scanner myReader = new Scanner(text);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }

        System.out.println("Text  : " + data);
        System.out.println("Shift : " + shiftKey);
        System.out.println("Encrypted data: " + encrypt(data, shiftKey));
        System.out.println("Decrypted data: " + decrypt(encrypt(data,shiftKey), shiftKey));


    }
}
