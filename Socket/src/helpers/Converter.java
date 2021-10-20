package helpers;

public class Converter {
  private static final String[] digitName = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };

  public static String digitToWord(char digit) {
    return Character.isDigit(digit) ? digitName[(int) digit - 48] : "Không phải số nguyên";
  }

  public static String toWords(String text) {
    return String.join(" ", text.trim().split("\\s+"));
  }

  public static String toSentenceCase(String text) {
    return text.length() > 0 ? toWords(text).substring(0, 1).toUpperCase() + toWords(text).substring(1).toLowerCase()
        : text;
  }

  public static String toReserveMessage(String text) {
    int i = -1;
    for (i = text.length() - 1; Character.toString(text.charAt(i)).matches("[^a-zA-Z0-9]"); i--) {
    }
    return text.substring(i + 1) + text.substring(0, i + 1);
  }
}
