package examples;

public class GroupDemo implements Runnable {
  public static void main(String[] args) throws Exception {
    ThreadGroup parent = new ThreadGroup("parent");
    ThreadGroup subgroup = new ThreadGroup(parent, "subgroup");

    Thread t1 = new Thread(parent, new GroupDemo());
    t1.start();

    Thread t2 = new Thread(parent, new GroupDemo());
    t2.start();

    Thread t3 = new Thread(subgroup, new GroupDemo());
    t3.start();

    parent.list();

    System.out.println("Press enter to continue");
    System.in.read();
    System.exit(0);
  }

  @Override
  public void run() {
    while (true)
      Thread.yield();
  }
}
