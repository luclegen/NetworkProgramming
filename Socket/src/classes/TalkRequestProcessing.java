package classes;

import java.io.*;
import java.net.Socket;

import controllers.TalkController;
import models.Message;
import views.Talk;

public class TalkRequestProcessing extends TalkController implements Runnable {
  private static Socket socket = null;
  private static BufferedWriter out = null;
  private static BufferedReader in = null;

  public TalkRequestProcessing(Socket s, Message model, Talk view) {
    super(model, view);
    socket = s;
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

  @Override
  public void run() {
    try {
      while (true)
        receive(new Message(in.readLine(), in.readLine()));
    } catch (IOException e) {
      System.err.println("Lỗi xử lý yêu cầu: " + e);
    }
  }
}
