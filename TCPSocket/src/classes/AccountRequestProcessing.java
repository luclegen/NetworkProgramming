package classes;

import java.io.*;
import java.net.Socket;
import java.util.*;

import clis.Layout;
import helpers.Checker;
import helpers.Error;

public class AccountRequestProcessing extends Thread {
  private Socket socket = null;
  private BufferedWriter out = null;
  private BufferedReader in = null;
  private List<User> users = new ArrayList<>();

  public AccountRequestProcessing(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      while (true) {
        char answer = (char) socket.getInputStream().read();
        if (answer == '￿')
          break;
        switch (answer) {
        case '0':
          new Layout(72).footer(2, "Client đã thoát.");
          break;

        case '1':
          login();
          break;

        case '2':
          register();
          break;

        default:
          Error.invalid("answer");
          break;
        }
      }
      socket.close();
    } catch (IOException e) {
      System.err.println("Lỗi xử lý yêu cầu: " + e);
    }
  }

  private void login() {
    try {
      User user = null;
      out.write("ĐĂNG NHẬP\n");
      out.write("Tên người dùng: \n");
      out.flush();
      String username = in.readLine();
      for (User u : users)
        if (u.getUsername().equals(username))
          user = u;
      if (user == null) {
        socket.getOutputStream().write(0);
        out.write("Tên người dùng chưa đăng ký! \n");
        out.flush();
      } else {
        socket.getOutputStream().write(1);
        out.write("Mật khẩu      : \n");
        out.flush();
        if (user.authenticate(in.readLine())) {
          socket.getOutputStream().write(1);
          out.write("Đã đăng nhập thành công.\n");
          out.write("THÔNG TIN TÀI KHOẢN\n");
          out.write("Họ và tên     : " + user.getLastName() + " " + user.getFirstName() + "\n");
          out.write("Tên người dùng: " + user.getUsername() + "\n");
          out.flush();
        } else {
          socket.getOutputStream().write(0);
          out.write("Sai mật khẩu!" + "\n");
          out.flush();
        }
      }
    } catch (IOException e) {
      System.err.println("Đầu vào hoặc đầu ra hoặc socket bị lỗi: " + e);
    }
  }

  private void register() {
    try {
      out.write("TẠO TÀI KHOẢN\n");
      out.write("Tên           : \n");
      out.flush();
      String firstName = in.readLine();
      out.write("Họ            : \n");
      out.flush();
      String lastName = in.readLine();
      String username = null;
      do {
        out.write("Tên người dùng: \n");
        out.flush();
        username = in.readLine();
        if (!Checker.isUsername(username)) {
          socket.getOutputStream().write(0);
          out.write("Tên người dùng không hợp lệ, vui lòng thử lại!\n");
          out.flush();
        }
      } while (!Checker.isUsername(username));
      socket.getOutputStream().write(1);
      String password = null;
      do {
        out.write("Mật khẩu      : \n");
        out.flush();
        password = in.readLine();
        if (password.length() < 8) {
          socket.getOutputStream().write(0);
          out.write("Mật khẩu ít nhất phải 8 kí tự, vui lòng thử lại!\n");
          out.flush();
        }
      } while (password.length() < 8);
      socket.getOutputStream().write(1);
      users.add(new User(firstName, lastName, username, password));
      out.write("Đã tạo tài khoản thành công.\n");
      out.flush();
    } catch (IOException e) {
      System.err.println("Đầu vào hoặc đầu ra hoặc socket bị lỗi: " + e);
    }
  }
}
