package models;

import java.io.*;
import java.net.Socket;

import helpers.Converter;

public class DigitRequestProcessing extends Thread {
  Socket socket = null;

  public DigitRequestProcessing(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

      int ch = 0;
      while (true) {
        ch = socket.getInputStream().read();
        if (ch == -1)
          break;

        out.write(Converter.digitToWord((char) ch));
        out.newLine();
        out.flush();
      }
      socket.close();
    } catch (IOException e) {
      System.err.println("Lỗi xử lý yêu cầu: " + e);
    }
  }
}
