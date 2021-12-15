package helpers;

public abstract class Checker {

  // #region CHARACTER

  public static boolean isChar(String input) {
    return input.matches(".{1}");
  }

  // #endregion CHARACTER

}
