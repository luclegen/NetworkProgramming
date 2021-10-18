package helpers;

public class Error {

	public static void invalid(String type) {
		String name = null, extension = ", vui lòng nhập lại!\n";
		switch (type) {
			case "operation":
				name = "Phép tính";
				break;

			case "answer":
				name = "Câu trả lời";
				break;

			case "hostname":
				name = "Không thể kết nối hoặc hostname";
				break;

			case "hostAddress":
				name = "Không thể kết nối hoặc địa chỉ IP";
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
		System.err.println("LỖI: " + name + " không hợp lệ" + extension);
	}
}