package helpers;

import java.io.IOException;
import java.net.*;
import java.util.regex.Pattern;

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

  // #region NUMBER

  public static boolean isInteger(String input) {
    return Pattern.matches("^[-+]?\\d+", input);
  }

  // #endregion NUMBER

  // #region NETWORK

  public static boolean isHostname(String host) {
    return Pattern.matches("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$", host);
  }

  public static boolean isHostAddress(String host) {
    return Pattern.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
        host);
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
