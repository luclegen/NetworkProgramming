package helpers;

import java.math.*;
import java.util.regex.Pattern;

public class Check {

	public static boolean isInteger(String input) {
		return Pattern.matches("^[-+]?\\d+", input);
	}

	public static boolean isDecimal(String input) {
		return Pattern.matches("^[-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*", input);
	}

	public static boolean isEven(BigInteger n) {
		return n.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0;
	}

	public static boolean isSize(String input) {
		return isDecimal(input) && new BigDecimal(input).compareTo(new BigDecimal("0")) == 1;
	}

	public static boolean isWidth(String input, BigDecimal length) {
		return isSize(input) && new BigDecimal(input).compareTo(length) <= 0;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return n > 1;
	}

	public static boolean isPrime(BigInteger n) {
		if (n.compareTo(BigInteger.TWO) < 0)
			return false;
		for (BigInteger i = BigInteger.TWO; (new BigDecimal(i))
				.compareTo(new BigDecimal(n).sqrt(new MathContext(2))) <= 0; i = i.add(BigInteger.ONE))
			if (n.mod(i).compareTo(new BigInteger("0")) == 0)
				return false;
		return true;
	}
}
