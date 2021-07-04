import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class DSAalgorithm {
	public static void main(String args[]) throws Exception {
		 Scanner sc = new Scanner(System.in);

		System.out.println("---- DSA Algorithm ----");
		System.out.println("Enter the clear text message : ");
		String input = sc.next();
		KeyPair keyPair = RSAKey();
		byte[] signature = SignatureCreate(input.getBytes(), keyPair.getPrivate());
		System.out.println("Given Signature is :\n " + DatatypeConverter.printHexBinary(signature));
		System.out.println("Verification for DSA : " + VerifySign(input.getBytes(), signature, keyPair.getPublic()));
	}
	public static byte[] SignatureCreate(byte[] input, PrivateKey Key) throws Exception {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(Key);
		signature.update(input);
		return signature.sign();
	}
	public static KeyPair RSAKey() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048, secureRandom);
		return keyPairGenerator.generateKeyPair();
	}
	public static boolean VerifySign(byte[] input, byte[] signatureToVerify, PublicKey key) throws Exception {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(key);
		signature.update(input);
		return signature.verify(signatureToVerify);
	}
}
