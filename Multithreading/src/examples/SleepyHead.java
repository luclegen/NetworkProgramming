package examples;

import java.io.IOException;

public class SleepyHead extends Thread {

  @Override
  public void run() {
    System.out.println("I feel sleepy. Wake me in eight hours");
    try {
      Thread.sleep(1000 * 60);
      System.out.println("That was a nice nap");
    } catch (InterruptedException e) {
      System.err.println("Just five more minutes...");
    }
  }

  public static void main(String[] args) throws IOException {
    Thread sleepy = new SleepyHead();
    sleepy.start();
    System.out.println("Press enter to interrupt the thread");
    System.in.read();
    sleepy.interrupt();
  }
}
