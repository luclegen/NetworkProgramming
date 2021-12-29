package apps.ex3;

import java.net.*;

import controllers.TalkController;
import helpers.Input;
import models.Message;
import views.TalkView;

import java.io.*;

public class UDPTalkTelnetClient extends TalkController {
  private final static int SERVER_PORT = 23;
  private static DatagramSocket datagramSocket = null;
  private static InetAddress server = null;

  public UDPTalkTelnetClient(Message model, TalkView view) {
    super(model, view);
    try {
      datagramSocket = new DatagramSocket(99);
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
        datagramSocket.send(new DatagramPacket(name, name.length, server, SERVER_PORT));
        byte[] content = getModel().getContent().getBytes();
        datagramSocket.send(new DatagramPacket(content, content.length, server, SERVER_PORT));
      } catch (IOException e) {
        System.err.println("Không thể gửi gói tin: " + e);
      }
    return isSend;
  }

  public static void main(String[] args) {
    try {
      byte[] buffer = new byte[6000];
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      server = InetAddress.getByAddress(Input.getHostAddress("Hãy nhập địa chỉ IP của server: ").getIp());
      UDPTalkTelnetClient client = new UDPTalkTelnetClient(new Message(Input.getInput("Hãy nhập tên bạn: ")),
          new TalkView("Client", TalkView.RIGHT));
      while (true) {
        packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
        String name = new String(packet.getData(), 0, packet.getLength());
        datagramSocket.receive(packet);
        String content = new String(packet.getData(), 0, packet.getLength());
        client.receive(new Message(name, content));
      }
    } catch (IOException e) {
      System.err.println(e);
    } finally {
      if (datagramSocket != null)
        datagramSocket.close();
    }
  }
}