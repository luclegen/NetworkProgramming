package apps.ex4;

import java.net.*;

import clis.Layout;
import helpers.Checker;
import helpers.Error;
import helpers.Input;

import java.io.*;

public class UDPAccountEchoClient {
  private static Layout layout = new Layout(72, "CLIENT KHÔNG KẾT NỐI");
  public final static int SERVER_PORT = 7;
  public static DatagramSocket datagramSocket = null;

  public static void main(String[] args) {
    try {
      datagramSocket = new DatagramSocket();
      layout.header(1);
      do {
        System.out.println("Hãy chọn một trong những chức năng sau: ");
        System.out.println("0. Thoát.");
        System.out.println("1. (Mặc định) Đăng nhập.");
        System.out.println("2. Tạo tài khoản.");
        String choice = Input.getInput("1", "Trả lời: ");
        send(choice);
        switch (choice) {
          case "0":
            return;

          case "1":
            login();
            break;

          case "2":
            register();
            break;

          default:
            Error.invalid("answer");
            break;
        }
      } while (Checker.isContinue());
    } catch (IOException e) {
      System.err.println(e);
    } finally {
      if (datagramSocket != null)
        datagramSocket.close();
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

  private static void login() {
    System.out.println();
    send(Input.getString("username", receive()));
    if (!Boolean.parseBoolean(receive())) {
      System.err.println(receive());
    } else {
      send(Input.getPassword(receive()));
      if (!Boolean.parseBoolean(receive()))
        System.err.println(receive());
      else {
        System.out.println(receive());
        System.out.println();
        System.out.println(receive());
        System.out.println(receive());
        System.out.println(receive());
      }
    }
  }

  private static void register() {
    System.out.println();
    for (int i = 0; i < 2; i++)
      send(Input.getInput(receive()));
    boolean isUsername = true;
    do {
      if (!isUsername)
        System.err.println(receive());
      send(Input.getInput(receive()));
      isUsername = Boolean.parseBoolean(receive());
    } while (!isUsername);
    boolean isPassword = true;
    do {
      if (!isPassword)
        System.err.println(receive());
      send(Input.getPassword(receive(), "Xác nhận      : "));
      isPassword = Boolean.parseBoolean(receive());
    } while (!isPassword);
    System.out.println(receive());
  }
}