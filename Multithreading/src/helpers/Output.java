package helpers;

import java.math.BigInteger;

public class Output {
	public static void block(int i, int a, int b) {
		System.out.print(i + (i % a == b ? "\n" : " "));
	}

	public static void block(BigInteger i, String a, String b) {
		System.out.print(i + (i.mod(new BigInteger(a)).compareTo(new BigInteger(b)) == 0 ? "\n" : " "));
	}
}
