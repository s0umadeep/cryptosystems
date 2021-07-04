import java.util.Scanner;

class DiffieHellman {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---- Diffie Hellman ----");
		System.out.println("Enter modulo(p) : ");
		int p = sc.nextInt();
		System.out.println("Enter primitive root of : " + p);
		int g = sc.nextInt();
		System.out.println("Enter the secret key A : ");
		int a = sc.nextInt();
		System.out.println("Choose the secret key B : ");
		int b = sc.nextInt();

		int A = (int) Math.pow(g, a) % p;
		int B = (int) Math.pow(g, b) % p;

		int SSN = (int) Math.pow(B, a) % p;
		int SecretB = (int) Math.pow(A, b) % p;

		if (SSN == SecretB) {
			System.out.println("Secret key between sender and the receiver are the same");
			System.out.println("They share a secret no = " + SSN);
		}

		else {
			System.out.println("Secret key between sender and the receiver are not same");
		}
	}
}