package apps.ex3;

import java.io.*;
import java.net.Socket;

import clis.Layout;
import controllers.TalkController;
import helpers.*;
import models.Message;
import views.Talk;

public class TCPTalkTelnetClient extends TalkController {
  private static Layout layout = new Layout(72, "CLIENT");
  private static Socket socket = null;
  private static BufferedWriter out = null;
  private static BufferedReader in = null;

  public TCPTalkTelnetClient(Message model, Talk view) {
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
    layout.header(1);
    try {
      socket = new Socket(Input.getHostAddress("Hãy nhập địa chỉ IP của server: ").toString(), 23);
      System.out.println("Đã kết nối tới: " + socket);
      TCPTalkTelnetClient client = new TCPTalkTelnetClient(new Message(Input.getInput("Hãy nhập tên bạn: ")),
          new Talk("Client", Talk.RIGHT));
      while (true)
        client.receive(new Message(in.readLine(), in.readLine()));
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
