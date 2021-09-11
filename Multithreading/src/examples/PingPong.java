package examples;

public class PingPong extends Thread {
  String word;
  int delay;

  public PingPong(String word, int delay) {
    this.word = word;
    this.delay = delay;
  }

  @Override
  public void run() {
    try {
      while (true) {
        System.out.print(word + " ");
        sleep(delay);
      }
    } catch (InterruptedException e) {
      return;
    }
  }

  public static void main(String[] args) {
    new PingPong("ping", 33).start();
    new PingPong("PONG", 100).start();
  }
}
