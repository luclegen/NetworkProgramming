package examples;

class A {
  synchronized void phuongthuc1(B b) {
    String tenTD = Thread.currentThread().getName();
    System.out.println(tenTD + " dang goi phuong thuc A.phuongthuc1()");
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.err.println("A bi ngat");
    }
    System.out.println(tenTD + "Dang thu goi B.phuongthuc4()");
    b.phuongthuc4();
  }

  synchronized void phuongthuc2() {
    System.out.println("Ben tron phuong thuc A.phuongthuc2()");
  }

}

class B {
  synchronized void phuongthuc3(A a) {
    String tenTD = Thread.currentThread().getName();
    System.out.println(tenTD + " dang goi phuong thuc B.phuongthuc3()");
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println("B bi ngat");
    }
    System.out.println(tenTD + " Dang thu goi A.phuongthuc2()");
    a.phuongthuc2();
  }

  synchronized void phuongthuc4() {
    System.out.println("Ben tron phuong thuc B.phuongthuc4()");
  }
}

class Deadlock implements Runnable {
  A a = new A();
  B b = new B();

  Deadlock() {
    Thread.currentThread().setName("MainThread");
    Thread t = new Thread(this, "RacingThread");
    t.start();
    a.phuongthuc1(b);
    System.out.println("Trong tuyen doan main");
  }

  @Override
  public void run() {
    b.phuongthuc3(a);
    System.out.println("Trong tuyen doan main");
  }

  public static void main(String[] args) {
    new Deadlock();
  }
}