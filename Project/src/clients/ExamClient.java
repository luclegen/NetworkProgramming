package clients;

import java.net.*;

import clis.Layout;
import controllers.LoginController;
import helpers.*;
import helpers.Error;
import models.Type;
import models.User;
import views.LoginView;

import java.io.*;

public class ExamClient extends LoginView {
  private static Layout layout = new Layout(72, "CLIENT KHÔNG KẾT NỐI");
  public final static int SERVER_PORT = 7;
  public static DatagramSocket datagramSocket = null;

  public static void main(String[] args) {
    try {
      datagramSocket = new DatagramSocket();
      layout.header(1);
      // new LoginController(new User(), new LoginView());
      // send(new User("Lực", "Huỳnh Tấn", "luc", "Luc123!@#", models.Type.Admin));
      System.out.println('C');
      System.out.println(receiveObject());
    } catch (IOException e) {
      System.err.println(e);
    } finally {
      if (datagramSocket != null) {
        layout.footer(1, "Client đã kết thúc.");
        datagramSocket.close();
      }
    }
  }

  private static void send(String msg) {
    try {
      datagramSocket.send(
          new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("localhost"), SERVER_PORT));
    } catch (IOException e) {
      System.err.println("Không thể gưỉ gói tin");
    }
  }

  private static void send(Serializable obj) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(obj);

      datagramSocket.send(
          new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, InetAddress.getByName("localhost"),
              SERVER_PORT));
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

  private static Object receiveObject() {
    ObjectInputStream is = null;
    try {
      try {
        byte[] buffer = new byte[6000];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
        // client = packet.getAddress();
        // port = packet.getPort();
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