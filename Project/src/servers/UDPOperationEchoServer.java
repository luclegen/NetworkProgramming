package servers;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import clis.Layout;
import daos.UserDAO;
import helpers.Input;
import models.Type;
import models.User;

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
      List<User> users = new ArrayList<>();

      // User admin = new User(
      // Input.getInput(
      // "Tên : "),
      // Input.getInput(
      // "Họ : "),
      // Input.getUsername(users,
      // "Tên người dùng: "),
      // Input.getPassword("Mật khẩu : ", "Xác nhận : "), Type.Admin);

      // User admin = new User("Lực", "Huỳnh Tấn", "luc", "Luc123!@#", Type.Admin);

      // UserDAO.create(admin);

      while (true) {
        // User admin = (User) receiveObject();
        // System.out.println(admin);
        System.out.println('S');
        send(new User("Lực", "Huỳnh Tấn", "luc", "Luc123!@#", models.Type.Admin));
        // send(admin);
        // receive();
      }
    } catch (IOException e) {
      System.err.println("Không thể gửi hoặc nhận gói tin" + e);
    } finally {
      if (datagramSocket != null)
        datagramSocket.close();
    }
  }

  private static void send(String msg) {
    try {
      datagramSocket.send(new DatagramPacket(msg.getBytes(), msg.getBytes().length,
          client, port));
    } catch (IOException e) {
      System.err.println("Không thể gửi gói tin");
    }
  }

  private static void send(Serializable obj) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(obj);

      datagramSocket.send(
          new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, InetAddress.getByName("localhost"),
              PORT));
    } catch (IOException e) {
      System.err.println("Không thể gưỉ gói tin");
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

  private static Object receiveObject() {
    ObjectInputStream is = null;
    try {
      try {
        byte[] buffer = new byte[6000];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
        client = packet.getAddress();
        port = packet.getPort();
        is = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(buffer)));

        return is.readObject();
      } catch (ClassNotFoundException e) {
        return null;
      } finally {
        is.close();
      }
    } catch (IOException e) {
      System.err.println("Không thể nhận gói tin " + e);
    }
    return null;
  }
}