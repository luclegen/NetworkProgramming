import java.io.*;
import java.math.*;
import java.util.*;

import threads.*;
import helpers.*;
import helpers.Error;
import lib.Layout;

public class App {
  private static Scanner sc = new Scanner(System.in);
  private static int width = 77;
  private static Layout layout = new Layout(width, "BÀI TẬP CHƯƠNG 2");
  private static int N;
  private static List<Thread> threads = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    layout.header(1);

    do {
      char choice = '0';
      do {
        System.out.println("Hãy chọn số bài tập mà bạn cần thực hiện? (1 -> 5 | 0: Để thoát chương trình)");
        System.out.print("Bài tập ");
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

          default:
            Error.invail("answer");
        }
      } while (true);
    } while (true);
  }

  @SuppressWarnings("deprecation")
  private static void ex(int index) throws InterruptedException, IOException {
    Layout exLayout = new Layout(width, "BÀI TẬP " + index);
    exLayout.header(2);

    switch (index) {
      case 1: // Bài tập 1
        N = 4;
        BigInteger n = Input.integer("integer", "Hãy nhập vào số nguyên: n = ");

        for (int i = 1; i <= N; i++)
          threads.add(new ActiveThread1(i, n));

        runThreads();
        break;

      case 2: // Bài tập 2
        N = 3;

        ActiveThread2 main = new ActiveThread2();
        for (int i = 1; i <= N; i++)
          threads.add(new ActiveThread2(i));

        runThreads();

        main.start();
        System.out.print("[TUYẾN CHÍNH] đã khởi chạy...");

        synchronized (main) {
          System.out.print("\n[TUYẾN CHÍNH] đang chờ...");
          main.wait();
        }

        System.out.print("\n[TUYẾN CHÍNH] đã dừng.");
        main.stop();
        break;

      case 3: // Bài tập 3
        N = 2;

        ActiveThread3 main1 = new ActiveThread3();

        main1.start();
        System.out.print("\n[LUỒNG CHÍNH] đã khởi chạy...");

        synchronized (main1) {
          System.out.print("\n[LUỒNG CHÍNH] đang chờ...");
          main1.wait();
        }

        main1.stop();
        System.out.print("\n[LUỒNG CHÍNH] đã dừng.");
        break;

      case 4: // Bài tập 4
        System.out.println("Hãy nhập vào hai số nguyên:");
        BigInteger a = Input.integer("integer", "a = ");
        BigInteger b = Input.integer("integer", "b = ");
        System.out.println();

        BigInteger id = BigInteger.ONE;
        String dir = "./out/";
        String file = dir + "file.txt";
        File d = new File(dir);
        File f = new File(file);

        if (!d.exists())
          d.mkdirs();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)), true);

        if (a.compareTo(b) < 0)
          for (BigInteger i = a; i.compareTo(b) <= 0; i = i.add(BigInteger.ONE), id = id.add(BigInteger.ONE))
            threads.add(new ActiveThread4(id, i, out));
        else
          for (BigInteger i = b; i.compareTo(a) <= 0; i = i.add(BigInteger.ONE), id = id.add(BigInteger.ONE))
            threads.add(new ActiveThread4(id, i, out));

        runThreads();

        out.close();
        System.out.print("\nKết quả đã được ghi vào file " + file + ".");
        break;

      case 5: // Bài tập 5
        N = 2;

        for (int i = 1; i <= N; i++)
          threads.add(new ActiveThread5(i));

        runThreads();
        break;

      default:
        System.err.println("LỖI: Số bài tập không hợp lệ!");
        break;
    }

    threads.clear();
    System.out.print("\n\nĐã kết thúc bài tập " + index + ".");
    exLayout.footer(2);
  }

  @SuppressWarnings("deprecation")
  private static void runThreads() throws InterruptedException {
    System.out.println();

    for (Thread thread : threads) {
      thread.start();
      System.out.print("\n[TUYẾN " + thread.getId() + "] đã khởi chạy...");

      synchronized (thread) {
        System.out.print("\n[TUYẾN " + thread.getId() + "] đang chờ...");
        thread.wait();
      }
    }

    for (Thread thread : threads) {
      thread.stop();
      System.out.print("\n[TUYẾN " + thread.getId() + "] đã dừng.");
    }
  }

}
