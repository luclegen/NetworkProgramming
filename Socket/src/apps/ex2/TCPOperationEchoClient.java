package apps.ex2;

import java.io.*;
import java.net.Socket;

import clis.Layout;
import helpers.*;
import helpers.Error;

public class TCPOperationEchoClient {
  private static Layout layout = new Layout(72, "CLIENT");

  public static void main(String[] args) {
    Socket socket = null;
    layout.header(1);
    try {
      socket = new Socket("127.0.0.1", 7);
      System.out.println("Đã kết nối tới: " + socket);
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      do {
        String operation = getOperation();
        String a = operation.split("(\\s)*([\\+\\-\\*\\/]){1}(\\s)*([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}$")[0];
        String b = operation.split("^([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}(\\s)*([\\+\\-\\*\\/]){1}(\\s)*")[1];
        String operator = operation.substring(a.length(), operation.length() - b.length()).trim();

        out.write(operator + " " + a + " " + b + "\\n");
        out.newLine();
        out.flush();

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

  private static boolean isOperation(String raw) {
    return raw.matches(
        "^([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}(\\s)*([\\+\\-\\*\\/]){1}(\\s)*([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}$");
  }

  private static String getOperation() {
    String input = null;
    while (true) {
      input = Input.getInput("Nhập một phép tính: ");

      if (isOperation(input))
        return input;
      else
        Error.invalid("operation");
    }
  }
}
