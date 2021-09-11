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

      if (type == "integer" && Check.isInteger(input))
        return new BigInteger(input);
      else
        Error.invail(type);
    }
  }

  public static BigDecimal decimal(String type, String description) {
    while (true) {
      System.out.print(description);
      setInput();

      if (type == "decimal" && Check.isDecimal(input))
        break;
      else if (type == "length" && Check.isSize(input))
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

      if (Check.isWidth(input, length))
        break;
      else
        Error.invail("width");
    }
    return new BigDecimal(input);
  }
}
