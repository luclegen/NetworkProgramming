package threads;

import java.io.*;
import java.math.BigInteger;

import helpers.Checker;

public class ActiveThread4 extends Thread {
	private BigInteger id, n;
	private PrintWriter out;

	public ActiveThread4(BigInteger id, BigInteger n, PrintWriter out) {
		this.id = id;
		this.n = n;
		this.out = out;

		System.out.println("\n[TUYẾN " + this.id + "] đã được tạo.");
	}

	@Override
	public long getId() {
		return id.longValue();
	}

	@Override
	public void run() {
		synchronized (this) {
			String task = "\n[TUYẾN " + this.id + "] Kiểm tra số " + n + " có phải là số nguyên tố cần tìm.";
			System.out.println(task);

			if (Checker.isPrime(n)) {
				System.out.println(n + " là số nguyên tố cần tìm.");
				out.print(n + " ");
				out.flush();
			} else {
				System.out.println(n + " KHÔNG là số nguyên tố cần tìm.");
			}

			this.notifyAll();
		}
	}

}
