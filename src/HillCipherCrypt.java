import java.util.Scanner;

class Hill {

	Hill(int bsize) {
		this.bsize = bsize;
	}

	All b1 = new All();
	int bsize = 2;
	int key[][] = new int[bsize][bsize];

	void keyInsert() throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter key Matrix");
			for (int i = 0; i < bsize; i++) {
				for (int j = 0; j < bsize; j++) {
					key[i][j] = sc.nextInt();
				}
			}
		}
	}

	void KeyInverseInsert() throws Exception {
		Scanner sc = new Scanner(System.in);
		int keyi[][] = new int[bsize][bsize];
		System.out.println("Enter key Inverse Matrix:");
		for (int i = 0; i < bsize; i++) {
			for (int j = 0; j < bsize; j++) {
				keyi[i][j] = sc.nextInt();
			}
		}

	}

	String encryptBlock(String plain) throws Exception {
		plain = plain.toUpperCase();
		int a[][] = new int[bsize][1], sum = 0;
		int cipherMatrix[][] = new int[bsize][1];
		String cipher = "";

		for (int i = 0; i < bsize; i++) {
			a[i][0] = b1.indexOfChar(plain.charAt(i));
		}

		for (int i = 0; i < bsize; i++) {
			for (int j = 0; j < 1; j++) {
				for (int k = 0; k < bsize; k++) {
					sum = sum + key[i][k] * a[k][j];
				}
				cipherMatrix[i][j] = sum % 26;
				sum = 0;
			}
		}

		for (int i = 0; i < bsize; i++) {
			cipher += b1.charAtIndex(cipherMatrix[i][0]);
		}
		return cipher;
	}

	String Decryption(String cipherText) throws Exception {
		String plain = "";
		// KeyInverseInsert();
		cipherText = cipherText.replaceAll(" ", "");

		cipherText = cipherText.toUpperCase();

		int len = cipherText.length();

		for (int i = 0; i < len - 1; i = i + bsize) {
			plain += decryptBlock(cipherText.substring(i, i + bsize));
			plain += " ";
		}
		return plain;
	}

	String Encryption(String plain) throws Exception {
		String cipherText = "";
		keyInsert();

		plain = plain.toUpperCase();

		int len = plain.length();

		while (len % bsize != 0) {
			plain += "X";
			System.out.println(len);
			len = plain.length();
		}

		for (int i = 0; i < len - 1; i = i + bsize) {
			cipherText += encryptBlock(plain.substring(i, i + bsize));
			cipherText += " ";
		}
		return cipherText;
	}

	String decryptBlock(String cipher) throws Exception {
		cipher = cipher.toUpperCase();
		int a[][] = new int[bsize][1], sum = 0;
		int plainMatrix[][] = new int[bsize][1];
		String plain = "";

		for (int i = 0; i < bsize; i++) {
			a[i][0] = b1.indexOfChar(cipher.charAt(i));
		}

		for (int i = 0; i < bsize; i++) {
			for (int j = 0; j < 1; j++) {
				for (int k = 0; k < bsize; k++) {
					sum = sum + key[i][k] * a[k][j];
				}
				while (sum < 0) {
					sum += 26;
				}
				plainMatrix[i][j] = sum;
				sum = 0;
			}
		}

		for (int i = 0; i < bsize; i++) {
			plain += b1.charAtIndex(plainMatrix[i][0]);
		}
		return plain;
	}

}

class All {
	String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	int indexOfChar(char c) {
		for (int i = 0; i < alpha.length(); i++) {
			if (alpha.charAt(i) == c)
				return i;
		}
		return -1;
	}

	char charAtIndex(int pos) {
		return alpha.charAt(pos);
	}
}

class HillCipherCrypt {
	public static void main(String args[]) throws Exception {
		String plain, cipherText;
		int bsize;
		Scanner sc = new Scanner(System.in);
		System.out.println("------ Hill Cipher---------");

		System.out.println("Enter plain text for hill cipher:");
		plain = sc.nextLine();

		System.out.println("Enter size of matrix:");
		bsize = sc.nextInt();
		Hill hill = new Hill(bsize);

		plain = plain.replaceAll(" ", "");
		cipherText = hill.Encryption(plain);

		System.out.println("Encrypted Text is:\n" + cipherText);

		// String decryptedText = hill.Decryption(cipherText);
		// System.out.println("Decrypted Text is:\n" + decryptedText);

	}
}