package apps.ex4;

import java.io.*;
import java.net.Socket;

import clis.Layout;
import helpers.*;
import helpers.Error;

public class TCPAccountEchoClient {
  private static Layout layout = new Layout(72, "CLIENT CÓ KẾT NỐI");
  private static Socket socket = null;
  private static BufferedWriter out = null;
  private static BufferedReader in = null;

  public static void main(String[] args) {
    layout.header(1);
    try {
      socket = new Socket("127.0.0.1", 7);
      System.out.println("Đã kết nối tới: " + socket);
      out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      do {
        System.out.println("Hãy chọn một trong những chức năng sau: ");
        System.out.println("0. Thoát.");
        System.out.println("1. (Mặc định) Đăng nhập.");
        System.out.println("2. Tạo tài khoản.");
        switch (Input.getInput("Trả lời: ")) {
          case "0":
            socket.getOutputStream().write('0');
            return;

          case "":
          case "1":
            login();
            break;

          case "2":
            register();
            break;

          default:
            Error.invalid("answer");
            break;
        }
      } while (Checker.isContinue());
    } catch (IOException e) {
      System.err.println("Không thể kết nối tới server.");
    } finally {
      if (socket != null)
        try {
          layout.footer(1, "\n\nClient đã đóng kết nối.");
          socket.close();
        } catch (IOException e) {
          System.err.println("Không thể đóng: " + socket);
        }
    }
  }

  private static void login() {
    try {
      socket.getOutputStream().write('1');
      System.out.println("\n" + in.readLine());
      out.write(Input.getString("username", in.readLine()));
      out.newLine();
      out.flush();
      if (socket.getInputStream().read() == 0)
        System.err.println(in.readLine());
      else {
        out.write(Input.getPassword(in.readLine()));
        out.newLine();
        out.flush();
        if (socket.getInputStream().read() == 0)
          System.err.println(in.readLine());
        else {
          System.out.println(in.readLine());
          System.out.println();
          System.out.println(in.readLine());
          System.out.println(in.readLine());
          System.out.println(in.readLine());
        }
      }
    } catch (IOException e) {
      System.err.println("Đầu vào hoặc đầu ra hoặc socket bị lỗi: " + e);
    }
  }

  private static void register() {
    try {
      socket.getOutputStream().write('2');
      System.out.println("\n" + in.readLine());
      for (int i = 0; i < 2; i++) {
        out.write(Input.getInput(in.readLine()));
        out.newLine();
        out.flush();
      }
      int isUsername = 1;
      do {
        if (isUsername == 0)
          System.err.println(in.readLine());
        out.write(Input.getInput(in.readLine()));
        out.newLine();
        out.flush();
        isUsername = socket.getInputStream().read();
      } while (isUsername == 0);
      int isPassword = 1;
      do {
        if (isPassword == 0)
          System.err.println(in.readLine());
        out.write(Input.getPassword(in.readLine(), "Xác nhận      : "));
        out.newLine();
        out.flush();
        isPassword = socket.getInputStream().read();
      } while (isPassword == 0);
      System.out.println(in.readLine());
    } catch (IOException e) {
      System.err.println("Đầu vào hoặc đầu ra hoặc socket bị lỗi: " + e);
    }
  }
}
