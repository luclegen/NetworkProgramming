package helpers;

import java.io.IOException;
import java.net.*;
import java.util.regex.Pattern;

public class Checker {

  // region INPUT

  public static boolean isContinue() {
    while (true) {
      System.out.println("Bạn có muốn tiếp tục? (Y/n)");
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

  // #region NUMBER

  public static boolean isInteger(String input) {
    return Pattern.matches("^[-+]?\\d+", input);
  }

  // #endregion NUMBER

  // #region NETWORK

  public static boolean isSuccessConnection(String url) {
    try {
      HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

      connection.setRequestMethod("GET");
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
