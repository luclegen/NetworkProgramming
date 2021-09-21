package helpers;

import java.net.*;
import java.util.Scanner;

import models.*;

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

  // endregion GETTER

  // region NETWORK

  public static String surf(String... banList) {
    String result = null;
    BanList list = new BanList(banList);
    boolean isContinue = true;

    do {
      setInput("Địa chỉ web/IP hoặc hostname (\"exit\" để thoát): ");
      if (input.equals("exit"))
        break;

      if (Checker.isHostAddress(input) || Checker.isHostname(input)) {
        result = input;
        isContinue = false;
      } else {
        try {
          result = new URL(input).toString();
          isContinue = false;
        } catch (MalformedURLException e) {
          Error.invalid("spec");
          isContinue = true;
        }
      }
      if (list.isBan(new HostAddress(input)))
        Notification.ban("Trang web này");
    } while (isContinue || list.isBan(new HostAddress(input)));

    return result;
  }

  // endregion NETWORK
}
