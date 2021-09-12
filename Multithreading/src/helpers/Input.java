package helpers;

import java.math.*;
import java.util.Scanner;

public class Input {
  private static Scanner sc = new Scanner(System.in);
  private static String input = "";

  public static void setInput() {
    input = sc.nextLine();
  }

  public static BigInteger integer(String type, String description) {
    while (true) {
      System.out.print(description);
      setInput();

      if (type == "integer" && Checker.isInteger(input))
        return new BigInteger(input);
      else
        Error.invail(type);
    }
  }

  public static BigDecimal decimal(String type, String description) {
    while (true) {
      System.out.print(description);
      setInput();

      if (type == "decimal" && Checker.isDecimal(input))
        break;
      else if (type == "length" && Checker.isSize(input))
        break;
      else
        Error.invail(type);
    }
    return new BigDecimal(input);
  }

  public static BigDecimal width(String description, BigDecimal length) {
    while (true) {
      System.out.print(description);
      setInput();

      if (Checker.isWidth(input, length))
        break;
      else
        Error.invail("width");
    }
    return new BigDecimal(input);
  }
}
