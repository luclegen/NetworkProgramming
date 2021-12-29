package apps.ex3;

import java.io.*;
import java.net.*;

import clis.Layout;
import controllers.TalkController;
import helpers.Input;
import models.Message;
import views.TalkView;

public class STCTalkTelnetServer extends TalkController {
  private static Layout layout = new Layout(72, "SERVER TUẦN TỰ");
  private final static int SERVER_PORT = 23;
  private static Socket socket = null;
  private static BufferedWriter out = null;
  private static BufferedReader in = null;

  public STCTalkTelnetServer(Message model, TalkView view) {
    super(model, view);
    try {
      out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    } catch (IOException e) {
      System.out.println("Không thể tạo đầu viết: " + e);
    }
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch (IOException e) {
      System.out.println("Không thể tạo đầu đọc: " + e);
    }
  }

  @Override
  public boolean send() {
    boolean isSend = super.send();
    if (isSend)
      try {
        out.write(getModel().getName());
        out.newLine();
        out.write(getModel().getContent());
        out.newLine();
        out.flush();
      } catch (IOException e) {
        System.err.println("Không thể gửi tin nhắn: " + e);
      }
    return isSend;
  }

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    layout.header(1);
    try {
      System.out.println("Đang liên kết tới cổng " + SERVER_PORT + " ...");
      serverSocket = new ServerSocket(SERVER_PORT);
      System.out.println("Server đã khởi động: " + serverSocket);
      System.out.println("Đang chờ client ...");

      while (true)
        try {
          socket = serverSocket.accept();
          System.out.println("Client đã được chấp nhận: " + socket);
          STCTalkTelnetServer server = new STCTalkTelnetServer(new Message(Input.getInput("Hãy nhập tên bạn: ")),
              new TalkView("Server", TalkView.LEFT));

          while (true) {
            server.receive(new Message(in.readLine(), in.readLine()));
          }
        } catch (IOException e) {
          System.err.println(" Kết nối bị lỗi: " + e);
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
