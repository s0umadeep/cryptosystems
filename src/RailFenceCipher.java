import java.util.*;

public class RailFenceCipher {
	public static void main(String args[]) throws Exception {
		CryptRail rf = new CryptRail();
		try (Scanner scn = new Scanner(System.in)) {
			int width;
			String plain, CText, decryptedText;
			System.out.println("---- Rail Fence Cipher----");
			System.out.println("Enter the plain text:");
			plain = scn.nextLine();
			System.out.println("Enter width for encryption :");
			width = scn.nextInt();
			CText = rf.RailEncrypt(plain, width);
			System.out.println("The encrypted text is :" + CText);
			decryptedText = rf.RailDecrypt(CText, width);
			System.out.println("The decrypted text is :" + decryptedText);
		}
	}
}

class CryptRail {
	int width;

	String RailEncrypt(String plain, int width) throws Exception {
		String CText = "";

		int r = width, len = plain.length();
		int c = len / width;
		char mat[][] = new char[r][c];
		int k = 0;

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (k != len)
					mat[j][i] = plain.charAt(k++);
				else
					mat[j][i] = 'X';
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				CText += mat[i][j];
			}
		}
		return CText;
	}

	String RailDecrypt(String CText, int width) throws Exception {
		String plain = "";

		int r = width, len = CText.length();
		int c = len / width;
		char mat[][] = new char[r][c];
		int k = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = CText.charAt(k++);
			}
		}
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				plain += mat[j][i];
			}
		}
		return plain;
	}
}
