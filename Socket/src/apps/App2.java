package apps;

import clis.Layout;

public class App2 {
  private static byte index = 2;
  private static Layout layout = new Layout(77, "BÀI TẬP " + index);

  public static void run() {
    layout.header(2);

    // Code here

    System.out.print("\n kết thúc bài tập " + index + ".");
    layout.footer(2);
  }
}
