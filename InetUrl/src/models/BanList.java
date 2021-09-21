package models;

import java.util.*;

import clis.Table;

public class BanList {
  List<HostAddress> list = new ArrayList<HostAddress>();

  public BanList(String... list) {
    for (String item : list) {
      this.list.add(new HostAddress(item));
    }
  }

  public boolean isBan(HostAddress hostAddress) {
    for (HostAddress item : list)
      if (item.equals(hostAddress))
        return true;
    return false;
  }

  @Override
  public String toString() {
    Table table = new Table("DANH SÁCH CẤM", "STT", "Địa chỉ IP");
    byte index = 0;
    for (HostAddress item : list) {
      ++index;
      table.add(String.valueOf(index), item.toString());
    }
    return table.toString();
  }

}
