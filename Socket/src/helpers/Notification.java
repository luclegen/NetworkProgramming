package helpers;

public class Notification {

  public static void fail(String type) {
    String msg = null;
    switch (type) {
    case "password":
      msg = "Mật khẩu không khớp";
      break;

    default:
      msg = "Loại thất bại không hợp lệ";
      break;
    }
    System.err.println("CẢNH BÁO: " + msg + "!\n");
  }
}
