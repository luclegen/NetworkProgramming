package apps.app1;

import java.io.*;
import java.net.*;

import clis.Layout;
import helpers.Converter;

public class STCDigitEchoServer {
  public final static int SERVER_PORT = 7;
  private static Layout layout = new Layout(70, "SERVER TUẦN TỰ");

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

          System.out.println("Client đã chấp nhận: " + socket);

          int ch = 0;
          while (true) {
            ch = socket.getInputStream().read();
            if (ch == -1)
              break;

            out.write(Converter.digitToWord((char) ch));
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
}
