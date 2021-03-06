package helpers;

import java.util.Scanner;

public abstract class Input {
  private static String input = "";

  public static String getInput(String description) {
    if (System.console() == null)
      System.out.print(description);
    return System.console() != null ? System.console().readLine(description) : new Scanner(System.in).nextLine();
  }

  public static void setInput(String description) {
    input = getInput(description);
  }

  // region CHARACTER

  public static char getChar(String description) {
    while (true) {
      setInput(description);

      if (Checker.isChar(input))
        return input.charAt(0);
      else
        Error.invalid("char");
    }
  }

  // endregion CHARACTER

}
