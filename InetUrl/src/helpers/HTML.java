package helpers;

import java.io.*;
import java.net.*;

public class HTML {
  private static String line;

  @Deprecated
  public static void show(URL url) {
    if (url == null)
      return;
    try {
      DataInputStream dis = new DataInputStream(url.openStream());
      while ((line = dis.readLine()) != null)
        System.out.println(line);
    } catch (IOException e) {
      return;
    }
  }

  @Deprecated
  public static void show(String spec) {
    if (spec == null)
      return;
    BufferedReader reader = reader(Creator.URL(spec));
    if (reader == null) {
      System.err.println("Không thể kết nối để lấy nội dung trang web!");
      return;
    }
    try {
      System.out.println();
      while ((line = reader.readLine()) != null)
        System.out.println(line);
    } catch (IOException e) {
      Error.invalid("host");
    }
  }

  private static BufferedReader reader(URL url) {
    if (url == null)
      return null;
    try {
      return new BufferedReader(new InputStreamReader(url.openStream()));
    } catch (IOException e) {
      return null;
    }
  }
}
