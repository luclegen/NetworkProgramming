package helpers;

public class Checker {

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

  // #region NETWORK

  public static boolean isHostname(String host) {
    return host.matches("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$");
  }

  public static boolean isHostAddress(String host) {
    return host.matches("^((25[0-5]|2[0-4][0-9]|[1]?[1-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[1]?[1-9][0-9]?)$");
  }

  // #endregion NETWORK
}
