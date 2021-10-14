package apps.app1;

import java.io.*;
import java.net.*;

import clis.Layout;
import models.DigitRequestProcessing;

public class PTCDigitEchoServer {
  public final static int SERVER_PORT = 7;
  private static Layout layout = new Layout(70, "SERVER TUẦN TỰ");

  public static void main(String[] args) {
    layout.header(1);
    ServerSocket serverSocket = null;
    try {
      System.out.println("Đang liên kết tới cổng " + SERVER_PORT + " ...");
      serverSocket = new ServerSocket(SERVER_PORT);
      System.out.println("Server đã khởi động: " + serverSocket);
      System.out.println("Đang chờ client ...");
      while (true) {
        try {
          Socket socket = serverSocket.accept();

          System.out.println("Client đã chấp nhận: " + socket);

          new DigitRequestProcessing(socket).start();
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
