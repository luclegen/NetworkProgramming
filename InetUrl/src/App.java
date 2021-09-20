import java.io.*;
import java.net.*;
import java.util.Scanner;

import apps.Web;
import clis.*;
import helpers.Error;

public class App {
  private static Scanner sc = new Scanner(System.in);
  private static int width = 77;
  private static Layout layout = new Layout(width, "BÀI TẬP CHƯƠNG 3	");

  public static void main(String[] args) throws Exception {
    layout.header(1);

    do {
      char choice = '0';
      do {
        System.out.println("Hãy chọn số bài tập mà bạn cần thực hiện? (1 -> 6 | 0: Để thoát chương trình)");
        System.out.print("Trả lời: ");
        choice = sc.next().charAt(0);

        switch (choice) {
          case '0':
            System.out.print("\nĐã thoát chương trình.");
            layout.footer(1);
            System.exit(0);
            break;

          case '1':
            ex(1);
            break;

          case '2':
            ex(2);
            break;

          case '3':
            ex(3);
            break;

          case '4':
            ex(4);
            break;

          case '5':
            ex(5);
            break;

          case '6':
            ex(6);
            break;

          default:
            Error.invalid("answer");
        }
      } while (true);

    } while (true);
  }

  private static void ex(int index) throws IOException {
    Layout exLayout = new Layout(width, "BÀI TẬP " + index);
    exLayout.header(2);

    URL u = null;

    switch (index) {
      case 1: // Bài tập 1
        u = new URL("https", "www.apple.com", 9999, "/mac/");

        System.out.println("Thông tin về URL: " + u.toString());
        System.out.println("Tên file: " + u.getFile());
        System.out.println("Tên host: " + u.getHost());
        System.out.println("Số hiệu cổng: " + u.getPort());
        System.out.println("Kiểu giao thức: " + u.getProtocol());
        break;

      case 2: // Bài tập 2
        u = new URL("https://github.com/luclegen");

        System.out.print("Toàn bộ nội dung của trang web:\n" + u.getContent());
        break;

      case 3: // Bài tập 3
        System.out.println("Địa chỉ của localhost:");
        System.out.println(InetAddress.getLocalHost());
        System.out.println("\nĐịa chỉ của trang web Oracle:");
        System.out.println(InetAddress.getByName("www.oracle.com") + "\n");
        break;

      case 4: // Bài tập 4

        break;

      case 5: // Bài tập 5

        break;

      case 6: // Bài tập 6
        Web.run();
        break;

      default:
        System.err.println("LỖI: Số bài tập không hợp lệ!\n");
        break;
    }

    System.out.print("\n\nĐã kết thúc bài tập " + index + ".");
    exLayout.footer(2);
  }

}
