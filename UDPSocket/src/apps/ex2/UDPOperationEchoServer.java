package apps.ex2;

import java.net.*;

import clis.Layout;

import java.io.*;
import java.math.BigDecimal;

public class UDPOperationEchoServer {
  private final static int PORT = 7;
  private static Layout layout = new Layout(72, "SERVER KHÔNG KẾT NỐI");
  private static DatagramSocket datagramSocket = null;
  private static InetAddress client = null;
  private static int port = -1;

  public static void main(String[] args) {
    try {
      layout.header(1);
      datagramSocket = new DatagramSocket(PORT);
      while (true) {
        String raw = receive();
        System.out.println("Server đã nhận chuỗi: \"" + raw + "\"");
        if (raw == null)
          break;
        String result = "Phép toán không hợp lệ!";
        if (isOperation(raw)) {
          String[] e = raw.substring(0, raw.length() - 1).split(" ");
          switch (e[0]) {
            case "+":
              result = new BigDecimal(e[1]).add(new BigDecimal(e[2])).toString();
              break;

            case "-":
              result = new BigDecimal(e[1]).subtract(new BigDecimal(e[2])).toString();
              break;

            case "*":
              result = new BigDecimal(e[1]).multiply(new BigDecimal(e[2])).toString();
              break;

            case "/":
              result = new BigDecimal(e[2]).compareTo(BigDecimal.ZERO) == 0 ? "Không thể chia cho số không!"
                  : new BigDecimal(e[1]).divide(new BigDecimal(e[2])).toString();
              break;

            default:
              break;
          }
        }
        send(result);
      }
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