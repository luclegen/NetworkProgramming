package helpers;

public abstract class Error {

  public static void invalid(String type) {
    String name = null, reason = " không hợp lệ", extension = ", vui lòng nhập lại!\n";
    switch (type) {
      case "answer":
        name = "Câu trả lời";
        break;

      default:
        name = "Loại lỗi";
        break;
    }
    System.err.println("LỖI: " + name + reason + extension);
  }

}
