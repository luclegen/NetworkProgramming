package helpers;

public class Notification {

  public static void fail(String type) {
    String msg = null;
    switch (type) {
      case "username":
        msg = "Tên người dùng đã tồn tại";
        break;

      case "register":
        msg = "Tên người dùng chưa đăng ký";
        break;

      case "password":
        msg = "Mật khẩu không khớp";
        break;

      case "login":
        msg = "Đăng nhập thất bại";
        break;

      default:
        msg = "Loại thất bại không hợp lệ";
        break;
    }
    System.err.println("CẢNH BÁO: " + msg + "!\n");
  }

}
