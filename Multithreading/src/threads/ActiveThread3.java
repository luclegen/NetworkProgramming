package threads;

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
		synchronized (this) {
			String task = "";

			switch (this.id) {
				case 1:
					task = "\n[LUỒNG " + this.id + "]: cứ mỗi 2 giây sẽ tạo ra 1 số nguyên ngẫu nhiên trong khoảng từ 1 đến 20.";
					System.out.println(task);
					this.sleep(2000);
					System.out.println(r = (int) (1 + Math.round(Math.random() * 19)));
					break;

				case 2:
					task = "\n[LUỒNG " + this.id
							+ "]: cứ mỗi 1 giây sẽ lấy số ngẫu nhiên mà Luồng 1 tạo ra rồi tính\nbình phương của nó và hiển thị ra màn hình.";
					System.out.println(task);
					this.sleep(5000);
					System.out.println((int) Math.pow(r, 2));
					break;

				default:
					task = "\n[LUỒNG CHÍNH] tạo và khởi động 2 Luồng này.";
					System.out.println(task);

					for (int i = 1; i <= 2; i++)
						threads.add(new ActiveThread3(i));

					for (Thread thread : threads) {
						thread.start();
						System.out.print("\n[LUỒNG " + (threads.indexOf(thread) + 1) + "] đã khởi chạy...");

						synchronized (thread) {
							try {
								System.out.print("\n[LUỒNG " + (threads.indexOf(thread) + 1) + "] đang chờ...");
								thread.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

					for (Thread thread : threads) {
						thread.stop();
						System.out.print("\n[LUỒNG " + (threads.indexOf(thread) + 1) + "] đã dừng.");
					}
					break;
			}

			this.notifyAll();
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
