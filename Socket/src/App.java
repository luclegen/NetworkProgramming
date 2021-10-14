import clis.*;
import helpers.*;
import helpers.Error;

public class App {
  private static int width = 77;
  private static Layout layout = new Layout(width, "BÀI TẬP CHƯƠNG 4	");

  public static void main(String[] args) throws Exception {
    layout.header(1);

    char choice = '0';
    do {
      System.out.println("Hãy chọn số bài tập mà bạn cần thực hiện? (1 -> 4 | 0: Để thoát chương trình)");
      choice = Input.getChar("Trả lời: ");

      switch (choice) {
        case '0':
          System.out.print("\nĐã thoát chương trình.");
          layout.footer(1);
          System.exit(0);
          break;

        case '1':
        case '2':
        case '3':
        case '4':
          System.out.println("Nằm ở gói: " + "Socket/src/apps/" + choice + ".\n");
          break;

        default:
          Error.invalid("answer");
      }
    } while (true);
  }

}
