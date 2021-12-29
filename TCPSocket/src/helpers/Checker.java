package helpers;

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

  // #region CHARACTER

  public static boolean isChar(String input) {
    return input.matches(".{1}");
  }

  // #endregion CHARACTER

  // #region NUMBER

  public static boolean isInteger(String input) {
    return input.matches("^[-+]?\\d+");
  }

  // #endregion NUMBER

}
