package helpers;

import java.util.*;

public class Input {
  private static Scanner sc = new Scanner(System.in);
  private static String input = "";

  // region SETTER
  public static void setInput() {
    input = sc.nextLine();
  }

  public static void setInput(String description) {
    System.out.print(description);
    input = sc.nextLine();
  }
  // endregion SETTER

  // region GETTER

  public static String getInput() {
    setInput();
    return input;
  }

  public static String getInput(String description) {
    setInput(description);
    return input;
  }

  public static char getChar(String description) {
    setInput(description);
    return input.charAt(0);
  }

  // endregion GETTER

}
