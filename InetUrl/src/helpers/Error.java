package helpers;

public class Error {

	public static void invalid(String type) {
		String name = null, extension = ", vui lòng nhập lại!\n";
		switch (type) {
			case "column":
				name = "Số cột";
				break;

			case "answer":
				name = "Câu trả lời";
				break;

			case "url":
				name = "Không thể kết nối hoặc địa chỉ URL";
				break;

			case "ip":
				name = "Không thể kết nối hoặc địa chỉ IP";
				break;

			default:
				name = "invalid";
				break;
		}
		switch (type) {
			case "url":
			case "ip":
				extension = ".\nVui lòng kiểm tra kết nối Internet và thử lại sau!\n";
				break;

			default:
				break;
		}
		System.err.println("LỖI: " + name + " không hợp lệ" + extension);
	}
}