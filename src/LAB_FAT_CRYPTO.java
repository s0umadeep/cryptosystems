
import java.util.Scanner;

public class LAB_FAT_CRYPTO {
	private static final int VARA = 0x67452301;
	private static final int VARB = (int) 0xEFCDAB89L;
	private static final int VARC = (int) 0x98BADCFEL;
	private static final int VARD = 0x10325476;
	private static final int[] SHIFT_AMTS = { 7, 12, 17, 22, 5, 9, 14, 20, 4, 11, 16, 23, 6, 10, 15, 21 };
	private static final int[] TABLE_T = new int[64];
	static {
		for (int i = 0; i < 64; i++)
			TABLE_T[i] = (int) (long) ((1L << 32) * Math.abs(Math.sin(i + 1)));
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println(" ---- Modified MD5 FAT ---- ");  // Here P[i] is modified Pi values that has been taken for MD5
			System.out.println("Enter the plain text for part 1 : ");
			String p1 = sc.next();
			System.out.println("Enter the plain text for part  2 : ");
			String p2 = sc.next();
			System.out.println("Enter the plain text for part  3 : ");
			String p3 = sc.next();
			System.out.println("Enter the plain text for part  4 : ");
			String p4 = sc.next();
			String[] testStrings = { p1, p2, p3, p4 };
			
			System.out.println("The modified MD5 values is as follows :  ");
			for (String s : testStrings)
				System.out.println("\"" + s + "\"" + ":  \"" + "0x" + toHexString(calculateMD5(s.getBytes()))+"\"");
		}
		return;
	}

	public static byte[] calculateMD5(byte[] message) {
		int mLen = message.length;
		int numBlocks = ((mLen + 8) >>> 6) + 1;
		int totalLen = numBlocks << 6;
		byte[] pBytes = new byte[totalLen - mLen];
		pBytes[0] = (byte) 0x80;
		long messageLenBits = (long) mLen << 3;
		for (int i = 0; i < 8; i++) {
			pBytes[pBytes.length - 8 + i] = (byte) messageLenBits;
			messageLenBits >>>= 8;
		}
		int a = VARA; /// Initialization for the A
		int b = VARB; /// Initialization for the B
		int c = VARC; /// Initialization for the C
		int d = VARD; /// Initialization for the D

		int pi = (int) Math.PI; // PI code generation for 2048 since it will iterate 64 bit * 32 round
		int[] P = new int[2048];
		for (int i = 0; i < 2048; i++) {
			P[i] = pi;
		}

		int[] buffer = new int[16];
		for (int i = 0; i < numBlocks; i++) {
			int index = i << 6;
			for (int j = 0; j < 64; j++, index++)
				buffer[j >>> 2] = ((int) ((index < mLen) ? message[index] : pBytes[index - mLen]) << 24)
						| (buffer[j >>> 2] >>> 8);
			int Amain = a;
			int Bmain = b;
			int Cmain = c;
			int Dmain = d;
			for (int j = 0; j < 64; j++) {
				int div16 = j >>> 4;
				int f = 0;
				int bufferIndex = j;
				switch (div16) {
				case 0:
					f = (a ^ b) | (c & d) ^ P[j]; // F(A,B,C,D) = (A XOR B) OR (C AND D) XOR P[i]
					break;
				case 1:
					f = (a & b) | (~b ^ c) ^ (~c & d) ^ P[j]; // G(A,B,C,D) = (A AND B) OR ( ~B XOR C) XOR (~C AND D)
																// XOR P[i]
					bufferIndex = (bufferIndex * 5 + 1) & 0x0F;
					break;
				case 2:
					f = (~a & b) | (b & c) ^ d ^ P[j]; // H(A,B,C,D) = (~A AND B) OR (B AND C) XOR D XOR P[i]
					bufferIndex = (bufferIndex * 3 + 5) & 0x0F;
					break;
				case 3:
					f = (a ^ b) & (c ^ d) ^ P[j]; // I(A,B,C,D) = (A XOR B) AND (C XOR D) XOR P[i]
					bufferIndex = (bufferIndex * 7) & 0x0F;
					break;
				}
				int temp = b + Integer.rotateLeft(a + f + buffer[bufferIndex] + TABLE_T[j],
						SHIFT_AMTS[(div16 << 2) | (j & 3)]);
				a = d;
				d = c;
				c = b;
				b = temp;
			}
			a += Amain;
			b += Bmain;
			c += Cmain;
			d += Dmain;
		}
		byte[] md5 = new byte[16];
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int n = (i == 0) ? a : ((i == 1) ? b : ((i == 2) ? c : d));
			for (int j = 0; j < 4; j++) {
				md5[count++] = (byte) n;
				n >>>= 8;
			}
		}
		return md5;
	}

	public static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			sb.append(String.format("%02X", b[i] & 0xFF));
		}
		return sb.toString();
	}

}