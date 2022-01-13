package helpers;

public abstract class Notification {

  public static void success(String type) {
    String msg = null;
    switch (type) {
      case "url":
        msg = "Bạn đã thêm 1 URL";
        break;

      case "history":
        msg = "Bạn đã xoá lịch sử duyệt web";
        break;

      case "account":
        msg = "Đã tạo tài khoản thành công";
        break;

      case "login":
        msg = "Đã đăng nhập thành công";
        break;

      default:
        msg = "Loại thành công không hợp lệ";
        break;
    }
    System.out.println("THÔNG BÁO: " + msg + ".\n");
  }

  public static void ban(String type) {
    System.err.println("THÔNG BÁO: " + type + " đã bị cấm.\n");
  }

  public static void fail(String type) {
    String msg = null;
    switch (type) {
      case "connect":
        msg = "Kết nối thất bại";
        break;

      case "username":
        msg = "Tên người dùng đã tồn tại";
        break;

      case "register":
        msg = "Tên người dùng chưa đăng ký";
        break;

      case "password":
        msg = "Mật khẩu không khớp";
        break;

      case "authentication":
        msg = "Sai mật khẩu";
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
