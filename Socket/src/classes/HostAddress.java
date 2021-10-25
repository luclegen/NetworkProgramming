package classes;

import java.net.*;

import helpers.*;
import helpers.Error;

public class HostAddress {
  private byte[] ip = { 1, 1, 1, 1 };

  public HostAddress() {
  }

  public HostAddress(String spec) {
    if (Checker.isHostname(spec)) {
      try {
        spec = InetAddress.getByName(spec).getHostAddress();
      } catch (UnknownHostException e) {
        Error.invalid("hostname");
      }
    }

    if (Checker.isHostAddress(spec)) {
      for (int i = 0; i < 4; i++)
        ip[i] = (byte) Short.parseShort(spec.split("\\.")[i]);
      return;
    }

    try {
      try {
        spec = InetAddress.getByName(new URL(spec).getHost()).getHostAddress();
      } catch (UnknownHostException e) {
        Error.invalid("address");
      }
    } catch (MalformedURLException e) {
      Error.invalid("address");
    }

    if (Checker.isHostAddress(spec))
      for (int i = 0; i < 4; i++)
        ip[i] = (byte) Short.parseShort(spec.split("\\.")[i]);
  }

  public byte[] getIp() {
    return ip;
  }

  public boolean equals(HostAddress other) {
    for (int i = 0; i < 4; i++)
      if (ip[i] != other.getIp()[i])
        return false;
    return true;
  }

  @Override
  public String toString() {
    return String.join(".", (ip[0] >= 0 ? ip[0] : ip[0] + 256) + "", (ip[1] >= 0 ? ip[1] : ip[1] + 256) + "",
        (ip[2] >= 0 ? ip[2] : ip[2] + 256) + "", (ip[3] >= 0 ? ip[3] : ip[3] + 256) + "");
  }
}
