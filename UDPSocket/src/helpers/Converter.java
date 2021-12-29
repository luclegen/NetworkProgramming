package helpers;

import java.math.BigInteger;

public class Converter {

  public static String integerToWords(String number) {
    String words = "";
    String[] digitName = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
    if (Checker.isInteger(number)) {
      if (number.charAt(0) == '-') {
        words += "âm ";
        number = number.replace("-", "");
      }
      if (number.length() == 1)
        return digitName[Integer.parseInt(number)];
      else {
        int index = Math.abs(number.length() <= 3
            ? 1
            : number.length() % 3 == 0
                ? 3
                : number.length() % 3);
        int unit = number.substring(index).length() > 9
            ? number.substring(index).length() % 9
            : number.substring(index).length();
        for (int i = 0; i < number.length(); i++) {
          if (i == 0)
            words += new BigInteger(
                number.length() > 1 && number.length() < 4 && number.charAt(0) - 48 == 0
                    ? number.substring(index)
                    : number.substring(0, index))
                        .compareTo(BigInteger.ZERO) == 0
                            ? ""
                            : number.length() == 2
                                ? number.charAt(i) - 48 == 0 && number.charAt(i + 1) - 48 > 0
                                    ? "lẻ"
                                    : number.charAt(i) - 48 == 1
                                        ? "mười"
                                        : integerToWords(number.substring(0, index)) + " mươi"
                                : integerToWords(number.substring(0, index))
                                    + (unit == 2
                                        ? " trăm"
                                        : unit == 3
                                            ? " nghìn"
                                            : unit == 6
                                                ? " triệu"
                                                : unit == 9
                                                    ? " tỷ"
                                                    : unit % 9 == 0
                                                        && number.substring(0, index).charAt(index - 1) - 48 != 0
                                                            ? " tỷ".repeat(number.substring(index).length() / 9)
                                                            : "");
          if (i == index)
            words += number.length() == 2
                ? number.charAt(i) - 48 > 0
                    ? " " + (number.charAt(i - 1) - 48 > 1 && number.charAt(i) - 48 == 1
                        ? "mốt"
                        : number.charAt(i - 1) - 48 != 1 && number.charAt(i) - 48 == 4
                            ? "tư"
                            : number.charAt(i - 1) - 48 > 0 && number.charAt(i) - 48 == 5
                                ? "lăm"
                                : integerToWords(number.substring(index)))
                    : ""
                : (new BigInteger(number.substring(0, index)).compareTo(BigInteger.ZERO) == 0
                    || new BigInteger(number.substring(index)).compareTo(BigInteger.ZERO) == 0
                        ? ""
                        : " ")
                    + integerToWords(number.substring(index));
        }
      }
    } else
      return "Không phải số nguyên";
    return words;
  }

  public static String toSentence(String text) {
    return text.length() > 0 ? toWords(text).substring(0, 1).toUpperCase() + toWords(text).substring(1) : text;
  }

  public static String toWords(String text) {
    return String.join(" ", text.trim().split("\\s+"));
  }

  public static String toReserveMessage(String text) {
    int i = -1;
    for (i = text.length() - 1; Character.toString(text.charAt(i)).matches("[^a-zA-Z0-9]"); i--) {
    }
    return text.substring(i + 1) + text.substring(0, i + 1);
  }
}
