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

			case "msg":
				name = "Tin nhắn";
				break;

			case "username":
				name = "Tên người dùng";
				break;

			case "password":
				name = "Mật khẩu";
				break;

			case "type":
				name = "Loại";
				break;

			case "char":
				name = "Ký tự";
				break;

			case "operation":
				name = "Phép toán";
				break;

			case "column":
				name = "Số cột";
				break;

			case "integer":
				name = "Số nguyên";
				break;

			case "decimal":
				name = "Số thập phân";
				break;

			case "length":
				name = "Chiều dài";
				break;

			case "width":
				name = "Chiều rộng";
				break;

			case "spec":
				name = "Không thể kết nối hay địa chỉ web/IP hoặc hostname";
				break;

			case "address":
				name = "Không thể kết nối hoặc địa chỉ";
				break;

			case "url":
				name = "Không thể kết nối hoặc địa chỉ URL";
				break;

			case "host":
				name = "Không thể kết nối hoặc hostname/địa chỉ IP";
				break;

			case "hostname":
				name = "Không thể kết nối hoặc hostname";
				break;

			case "hostAddress":
				name = "Không thể kết nối hoặc địa chỉ IP";
				break;

			default:
				name = "Loại lỗi";
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
			case "spec":
			case "address":
			case "url":
			case "host":
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