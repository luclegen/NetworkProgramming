package examples;

public class Abs {
  public static void abs(int[] v) {
    synchronized (v) {
      for (int i = 0; i < v.length; i++)
        if (v[i] < 0)
          v[i] = -v[i];
    }
  }
}