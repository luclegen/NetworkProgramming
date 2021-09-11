package examples;

import java.io.IOException;

public class WaitNotify extends Thread {
  public static void main(String[] args) throws Exception {
    Thread notificationThread = new WaitNotify();
    notificationThread.start();

    synchronized (notificationThread) {
      notificationThread.wait();
    }

    System.out.println("The wait is over");
  }

  @Override
  public void run() {
    System.out.println("Hit enter to stop waiting thread");
    try {
      System.in.read();
    } catch (IOException e) {
    }
    synchronized (this) {
      this.notifyAll();
    }
  }
}
