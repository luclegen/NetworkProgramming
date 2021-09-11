package examples;

import java.io.IOException;

public class StopMe extends Thread {
  @Override
  public void run() {
    int count = 1;
    System.out.println("I can count. Watch me go!");
    while (true) {
      System.out.print(count++ + " ");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }

  @SuppressWarnings("deprecation")
  public static void main(String[] args) throws IOException {
    Thread counter = new StopMe();
    counter.start();
    System.out.println("Press any enter to stop the thread outing");
    System.in.read();
    counter.stop();
  }
}
