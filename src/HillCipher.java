import java.util.Scanner;

public class HillCipher {

	public static void main(String[] args) {
		int n = 3;
		String plain = null;
		String key = null;

		int plainmat[][] = new int[1][3];
		int keymat[][] = new int[3][3];

		Scanner sc = new Scanner(System.in);
		System.out.println("------Hill Cipher------");
		System.out.println("Enter the plain text : ");
		plain = sc.nextLine();
		System.out.println("\nEnter the key : ");
		key = sc.nextLine();

		char[] plainchar = new char[100];
		plainchar = plain.toUpperCase().toCharArray();

		if (plainchar.length == 3) {
			for (int i = 0; i < plainchar.length; i++) { // Encryption Process
				int plainc = (int) plainchar[i] - 64;
				plainmat[0][i] = plainc;
			}

			System.out.println("The equivalent plaintext matrix is : ");
			for (int i = 0; i < 1;) {
				for (int j = 0; j < plainchar.length; j++) {
					System.out.print(" " + plainmat[0][j]);
				}
				break;

			}
		} else {
			System.out.println("The plain text is not of 3 characters !!");
			System.exit(0);
		}
		System.out.println("\n");
		int keyc = 0;
		char[] keychar = new char[100];
		keychar = key.toUpperCase().toCharArray();
		System.out.println("The equivalent key matrix is : ");

		if (keychar.length == 9) {
			for (int i = 0; i < keychar.length; i++) {
				keyc = (int) keychar[i] - 64;
				System.out.print(" " + keyc);
			}

		} else {
			System.out.println("The Key is not of 9 character !!");
		}

	}

}
