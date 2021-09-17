package helpers;

public class Error {

	public static void invail(String type) {
		String name = null;
		switch (type) {
			case "integer":
				name = "Số nguyên";
				break;

			case "answer":
				name = "Câu trả lời";
				break;

			case "length":
				name = "Chiều dài";
				break;

			case "width":
				name = "Chiều rộng";
				break;

			default:
				name = "invail";
				break;
		}
		System.err.println("LỖI: " + name + " không hợp lệ, vui lòng nhập lại!\n");
	}
}