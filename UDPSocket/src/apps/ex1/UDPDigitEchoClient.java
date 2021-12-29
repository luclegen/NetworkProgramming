package apps.ex1;

import java.net.*;

import clis.Layout;
import helpers.*;
import helpers.Error;

import java.io.*;
import java.math.BigInteger;

public class UDPDigitEchoClient {
  private static Layout layout = new Layout(72, "CLIENT KHÔNG KẾT NỐI");
  public final static int SERVER_PORT = 7;
  public static DatagramSocket datagramSocket = null;

  public static void main(String[] args) {
    try {
      datagramSocket = new DatagramSocket();
      layout.header(1);
      do {
        String input = Input.getInput("Nhập vào một ký tự hoặc số: ");

        if (Checker.isInteger(input))
          send(new BigInteger(input).toString());
        else if (Checker.isChar(input))
          send(input);
        else {
          Error.invalid("input");
          continue;
        }

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
}