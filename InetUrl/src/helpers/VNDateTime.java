package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VNDateTime {
  private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"),
      tf = DateTimeFormatter.ofPattern("HH:mm:ss"), stf = DateTimeFormatter.ofPattern("HH:mm");

  private static Date date;

  @Deprecated
  public static String getDay() {
    return date.getDate() < 10 ? "0" + date.getDate() : date.getDate() + "";
  }

  @Deprecated
  public static String getMonth() {
    return (date.getMonth() < 9 ? "0" : "") + date.getMonth() + 1;
  }

  @Deprecated
  public static String getYear() {
    return date.getYear() + 1900 + "";
  }

  public static String getDate() {
    return getDay() + "/" + getMonth() + "/" + getYear();
  }

  @Deprecated
  public static String getHours() {
    return date.getHours() < 10 ? "0" + date.getHours() : "" + date.getHours();
  }

  @Deprecated
  public static String getMinutes() {
    return date.getMinutes() < 10 ? "0" + date.getMinutes() : "" + date.getMinutes();
  }

  @Deprecated
  public static String getSeconds() {
    return date.getSeconds() < 10 ? "0" + date.getSeconds() : "" + date.getSeconds();
  }

  public static String getTime() {
    return getHours() + ":" + getMinutes() + ":" + getSeconds();
  }

  public static String getShortTime() {
    return getHours() + ":" + getMinutes();
  }

  public static String getDateTime(Date d) {
    date = d;
    return getDate() + " lúc " + getTime();
  }

  public static String getDateTime(LocalDateTime d) {
    return d.format(df) + " vào lúc " + d.format(tf);
  }

  public static String getDateShortTime(Date d) {
    date = d;
    return getDate() + " lúc " + getShortTime();
  }

  public static String getDateShortTime(LocalDateTime d) {
    return d.format(df) + " vào lúc " + d.format(stf);
  }

  public static String getDate(Date d) {
    date = d;
    return getDate();
  }

  public static String getDate(LocalDateTime d) {
    return d.format(df);
  }

  public static String getTime(Date d) {
    date = d;
    return getTime();
  }

  public static String getTime(LocalDateTime d) {
    return d.format(tf);
  }

  public static String getShortTime(Date d) {
    date = d;
    return getShortTime();
  }

  public static String getShortTime(LocalDateTime d) {
    return d.format(stf);
  }
}
