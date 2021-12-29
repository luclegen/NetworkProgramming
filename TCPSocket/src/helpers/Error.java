package helpers;

public abstract class Error {

  public static void invalid(String type) {
    String name = null, reason = " không hợp lệ", extension = ", vui lòng nhập lại!\n";
    switch (type) {
      case "input":
        name = "Đầu vào";
        break;

      case "answer":
        name = "Câu trả lời";
        break;

      case "char":
        name = "Ký tự";
        break;

      case "operation":
        name = "Phép toán";
        break;

      case "hostAddress":
        name = "Không thể kết nối hoặc địa chỉ IP";
        break;

      case "username":
        name = "Tên người dùng";
        break;

      case "password":
        name = "Mật khẩu";
        break;

      default:
        name = "Tên lỗi";
        break;
    }
    switch (type) {
      case "password":
        reason = " chứa ít nhất 8 ký tự";
        break;

      default:
        break;
    }
    switch (type) {
      case "hostAddress":
        extension = ".\nVui lòng kiểm tra kết nối Internet và thử lại sau!\n";
        break;

      default:
        break;
    }
    System.err.println("LỖI: " + name + reason + extension);
  }
}
