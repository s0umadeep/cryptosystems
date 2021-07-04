import java.util.Scanner;

public class AffineCipher {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String encr = " ";
		String textd = " ";

		System.out.println("Enter the text you want to encrypt : ");
		String word = sc.nextLine();
		char[] text = word.toCharArray();
		System.out.println("The text in character array: ");

		for (int i = 0; i < text.length; i++) {

			System.out.print(text[i]);
		}
		System.out.print("\n");
		{
			System.out.print("Enter the key A for encr : ");
			int a = sc.nextInt();

			System.out.print("Enter the key B for encr : ");
			int b = sc.nextInt();

			System.out.print("\n");

			for (int i = 0; i < text.length; i++) {
				if (text[i] != ' ') {
					encr = encr + (char) ((((a * (text[i] - 'A')) + b) % 26) + 'A');
				} else {
					encr += text[i];
				}
			}
			System.out.println("The encypted text in we get using affine encr is :  " + encr); // Encryption of affine
																								// encr

			System.out.print("\n");

			int inverseA = 0;
			int flag = 0;

			for (int i = 0; i < 26; i++) {
				flag = (a * i) % 26;

				if (flag == 1) {
					inverseA = i;
				}
			}
			for (int i = 0; i < encr.length(); i++) {
				if (encr.charAt(i) != ' ') {
					textd = textd + (char) (((inverseA * ((encr.charAt(i) + 'A' - b)) % 26)) + 'A');
				} else {
					textd += encr.charAt(i);
				}
			}
			System.out.println("The decrypted text in we get using affine encr is :  " + word); // Decryption of affine
																									// encr
		}
	}
}
