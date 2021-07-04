import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CBC {

	public static void main(String args[]) throws NoSuchAlgorithmException {
		String clearText = null;
		String IV = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("----  Cypher Block Technique ---- ");
		System.out.println("Enter the clear text : ");
		clearText = sc.next();
		System.out.println("Enter the Initialization vector text : ");
		IV = sc.next();
		byte[] a = clearText.getBytes();
		byte[] key = IV.getBytes();

		System.out.println("\nThe encryption for the CBC is : ");
		encodeString(clearText, IV);
		System.out.println("\nThe decryption for the CBC is : ");
		decodeString(clearText, IV);

	}

	public static void encodeString(String s, String key) {
		base64Encode(xorWithKey(s.getBytes(), key.getBytes()));
	}

	public static void decodeString(String s, String key) {
		(xorWithKey(base64Decode(s), key.getBytes())).toString();
	}

	private static byte[] xorWithKey(byte[] a, byte[] key) {
		byte[] out = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = (byte) (a[i] ^ key[i % key.length]);
		}
		return out;
	}

	private static byte[] base64Decode(String s) {
		return base64Decode(s);
	}

	private static void base64Encode(byte[] bytes) {
		for (int i = 0; i < bytes.length; i++) {
			System.out.print(" " + bytes[i]);
		}
	}
}
