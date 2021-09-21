package helpers;

import java.net.*;

public class Creator {
  public static URL URL(String spec) {
    try {
      return new URL(spec);
    } catch (MalformedURLException e) {
      if (Checker.isHostAddress(spec) || Checker.isHostname(spec))
        return hostToURL(spec);
      else {
        Error.invalid("spec");
        return null;
      }
    }
  }

  public static URL hostToURL(String host) {
    String type = Checker.isHostAddress(host) ? "ip" : Checker.isHostname(host) ? "hostname" : "host";

    try {
      String protocol = "http";
      URL url = null;

      if (Checker.isHostAddress(host)) {
        if (!Checker.isSuccessConnection(new URL(protocol, host, "/")))
          protocol += "s";

        if (!Checker.isSuccessConnection(new URL(protocol, host, "/"))) {
          try {
            host = InetAddress.getByName(host).getHostName();
          } catch (UnknownHostException e) {
            Error.invalid(type);
            return null;
          }
        }

        url = new URL(protocol, host, "/");
      }

      if (Checker.isHostname(host)) {
        if (!Checker.isSuccessConnection(new URL(protocol, host, "/")))
          protocol += "s";

        url = new URL(protocol, host, "/");
      }

      return url == null ? null : Checker.isSuccessConnection(url) ? url : null;
    } catch (MalformedURLException e) {
      Error.invalid(type);
      return null;
    }
  }

  public static InetAddress ip(String host) {
    try {
      return InetAddress.getByName(host);
    } catch (UnknownHostException e) {
      Error.invalid("ip");
      return null;
    }
  }
}
