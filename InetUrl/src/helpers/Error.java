package helpers;

public class Error {

	public static void invail(String type) {
		String name = null;
		switch (type) {
			case "answer":
				name = "Câu trả lời";
				break;

			default:
				name = "invail";
				break;
		}
		System.err.println("LỖI: " + name + " không hợp lệ, vui lòng nhập lại!\n");
	}
}