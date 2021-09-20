package apps;

import java.util.*;

import clis.Table;
import helpers.*;
import helpers.Error;
import models.Address;

public class Web {
  private static List<Address> addresses = new ArrayList<Address>();

  public static void run() {
    while (true) {
      System.out.println("Hãy chọn một trong các chức năng sau (1 -> 3 | 0: Để thoát):");
      System.out.println("1. Nhập địa chỉ URL.");
      System.out.println("2. Xem lịch sử duyệt web.");
      System.out.println("3. Xoá lịch sử duyệt web.\n");
      char choice = Input.getInput("Chức năng: ").charAt(0);
      System.out.println();
      switch (choice) {
        case '0':
          return;

        case '1':
          surf();
          break;

        case '2':
          history();
          break;

        case '3':
          clear();
          break;

        default:
          Error.invalid("answer");
          break;
      }
    }
  }

  private static void surf() {
    String url;
    do {
      url = Input.getInput("URL: ");
      if (Checker.isSuccessConnection(url)) {
        addresses.add(new Address(url));
        Notification.success("url");
      } else
        Notification.fail("url", url);
    } while (Checker.isContinue());
    System.out.println();
  }

  private static void history() {
    Table table = new Table("LỊCH SỬ DUYỆT WEB", "ID", "URL", "Hostname", "Địa chỉ IP", "Thời gian truy cập");
    int id = 0;
    for (Address a : addresses) {
      ++id;
      table.add(String.valueOf(id), a.getUrl().toString(), a.getHostName(), a.getHostAddress(), a.getTime());
    }
    System.out.println("\n" + table);
  }

  private static void clear() {
    addresses.clear();
    Notification.success("history");
  }
}
