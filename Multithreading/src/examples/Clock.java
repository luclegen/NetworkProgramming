package examples; // Remove this line when you compiler this file.

import java.awt.*;
import java.util.Date;
import java.applet.*;

@SuppressWarnings("deprecation")
public class Clock extends Applet implements Runnable {
  Font f = new Font("Times New Roman", Font.BOLD, 24);
  Date d = new Date();
  Thread t;

  @Override
  public void init() {
    resize(400, 400);
  }

  @Override
  public void start() {
    if (t == null) {
      t = new Thread(this);
      t.start();
    }
  }

  public void stop() {
    if (t != null) {
      t.stop();
      t = null;
    }
  }

  @Override
  public void run() {
    while (true) {
      d = new Date();
      repaint();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        return;
      }
    }
  }

  public void paint(Graphics g) {
    g.setFont(f);
    g.drawString(d.toString(), 10, 50);
  }

}