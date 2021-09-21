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

			case "spec":
				name = "Không thể kết nối hay địa chỉ web/IP hoặc hostname";
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

			case "ip":
				name = "Không thể kết nối hoặc địa chỉ IP";
				break;

			default:
				name = "invalid";
				break;
		}
		switch (type) {
			case "spec":
			case "url":
			case "host":
			case "hostname":
			case "ip":
				extension = ".\nVui lòng kiểm tra kết nối Internet và thử lại sau!\n";
				break;

			default:
				break;
		}
		System.err.println("LỖI: " + name + " không hợp lệ" + extension);
	}
}