package examples;

public class RunPingPong implements Runnable {
  String word;
  int delay;

  public RunPingPong(String word, int delay) {
    this.word = word;
    this.delay = delay;
  }

  @Override
  public void run() {
    try {
      while (true) {
        System.out.println(word + " ");
        Thread.sleep(delay);
      }
    } catch (InterruptedException e) {
      return;
    }
  }

  public static void main(String[] args) {
    Runnable ping = new RunPingPong("ping", 33);
    Runnable pong = new RunPingPong("PONG", 100);
    new Thread(ping).start();
    new Thread(pong).start();
  }
}
