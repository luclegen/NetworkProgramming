package apps.ex4;

import java.net.*;
import java.util.*;

import classes.User;
import clis.Layout;
import helpers.Checker;
import helpers.Error;

import java.io.*;

public class UDPAccountEchoServer {
  private final static int PORT = 7;
  private static Layout layout = new Layout(72, "SERVER TUẦN TỰ");
  private static DatagramSocket datagramSocket = null;
  private static InetAddress client = null;
  private static int port = -1;
  private static List<User> users = new ArrayList<>();

  public static void main(String[] args) {
    try {
      datagramSocket = new DatagramSocket(PORT);
      while (true) {
        switch (receive()) {
        case "0":
          layout.footer(2, "Client đã thoát.");
          break;

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
      }
    } catch (IOException e) {
      System.err.println("Không thể gửi hoặc nhận gói tin" + e);
    } finally {
      if (datagramSocket != null)
        datagramSocket.close();
    }
  }

  private static void login() {
    User user = null;
    send("ĐĂNG NHẬP\nTên người dùng: ");
    String username = receive();
    for (User u : users)
      if (u.getUsername().equals(username))
        user = u;
    if (user == null) {
      send("false");
      send("Tên người dùng chưa đăng ký! ");
    } else {
      send("true");
      send("Mật khẩu      : ");
      if (user.authenticate(receive())) {
        send("true");
        send("Đã đăng nhập thành công.");
        send("THÔNG TIN TÀI KHOẢN");
        send("Họ và tên     : " + user.getLastName() + " " + user.getFirstName());
        send("Tên người dùng: " + user.getUsername());
      } else {
        send("false");
        send("Sai mật khẩu!");
      }
    }
  }

  private static void register() {
    send("TẠO TÀI KHOẢN\nTên           : ");
    String firstName = receive();
    send("Họ            : ");
    String lastName = receive();
    String username = null;
    do {
      send("Tên người dùng: ");
      username = receive();
      if (!Checker.isUsername(username)) {
        send("false");
        send("Tên người dùng không hợp lệ, vui lòng thử lại!");
      }
    } while (!Checker.isUsername(username));
    send("true");
    String password = null;
    do {
      send("Mật khẩu      : ");
      password = receive();
      if (password.length() < 8) {
        send("false");
        send("Mật khẩu ít nhất phải 8 kí tự, vui lòng thử lại!");
      }
    } while (password.length() < 8);
    send("true");
    users.add(new User(firstName, lastName, username, password));
    send("Đã tạo tài khoản thành công.");
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
}