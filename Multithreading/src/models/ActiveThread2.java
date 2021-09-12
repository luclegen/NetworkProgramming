package models;

import java.math.BigDecimal;

import helpers.Input;

public class ActiveThread2 extends Thread {
	private int id = 0;
	private static BigDecimal l, w, s, c;

	public ActiveThread2() {
		System.out.println("[TUYẾN CHÍNH] đã được tạo...");
	}

	public ActiveThread2(int id) {
		this.id = id;

		String notification = "";
		switch (this.id) {
			case 1:
			case 2:
			case 3:
				notification = "[TUYẾN " + this.id + "] đã được tạo...";
				break;

			default:
				System.err.println("ID = " + id + " không hợp lệ");
				break;
		}
		System.out.println(notification);
	}

	public synchronized BigDecimal getS() {
		return s;
	}

	public synchronized BigDecimal getC() {
		return c;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void run() {
		synchronized (this) {
			String task = "";

			switch (this.id) {
				case 1:
					task = "\n[TUYẾN " + this.id + "] cho phép người dùng nhập vào 2 số thực là 2 cạnh của hình chữ nhật.";
					System.out.println(task);
					System.out.println("Hãy nhập vào độ dài 2 cạnh của hình chữ nhật");
					l = Input.decimal("length", "Chiều dài : l = ");
					w = Input.width("Chiều rộng: w = ", l);
					break;

				case 2:
					task = "\n[TUYẾN " + this.id + "] tính diện tích hình chữ nhật ở tuyến 1.";
					System.out.println(task);
					s = l.multiply(w);
					break;

				case 3:
					task = "\n[TUYẾN " + this.id + "] tính chu vi hình chữ nhật ở tuyến 1.";
					System.out.println(task);
					c = (new BigDecimal("2")).multiply(l.add(w));
					break;

				default:
					task = "\n[TUYẾN CHÍNH] chờ các tuyến hoàn thành rồi in kết quả diện tích và chu vi\ncủa hình chữ nhật lên màn hình.";
					System.out.println(task);
					System.out.println("Diện tích: S = " + this.getS());
					System.out.println("Chu vi   : C = " + this.getC());
					break;
			}

			this.notifyAll();
		}
	}
}
