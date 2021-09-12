package threads;

import java.util.Vector;

import helpers.*;

public class ActiveThread5 extends Thread {
	private int id = 0;
	private static Vector<Integer> p = new Vector<>();

	public ActiveThread5(int id) {
		this.id = id;

		String notification = "";

		switch (this.id) {
			case 1:
			case 2:
				notification = "\n[TUYẾN " + this.id + "] đã được tạo.";
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

	@Override
	public void run() {
		synchronized (this) {
			String task = "";

			switch (this.id) {
				case 1:
					task = "\n[TUYẾN " + this.id + "] Tìm số nguyên tố từ 1 đến 1000.\n";
					System.out.println(task);

					System.out.println("Các số nguyên tố cần tìm:");
					for (int i = 1; i <= 1000; i++)
						if (Checker.isPrime(i))
							p.add(i);

					for (int i = 0; i < p.size(); i++)
						Output.block(i, 10, 9);

					System.out.println();
					break;

				case 2:
					task = "\n[TUYẾN " + this.id + "] Tính tổng số giá trị tìm được.";
					System.out.println(task);
					System.out.println("S = " + p.stream().mapToInt(Integer::valueOf).sum());

					break;

				default:
					System.err.println("ID = " + id + " không hợp lệ");
					break;
			}

			this.notifyAll();
		}
	}
}
