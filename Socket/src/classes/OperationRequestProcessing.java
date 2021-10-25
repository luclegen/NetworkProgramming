package classes;

import java.io.*;
import java.math.BigDecimal;
import java.net.Socket;

import apps.ex2.STCOperationEchoServer;

public class OperationRequestProcessing extends Thread {
  Socket socket = null;

  public OperationRequestProcessing(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      String raw = null;
      while (true) {
        raw = in.readLine();
        System.out.println("Server đã nhận chuỗi: \"" + raw + "\"");
        if (raw == null)
          break;
        String result = "Phép toán không hợp lệ!";
        if (STCOperationEchoServer.isOperation(raw)) {
          String[] e = raw.substring(0, raw.length() - 2).split(" ");
          switch (e[0]) {
          case "+":
            result = new BigDecimal(e[1]).add(new BigDecimal(e[2])).toString();
            break;

          case "-":
            result = new BigDecimal(e[1]).subtract(new BigDecimal(e[2])).toString();
            break;

          case "*":
            result = new BigDecimal(e[1]).multiply(new BigDecimal(e[2])).toString();
            break;

          case "/":
            result = new BigDecimal(e[2]).compareTo(BigDecimal.ZERO) == 0 ? "Không thể chia cho số không!"
                : new BigDecimal(e[1]).divide(new BigDecimal(e[2])).toString();
            break;

          default:
            break;
          }
        }
        out.write(result);
        out.newLine();
        out.flush();
      }
      socket.close();
    } catch (IOException e) {
      System.err.println("Lỗi xử lý yêu cầu: " + e);
    }
  }
}
