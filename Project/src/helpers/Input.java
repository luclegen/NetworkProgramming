package helpers;

import java.math.*;
import java.net.*;
import java.util.*;

import models.User;

public abstract class Input {
  private static String input = "";

  // region GETTERS AND SETTERS

  public static String getInput() {
    return System.console() != null ? System.console().readLine() : new Scanner(System.in).nextLine();
  }

  public static void setInput() {
    input = getInput();
  }

  public static String getInput(String description) {
    if (System.console() == null)
      System.out.print(description);
    return System.console() != null ? System.console().readLine(description) : new Scanner(System.in).nextLine();
  }

  public static void setInput(String description) {
    input = getInput(description);
  }

  public static String getInput(String defaultValue, String description) {
    input = getInput(description);
    return input.equals("") ? defaultValue : input;
  }

  // endregion region GETTERS AND SETTERS

  // region STRING

  public static String getString(String type, String description) {
    while (true) {
      switch (type) {
        case "msg":
        case "username":
          setInput(description);
          break;

        case "password":
          setPassword(description);
          break;

        default:
          Error.invalid("type");
          break;
      }

      if (type == "msg" && input.length() > 0)
        break;
      else if (type == "username" && Checker.isUsername(input))
        break;
      else if (type == "password" && input.length() > 7)
        break;
      else
        Error.invalid(type);
    }
    return input;
  }

  public static String getUsername(List<User> users, String description) {
    while (true) {
      boolean isAvailable = true;
      setInput(description);

      if (Checker.isUsername(input)) {
        for (User user : users)
          if (user.getUsername().equals(input)) {
            isAvailable = false;
            Notification.fail("username");
          }
        if (isAvailable)
          return input;
      } else
        Error.invalid("username");
    }
  }

  // endregion STRING

  // region PASSWORD

  public static String getPassword(String description) {
    if (System.console() == null)
      System.out.print(description);
    return System.console() != null ? new String(System.console().readPassword(description))
        : new Scanner(System.in).nextLine();
  }

  public static void setPassword(String description) {
    input = getPassword(description);
  }

  public static String getPassword(String description1, String description2) {
    while (true) {
      setPassword(description1);
      if (input.length() > 7) {
        if (input.equals(getPassword(description2)))
          return input;
        else
          Notification.fail("password");
      } else
        Error.invalid("password");
    }
  }

  // endregion PASSWORD

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

  // region NUMBER

  public static BigInteger getInteger(String type, String description) {
    while (true) {
      setInput(description);

      if (type == "integer" && Checker.isInteger(input))
        return new BigInteger(input);
      else
        Error.invalid(type);
    }
  }

  public static BigDecimal getDecimal(String type, String description) {
    while (true) {
      setInput(description);

      if (type == "decimal" && Checker.isDecimal(input))
        break;
      else if (type == "length" && Checker.isSize(input))
        break;
      else
        Error.invalid(type);
    }
    return new BigDecimal(input);
  }

  public static BigDecimal width(String description, BigDecimal length) {
    while (true) {
      setInput(description);

      if (Checker.isWidth(input, length))
        break;
      else
        Error.invalid("width");
    }
    return new BigDecimal(input);
  }

  // endregion NUMBER

}
