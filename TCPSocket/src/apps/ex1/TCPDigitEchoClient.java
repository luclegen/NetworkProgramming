package apps.ex1;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;

import clis.Layout;
import helpers.*;
import helpers.Error;

public class TCPDigitEchoClient {
  private static Layout layout = new Layout(72, "CLIENT CÓ KẾT NỐI");

  public static void main(String[] args) {
    Socket socket = null;
    layout.header(1);
    try {
      socket = new Socket("127.0.0.1", 7);
      System.out.println("Đã kết nối tới: " + socket);
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      do {
        String input = Input.getInput("Nhập vào một ký tự hoặc số: ");

        if (Checker.isInteger(input)) {
          out.write(new BigInteger(input).toString());
          out.newLine();
          out.flush();
        } else if (Checker.isChar(input)) {
          out.write(input);
          out.newLine();
          out.flush();
        } else {
          Error.invalid("input");
          continue;
        }

        System.out.println(in.readLine());
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
