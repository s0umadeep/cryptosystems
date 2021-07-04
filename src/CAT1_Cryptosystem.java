import java.util.Scanner;

public class CAT1_Cryptosystem {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        System.out.println("----- Modified Shift Cipher -----");

        System.out.println("Enter the text you want to encrypt : ");
        String word = sc.nextLine();
        char[] text = word.toCharArray();
        int p=0;
        System.out.println("The text in character array: ");

        for (int i = 0; i < text.length; i++) {
           System.out.print(text[i]);
        }
        char decry = text[0];
        System.out.print("\n");
         isKey :
         {
             System.out.print("Enter the key for cipher : ");
             int key = sc.nextInt();

             if (key >0 && key < 26) {
                 System.out.print("\n");
                 char modencrypt = 0;
                 System.out.println("The encypted text in we get is :  ");
                 char[] encry = new char[100];
                 for (int i = 0; i < text.length; i++) { // Encryption Process for modified shift Cipher
                	 if(i==0) {
                    	 int modnewch=65;
                         modencrypt = (char) modnewch;
                         System.out.print(modencrypt);

                	 }else {
                     int enc = ((i + key + p) % 26) - i;
                     int ch = (int) text[i];
                     int newch = ch + enc;
                     char encrptext = (char) newch;
                	 
                     System.out.print(encrptext);
                     encry[i] = encrptext;
                	 }
                 }
                 System.out.print("\n");
                 System.out.println("The decrypted text in we get is :  ");

                 for (int j = 0; j < text.length; j++) {  //Decryption Process for modified shift cipher
                    
                	 if(j==0) {
                		 System.out.print(decry);
                	 }else {
                	 int decr = (int) encry[j] - key-p;
                     char decryp = (char) decr;
                     System.out.print(decryp);
                	 }
                }
             } else {
                 System.out.print("The key value should be between 1 and 26 !!! ");
                 break isKey;
             }
         }
    }
}
