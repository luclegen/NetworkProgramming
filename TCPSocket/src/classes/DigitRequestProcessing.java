package classes;

import java.io.*;
import java.net.Socket;

import helpers.Converter;

public class DigitRequestProcessing extends Thread {
  private Socket socket = null;

  public DigitRequestProcessing(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      while (true) {
        String input = in.readLine();

        out.write(Converter.toSentence(Converter.integerToWords(input)));
        out.newLine();
        out.flush();
      }
    } catch (IOException e) {
      System.err.println("Lỗi xử lý yêu cầu: " + e);
    }
  }
}
