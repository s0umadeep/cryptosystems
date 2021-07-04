import java.util.Random;
import java.util.Scanner;

public class OneTimePad {

	static String upperL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String lowerL = "abcdefghijklmnopqrstuvwxyz";

	public static String Encrypt(String text, String key) {
		int stringlength = text.length();
		String sb = "";

		for (int x = 0; x < stringlength; x++) {
			char g = text.charAt(x);
			char keyget = key.charAt(x);
			if (Character.isUpperCase(g)) {
				int indx = upperL.indexOf(g);
				int keydex = upperL.indexOf(Character.toUpperCase(keyget));
				int total = (indx + keydex) % 26;

				sb = sb + upperL.charAt(total);
			} else if (Character.isLowerCase(g)) {
				int indx = lowerL.indexOf(g);
				int keydex = upperL.indexOf(Character.toLowerCase(keyget));
				int total = (indx + keydex) % 26;

				sb = sb + lowerL.charAt(total);
			} else {
				sb = sb + g;
			}
		}
		return sb;
	}

	public static String Decrypt(String text, String key) {

		int stringlength = text.length();

		String sb = "";
		for (int x = 0; x < stringlength; x++) {
			char g = text.charAt(x);
			char keyget = key.charAt(x);
			if (Character.isUpperCase(g)) {
				int indx = upperL.indexOf(g);
				int keydex = upperL.indexOf(Character.toUpperCase(keyget));
				int total = (indx - keydex) % 26;

				total = (total < 0) ? total + 26 : total;
				sb = sb + upperL.charAt(total);
			} else if (Character.isLowerCase(g)) {
				int indx = lowerL.indexOf(g);
				int keydex = upperL.indexOf(Character.toLowerCase(keyget));
				int total = (indx - keydex) % 26;

				total = (total < 0) ? total + 26 : total;
				sb = sb + lowerL.charAt(total);
			} else {
				sb = sb + g;
			}
		}
		return sb;
	}

	public static String Scramble(int stringlength) {
		Random r = new Random();
		String key = "";
		for (int x = 0; x < stringlength; x++)
			key = key + (char) (r.nextInt(26) + 'A');
		return key;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("------One Time Padding ------- ");
			System.out.println("Enter the plain text: ");
			String text = sc.next();

			String key = Scramble(text.length());

			String enc = Encrypt(text, key);
			System.out.println("The key is : "+ key);
			System.out.println("The plain text observed is : " + text);
			System.out.println("The encrypted text is : " + enc);
			System.out.println("The decrypted text is  : " + Decrypt(enc, key));
		}
	}

}