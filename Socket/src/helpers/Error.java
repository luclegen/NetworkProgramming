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

			default:
				break;
		}
		System.err.println("LỖI: " + name + " không hợp lệ" + extension);
	}
}