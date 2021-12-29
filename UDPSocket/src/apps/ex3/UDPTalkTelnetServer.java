package apps.ex3;

import java.net.*;

import controllers.TalkController;
import helpers.Input;
import models.Message;
import views.TalkView;

import java.io.*;

public class UDPTalkTelnetServer extends TalkController {
  private final static int CLIENT_PORT = 99;
  private static DatagramSocket datagramSocket = null;
  private static InetAddress client = null;

  public UDPTalkTelnetServer(Message model, TalkView view) {
    super(model, view);
    try {
      datagramSocket = new DatagramSocket(23);
    } catch (SocketException e) {
      System.err.println("Không thể tạo gói dữ liệu: " + e);
    }
  }

  @Override
  public boolean send() {
    boolean isSend = super.send();
    if (isSend)
      try {
        byte[] name = getModel().getName().getBytes();
        datagramSocket.send(new DatagramPacket(name, name.length, client, CLIENT_PORT));
        byte[] content = getModel().getContent().getBytes();
        datagramSocket.send(new DatagramPacket(content, content.length, client, CLIENT_PORT));
      } catch (IOException e) {
        System.err.println("Không thể gửi gói tin: " + e);
      }
    return isSend;
  }

  public static void main(String[] args) {
    try {
      byte[] buffer = new byte[6000];
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      client = InetAddress.getByAddress(Input.getHostAddress("Hãy nhập địa chỉ IP của client: ").getIp());

      UDPTalkTelnetServer server = new UDPTalkTelnetServer(new Message(Input.getInput("Hãy nhập tên bạn: ")),
          new TalkView("Server", TalkView.LEFT));
      while (true) {
        datagramSocket.receive(packet);
        String name = new String(packet.getData(), 0, packet.getLength());
        datagramSocket.receive(packet);
        String content = new String(packet.getData(), 0, packet.getLength());
        server.receive(new Message(name, content));
      }
    } catch (IOException e) {
      System.err.println(e);
    } finally {
      if (datagramSocket != null)
        datagramSocket.close();
    }
  }
}