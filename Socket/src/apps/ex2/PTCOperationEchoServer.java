package apps.ex2;

import java.io.*;
import java.net.*;

import clis.Layout;
import models.OperationRequestProcessing;

public class PTCOperationEchoServer {
  public final static int SERVER_PORT = 7;
  private static Layout layout = new Layout(72, "SERVER SONG SONG");

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

          System.out.println("Client đã được chấp nhận: " + socket);

          new OperationRequestProcessing(socket).start();
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
