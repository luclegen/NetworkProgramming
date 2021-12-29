package apps.ex2;

import java.io.*;
import java.math.BigDecimal;
import java.net.*;

import clis.Layout;

public class STCOperationEchoServer {
  public final static int SERVER_PORT = 7;
  private static Layout layout = new Layout(72, "SERVER TUẦN TỰ");

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    layout.header(1);
    try {
      System.out.println("Đang liên kết tới cổng " + SERVER_PORT + " ...");
      serverSocket = new ServerSocket(SERVER_PORT);
      System.out.println("Server đã khởi động: " + serverSocket);
      System.out.println("Đang chờ client ...");
      while (true) {
        try {
          Socket socket = serverSocket.accept();
          BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

          System.out.println("Client đã được chấp nhận: " + socket);

          String raw = null;
          while (true) {
            raw = in.readLine();
            System.out.println("Server đã nhận chuỗi: \"" + raw + "\"");
            if (raw == null)
              break;
            String result = "Phép toán không hợp lệ!";
            if (isOperation(raw)) {
              String[] e = raw.substring(0, raw.length() - 2).split(" ");
              switch (e[0]) {
                case "+":
                  result = new BigDecimal(e[1]).add(new BigDecimal(e[2])).toString();
                  break;

                case "-":
                  result = new BigDecimal(e[1]).subtract(new BigDecimal(e[2])).toString();
                  break;

                case "*":
                  result = new BigDecimal(e[1]).multiply(new BigDecimal(e[2])).toString();
                  break;

                case "/":
                  try {
                    result = new BigDecimal(e[2]).compareTo(BigDecimal.ZERO) == 0 ? "Không thể chia cho số không!"
                        : new BigDecimal(e[1]).divide(new BigDecimal(e[2])).toString();
                  } catch (Exception ex) {
                    result = new BigDecimal(e[2]).compareTo(BigDecimal.ZERO) == 0 ? "Không thể chia cho số không!"
                        : Double.toString(new BigDecimal(e[1]).doubleValue() / new BigDecimal(e[2]).doubleValue());
                  }
                  break;

                default:
                  break;
              }
            }
            out.write(result);
            out.newLine();
            out.flush();
          }
          socket.close();
        } catch (IOException e) {
          System.err.println(" Kết nối bị lỗi: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("Tạo server thất bại: " + e);
    } finally {
      if (serverSocket != null)
        try {
          serverSocket.close();
        } catch (IOException e) {
          System.err.println("Đóng server thất bại: " + e);
        }
    }
  }

  public static boolean isOperation(String raw) {
    return raw.matches(
        "^([\\+\\-\\*\\/]){1}(\\s){1}([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}(\\s){1}([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*){1}(\\\\n){1}$");
  }
}
