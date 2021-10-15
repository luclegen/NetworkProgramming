package apps.ex1;

import java.io.*;
import java.net.Socket;

import clis.Layout;
import helpers.*;

public class TCPDigitEchoClient {
  private static Layout layout = new Layout(72, "CLIENT");

  public static void main(String[] args) {
    Socket socket = null;
    layout.header(1);
    try {
      socket = new Socket("127.0.0.1", 7);
      System.out.println("Đã kết nối tới: " + socket);
      do {
        socket.getOutputStream().write(Input.getChar("Nhập một ký tự: "));
        System.out.println(
            Converter.toSentenceCase(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine()));
      } while (Checker.isContinue());
    } catch (IOException e) {
      System.err.println("Không thể kết nối tới server.");
    } finally {
      if (socket != null)
        try {
          layout.footer(1, "Client đã đóng kết nối.");
          socket.close();
        } catch (IOException e) {
          System.err.println("Không thể đóng: " + socket);
        }
    }
  }
}
