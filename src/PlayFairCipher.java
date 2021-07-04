import java.util.Scanner;

public class PlayFairCipher {

	private String Plain = new String();
	private String Key = new String();
	private char CharMat[][] = new char[5][5];

	public static void main(String[] args) {
		PlayFairCipher x = new PlayFairCipher();
		Scanner sc = new Scanner(System.in);
		System.out.println("----------PlayFair Cipher----");
		System.out.println("Enter a Key:");
		String PlainText = sc.next();
		x.KeyS(PlainText);
		x.KeyF();
		System.out.println("Enter the plain text to encrypt: ");
		String input = sc.next();
		if (input.length() % 2 == 0) {
			System.out.println("Encryption: " + x.encryption(input));
		} else {
			System.out.println("Length of the message should be equal");
		}
		sc.close();
	}

	public void KeyF() {
		boolean flag = true;
		char current;
		Key = Plain;
		for (int i = 0; i < 26; i++) {
			current = (char) (i + 97);
			if (current == 'j')
				continue;
			for (int j = 0; j < Plain.length(); j++) {
				if (current == Plain.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag)
				Key = Key + current;
			flag = true;
		}
		System.out.println(Key);
		matrix();
	}

	private void matrix() {
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				CharMat[i][j] = Key.charAt(counter);
				System.out.print(CharMat[i][j] + " ");
				counter++;
			}
			System.out.println();
		}
	}

	private String format(String o) {
		int i = 0;
		int len = 0;
		String text = new String();
		len = o.length();
		for (int tmp = 0; tmp < len; tmp++) {
			if (o.charAt(tmp) == 'j') {
				text = text + 'i';
			} else
				text = text + o.charAt(tmp);
		}
		len = text.length();
		for (i = 0; i < len; i = i + 2) {
			if (text.charAt(i + 1) == text.charAt(i)) {
				text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
			}
		}
		return text;
	}

	private String[] dp(String new_string) {
		String Original = format(new_string);
		int size = Original.length();
		if (size % 2 != 0) {
			size++;
			Original = Original + 'x';
		}
		String x[] = new String[size / 2];
		int counter = 0;
		for (int i = 0; i < size / 2; i++) {
			x[i] = Original.substring(counter, counter + 2);
			counter = counter + 2;
		}
		return x;
	}

	public int[] GetDiminsions(char letter) {
		int[] key = new int[2];
		if (letter == 'j')
			letter = 'i';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (CharMat[i][j] == letter) {
					key[0] = i;
					key[1] = j;
					break;
				}
			}
		}
		return key;
	}

	public String encryption(String Source) {
		String src_arr[] = dp(Source);
		String C = new String();
		char one;
		char two;
		int seq[] = new int[2];
		int seq1[] = new int[2];
		for (int i = 0; i < src_arr.length; i++) {
			one = src_arr[i].charAt(0);
			two = src_arr[i].charAt(1);
			seq = GetDiminsions(one);
			seq1 = GetDiminsions(two);
			if (seq[0] == seq1[0]) {
				if (seq[1] < 4)
					seq[1]++;
				else
					seq[1] = 0;
				if (seq1[1] < 4)
					seq1[1]++;
				else
					seq1[1] = 0;
			} else if (seq[1] == seq1[1]) {
				if (seq[0] < 4)
					seq[0]++;
				else
					seq[0] = 0;
				if (seq1[0] < 4)
					seq1[0]++;
				else
					seq1[0] = 0;
			} else {
				int temp = seq[1];
				seq[1] = seq1[1];
				seq1[1] = temp;
			}
			C = C + CharMat[seq[0]][seq[1]] + CharMat[seq1[0]][seq1[1]];
		}
		return C;
	}

	public void KeyS(String k) {
		String K_adjust = new String();
		boolean flag = false;
		K_adjust = K_adjust + k.charAt(0);
		for (int i = 1; i < k.length(); i++) {
			for (int j = 0; j < K_adjust.length(); j++) {
				if (k.charAt(i) == K_adjust.charAt(j)) {
					flag = true;
				}
			}
			if (flag == false)
				K_adjust = K_adjust + k.charAt(i);
			flag = false;
		}
		Plain = K_adjust;
	}
}
