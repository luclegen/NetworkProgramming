package apps.ex1;

import java.io.*;
import java.net.*;

import clis.Layout;
import helpers.Converter;

public class STCDigitEchoServer {
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

          while (true) {
            String input = in.readLine();

            out.write(Converter.integerToWords(input));
            out.newLine();
            out.flush();
          }
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
