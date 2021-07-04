import java.util.Scanner;

public class VigenereCipher {

	public static void main(String[] args) {
		String plaintext = null;
		String keyw = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("------Vigenere Cipher------");
		System.out.println("Enter the plain text : ");
		plaintext = sc.nextLine();
		System.out.println("\nEnter the key : ");
		keyw = sc.nextLine();

		String key = keyG(plaintext, keyw);
		String cipher = conversionC(plaintext, key);

		System.out.println("The given cipher text is  : " + cipher + "\n");

		System.out.println("Decrypted Text : " + text(cipher, key));
	}

	static String text(String cipher, String key) {
		String orig_text = "";

		for (int i = 0; i < cipher.length() && i < key.length(); i++) {
			int x = (cipher.charAt(i) - key.charAt(i) + 26) % 26;
			x += 'A';
			orig_text += (char) (x);
		}
		return orig_text;
	}

	static String keyG(String plaintext, String key) {
		int x = plaintext.length();

		for (int i = 0;; i++) {
			if (x == i)
				i = 0;
			if (key.length() == plaintext.length())
				break;
			key += (key.charAt(i));
		}
		return key;
	}

	static String conversionC(String plaintext, String key) {
		String cipher = "";

		for (int i = 0; i < plaintext.length(); i++) {
			int x = (plaintext.charAt(i) + key.charAt(i)) % 26;

			x += 'A';

			cipher += (char) (x);
		}
		return cipher;
	}

}
