package helpers;

import java.io.IOException;
import java.math.*;
import java.net.*;

public abstract class Checker {

	// region INPUT

	public static boolean isContinue() {
		while (true) {
			System.out.println("\nBạn có muốn tiếp tục? (Y/n)");
			switch (Input.getInput("Trả lời: ")) {
				case "":
				case "Y":
				case "y":
					System.out.println();
					return true;

				case "n":
				case "N":
					System.out.println();
					return false;

				default:
					Error.invalid("answer");
					break;
			}
		}
	}

	// endregion INPUT

	// #region STRING

	public static boolean isUsername(String input) {
		return input.matches("^[a-zA-Z0-9._-]+$");
	}

	// #endregion STRING

	// #region CHARACTER

	public static boolean isChar(String input) {
		return input.matches(".{1}");
	}

	// #endregion CHARACTER

	// #region NUMBER

	public static boolean isDigit(char input) {
		return Character.toString(input).matches("\\d{1}");
	}

	public static boolean isInteger(String input) {
		return input.matches("^[-+]?\\d+");
	}

	public static boolean isDecimal(String input) {
		return input.matches("^[-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*");
	}

	public static boolean isSize(String input) {
		return isDecimal(input) && new BigDecimal(input).compareTo(new BigDecimal("0")) == 1;
	}

	public static boolean isWidth(String input, BigDecimal length) {
		return isSize(input) && new BigDecimal(input).compareTo(length) <= 0;
	}

	public static boolean isEven(BigInteger n) {
		return n.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0;
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

	// #endregion NUMBER

	// #region MATH
	public static boolean isOperation(String input) {
		return input.matches(
				"^([\\+\\-\\*\\/]){1}(\\s){1}([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}(\\s){1}([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}(\n){1}");
	}
	// #endregion MATH

	// #region NETWORK

	public static boolean isHostname(String host) {
		return host.matches("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$");
	}

	public static boolean isHostAddress(String host) {
		return host.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
	}

	public static boolean isSuccessConnection(String spec) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(spec).openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();

			return connection.getResponseCode() == 200;
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean isSuccessConnection(URL url) {
		try {
			if (url == null)
				return false;

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();

			return connection.getResponseCode() == 200;
		} catch (IOException e) {
			return false;
		}
	}

	// #endregion NETWORK

	// region TIME

	public static boolean isDate(long d) {
		return d != 0;
	}

	// endregion TIME

}
