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

  private static void ex(int index) {
    Layout exLayout = new Layout(width, "BÀI TẬP " + index);
    exLayout.header(2);

    switch (index) {
      case 1: // Bài tập 1

        break;

      case 2: // Bài tập 2

        break;

      case 3: // Bài tập 3

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
