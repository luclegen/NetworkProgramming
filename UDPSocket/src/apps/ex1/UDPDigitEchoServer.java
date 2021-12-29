package apps.ex1;

import java.net.*;

import clis.Layout;
import helpers.Converter;

import java.io.*;

public class UDPDigitEchoServer {
  private final static int PORT = 7;
  private static Layout layout = new Layout(72, "SERVER KHÔNG KẾT NỐI");
  private static DatagramSocket datagramSocket = null;
  private static InetAddress client = null;
  private static int port = -1;

  public static void main(String[] args) {
    try {
      layout.header(1);
      datagramSocket = new DatagramSocket(PORT);
      while (true)
        send(Converter.toSentence(Converter.integerToWords(receive())));
    } catch (IOException e) {
      System.err.println("Không thể gửi hoặc nhận gói tin" + e);
    } finally {
      if (datagramSocket != null)
        datagramSocket.close();
    }
  }

  private static void send(String info) {
    try {
      datagramSocket.send(new DatagramPacket(info.getBytes(), info.getBytes().length, client, port));
    } catch (IOException e) {
      System.err.println("Không thể gửi gói tin");
    }
  }

  private static String receive() {
    try {
      byte[] buffer = new byte[6000];
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      datagramSocket.receive(packet);
      client = packet.getAddress();
      port = packet.getPort();
      return new String(packet.getData(), 0, packet.getLength());
    } catch (IOException e) {
      System.err.println("Không thể nhận gói tin " + e);
    }
    return null;
  }

  public static boolean isOperation(String raw) {
    return raw.matches(
        "^([\\+\\-\\*\\/]){1}(\\s){1}([-+]?\\d*[.]?\\d*|^[-+]?\\d+[.]?\\d*){1}(\\s){1}([-+]?\\d*[.]?\\d*|^[-+]?\\d+[.]?\\d*){1}(\\\n){1}$");
  }
}