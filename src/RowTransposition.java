import java.util.Scanner;

public class RowTransposition {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("---- Row Transposition Cipher----");

		String plain = null, key = null;
		System.out.println("Enter the plain text : ");
		plain = sc.nextLine();
		String strs = plain.replace(" ", "");
		System.out.println("Enter the key text : ");
		key = sc.nextLine();
		char plainar[] = new char[strs.length()];
		int k = 0;
		System.out.println("The matrix is as follows : ");
		char encrypt[][] = new char[strs.length()][key.length()];
		plainar = strs.toCharArray();
		for (int i = 0; i < strs.length(); i++) {
			for (int j = 0; j < key.length(); j++) {
				if (k == strs.length()) {
					encrypt[i][j] = 'x';
					break;
				}
				encrypt[i][j] = plainar[k];
				System.out.print(" " + encrypt[i][j]);
				k++;
			}
			System.out.print("\n");
		}
		System.out.println("The encryption text is as follows : ");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(encrypt[j][i]);
			}
			System.out.print(" ");
		}
		
		System.out.print("\nThe decryption text is as follows : \n");
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(encrypt[i][j]);
			}
			System.out.print(" ");
		}
		
	}

}
