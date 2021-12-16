package apps.ex2;

import java.net.*;

import clis.Layout;
import helpers.*;
import helpers.Error;

import java.io.*;

public class UDPOperationEchoClient {
  private static Layout layout = new Layout(72, "CLIENT KHÔNG KẾT NỐI");
  public final static int SERVER_PORT = 7;
  public static DatagramSocket datagramSocket = null;

  public static void main(String[] args) {
    try {
      datagramSocket = new DatagramSocket();
      layout.header(1);
      do {
        String operation = getOperation();
        String a = operation.split("(\\s)*([\\+\\-\\*\\/]){1}(\\s)*([-+]?\\d*[.]?\\d*|^[-+]?\\d+[.]?\\d*){1}$")[0];
        String b = operation.split("^([-+]?\\d*[.]?\\d*|^[-+]?\\d+[.]?\\d*){1}(\\s)*([\\+\\-\\*\\/]){1}(\\s)*")[1];
        String operator = operation.substring(a.length(), operation.length() - b.length()).trim();

        send(operator + " " + a + " " + b + "\n");

        System.out.println();
        System.out.println(receive());
      } while (Checker.isContinue());
    } catch (IOException e) {
      System.err.println(e);
    } finally {
      if (datagramSocket != null) {
        layout.footer(1, "Client đã kết thúc.");
        datagramSocket.close();
      }
    }
  }

  private static void send(String info) {
    try {
      datagramSocket.send(
          new DatagramPacket(info.getBytes(), info.getBytes().length, InetAddress.getByName("localhost"), SERVER_PORT));
    } catch (IOException e) {
      System.err.println("Không thể gưỉ gói tin");
    }
  }

  private static String receive() {
    try {
      byte[] buffer = new byte[6000];
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      datagramSocket.receive(packet);
      return new String(packet.getData(), 0, packet.getLength());
    } catch (IOException e) {
      System.err.println("Không thể nhận gói dữ liệu " + e);
    }
    return null;
  }

  private static boolean isOperation(String raw) {
    return raw.matches(
        "^([-+]?\\d*[.]?\\d*|^[-+]?\\d+[.]?\\d*){1}(\\s)*([\\+\\-\\*\\/]){1}(\\s)*([-+]?\\d*[.]?\\d*|^[-+]?\\d+[.]?\\d*){1}$");
  }

  private static String getOperation() {
    String input = null;
    while (true) {
      input = Input.getInput("Nhập một phép toán: ");

      if (isOperation(input))
        return input;
      else
        Error.invalid("operation");
    }
  }
}