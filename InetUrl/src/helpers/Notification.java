package helpers;

public class Notification {

  public static void success(String type) {
    String msg = null;
    switch (type) {
      case "url":
        msg = "Bạn đã thêm 1 URL";
        break;

      case "history":
        msg = "Bạn đã xoá lịch sử duyệt web";
        break;

      default:
        break;
    }
    System.err.println("THÔNG BÁO: " + msg + ".\n");
  }

  public static void fail(String type) {
    String msg = null;
    switch (type) {
      case "connect":
        msg = "Kết nối thất bại";
        break;

      default:
        break;
    }
    System.err.println("CẢNH BÁO: " + msg + "!\n");
  }

}
