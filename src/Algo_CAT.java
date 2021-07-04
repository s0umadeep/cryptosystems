import java.util.Scanner;

public class Algo_CAT {

    public static void main(String[] args) {

        int k1 = 0;
        int k2 = 0;
        char encrptext1 = 0;
        char encrptext = 0;
        char encrptext2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text you want to encrypt : ");
        String word = sc.nextLine();
        char[] text = word.toCharArray();
        System.out.println("The text in character array: ");

        for (int i = 0; i < text.length; i++) {

            System.out.print(text[i]);

        }
        System.out.print("\n");
        isKey:
        {
            System.out.print("Enter the key for cipher between (1 to 9): ");
            int k = sc.nextInt();

            if (k > 0 && k < 9) {
                System.out.print("\n");

                System.out.println("The encypted text in we get is :  ");
                char[] encry = new char[100];
                for (int i = 0; i < text.length; i++) { // Encryption Process
                    int enc;
                    if(k%2!=0){
                        k1 = ((i + k) % 26) - i;
                    }else{
                        k2 = ((i + k) % 26) - i;
                    }
                    int ch = (int) text[i];
                    int newch1 = ch + k1;
                    int newch2 = ch + k2;
                    int newch = ch + k;

                    encrptext = (char) newch;
                    System.out.print(encrptext);
                    encry[i] = encrptext;
                }
                    System.out.print("\n");

                    System.out.println("The decrypted text in we get is :  ");

                    for (int j = 0; j < text.length; j++) {  //Decryption Process
                        int decr = (int) encry[j] - k;
                        char decryp = (char) decr;
                        System.out.print(decryp);
                    }

            }
        }
    }
}
