package helpers;

public class Error {

	public static void invalid(String type) {
		String name = null, reason = " không hợp lệ", extension = ", vui lòng nhập lại!\n";
		switch (type) {
		case "operation":
			name = "Phép tính";
			break;

		case "answer":
			name = "Câu trả lời";
			break;

		case "type":
			name = "Loại";
			break;

		case "msg":
			name = "Tin nhắn";
			break;

		case "username":
			name = "Tên người dùng";
			break;

		case "password":
			name = "Mật khẩu";
			break;

		case "hostname":
			name = "Không thể kết nối hoặc hostname";
			break;

		case "hostAddress":
			name = "Không thể kết nối hoặc địa chỉ IP";
			break;

		case "char":
			name = "Ký tự";
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
		case "hostname":
		case "hostAddress":
			extension = ".\nVui lòng kiểm tra kết nối Internet và thử lại sau!\n";
			break;

		default:
			break;
		}
		System.err.println("LỖI: " + name + reason + extension);
	}
}