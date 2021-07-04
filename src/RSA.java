import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

class RSA {

	static int gcd(int e, int Q) {
		if (e == 0)
			return Q;
		else
			return gcd(Q % e, e);
	}

	public static void main(String args[]) {
		int p, q, r, Q1, Q2, n, Q, d = 0, e, i;
		double encryptmess;
		BigInteger decryptmes;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("----- RSA -----");
		System.out.println("Enter the message which you want to encrypt : ");
		int msg = sc.nextInt();
		System.out.println("Enter 2 prime numbers : (p,q) : ");
		p = sc.nextInt();
		q = sc.nextInt();
		
		n = p * q;
		Q = (p - 1) * (q - 1);
		System.out.println("The value of Q = " + Q);

		for (e = 2; e < Q; e++) {
			if (gcd(e, Q) == 1) {
				break;
			}
		}
		System.out.println("e (Public Key) = " + e);
		for (i = 0; i <= 9; i++) {
			int temp = 1 + (i * Q);
			if (temp % e == 0) {
				d = (temp / e);
				break;
			}
		}
		System.out.println("d (Private Key) = " + d);
		encryptmess = (Math.pow(msg, e)) % n;
		System.out.println("The prime numbers are : p : " + p +" q : "+ q);
		System.out.println("Modified RSA Encrypted message is : " + (long)(encryptmess));

		BigInteger N = BigInteger.valueOf(n);

		BigInteger C = BigDecimal.valueOf(encryptmess).toBigInteger();
		decryptmes = (C.pow(d)).mod(N);
		System.out.println("Modified RSA Derypted message is : " + decryptmes);
	}
}
