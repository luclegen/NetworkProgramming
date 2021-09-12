package models;

import java.math.BigInteger;

import helpers.*;

public class ActiveThread1 extends Thread {
	private int id;
	private BigInteger n;

	public ActiveThread1(int id, BigInteger n) {
		this.id = id;
		this.n = n;

		String notification = "";

		switch (this.id) {
			case 1:
			case 2:
			case 3:
			case 4:
				notification = "[TUYẾN " + this.id + "] đã được tạo...";
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
					task = "\n[TUYẾN " + this.id + "] Thực hiện in các số lẻ nhỏ hơn số nguyên n = " + n;
					System.out.println(task);
					for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE))
						if (!Checker.isEven(i))
							Output.block(i, "10", "9");
					System.out.println();
					break;

				case 2:
					task = "\n[TUYẾN " + this.id + "] Thực hiện in các số chẵn nhỏ hơn số nguyên n = " + n;
					System.out.println(task);
					for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE))
						if (Checker.isEven(i))
							Output.block(i, "10", "8");
					break;

				case 3:
					task = "\n[TUYẾN " + this.id + "] Thực hiện in ra các số từ 1 đến n = " + n;
					System.out.println(task);
					for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
						Output.block(i, "10", "9");
					break;

				case 4:
					task = "\n[TUYẾN " + this.id + "] Thực hiện in các ký tự hoa trong bảng mã ASCII";
					System.out.println(task);
					for (int i = 65; i <= 90; i++)
						System.out.print((char) i + " ");
					System.out.println();
					break;

				default:
					System.err.println("ID = " + id + " không hợp lệ");
					break;
			}

			this.notifyAll();
		}
	}
}
