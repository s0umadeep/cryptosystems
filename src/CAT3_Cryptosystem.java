import java.util.Scanner;

public class CAT3_Cryptosystem {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		String cleartext = null;
		System.out.println("----Modified SHA 1----");
		System.out.println("Enter the clear text: ");
		cleartext=sc.next();		
		char[] text = cleartext.toCharArray();
		System.out.println("The text in character array: ");

		for (int i = 0; i < text.length; i++) {
			System.out.print(text[i]+"\t");
		}
		System.out.println("\nArray characters to ASCII");
		for (int i = 0; i < text.length; i++) {
			int ascii = text[i];
			System.out.print(ascii+"\t");
		}
		
	
	
	}

	
}
