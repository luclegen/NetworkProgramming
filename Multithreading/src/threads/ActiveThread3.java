package threads;

import java.io.IOException;
import java.util.*;

public class ActiveThread3 extends Thread {
	private int id = 0;
	private static int r;
	private static List<Thread> threads = new ArrayList<>();

	public ActiveThread3() {
		System.out.println("[LUỒNG CHÍNH] đã được tạo...");
	}

	public ActiveThread3(int id) {
		this.id = id;

		String notification = "";

		switch (this.id) {
			case 1:
			case 2:
				notification = "\n[LUỒNG " + this.id + "] đã được tạo.";
				break;

			default:
				System.err.println("ID = " + id + " không hợp lệ");
				break;
		}

		System.out.println(notification);
	}

	@Override
	public long getId() {
		return id;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		String task = "";

		while (true) {
			switch (this.id) {
				case 1:
					task = "\n[LUỒNG " + this.id
							+ "]: cứ mỗi 2000 miligiây sẽ tạo ra 1 số nguyên ngẫu nhiên trong khoảng từ 1 đến 20.";
					this.sleep(2000);
					System.out.println(task + "\n" + (r = (int) (1 + Math.round(Math.random() * 19))));
					break;

				case 2:
					task = "\n[LUỒNG " + this.id
							+ "]: cứ mỗi 5000 miligiây sẽ lấy số ngẫu nhiên mà Luồng 1 tạo ra rồi tính\nbình phương của nó và hiển thị ra màn hình.";
					this.sleep(5000);
					System.out.println(task + "\n" + (int) Math.pow(r, 2));
					break;

				default:
					task = "\n[LUỒNG CHÍNH] tạo và khởi động 2 Luồng này.";
					System.out.println(task);

					for (int i = 1; i <= 2; i++)
						threads.add(new ActiveThread3(i));

					for (Thread thread : threads) {
						thread.start();
						System.out.print("\n[LUỒNG " + thread.getId() + "] đã khởi chạy...");

						if (thread.getId() == 2)
							try {
								System.out.println("\nNhấn ENTER để dừng.");
								System.in.read();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}

					for (Thread thread : threads) {
						thread.stop();
						System.out.print("\n[LUỒNG " + thread.getId() + "] đã dừng.");
					}

					threads.clear();
					return;
			}
		}
	}

	private void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
