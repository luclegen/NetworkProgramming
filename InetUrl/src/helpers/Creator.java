package helpers;

import java.net.*;

public class Creator {

  public static URL url(String uri) {
    try {
      return new URL(uri);
    } catch (MalformedURLException e) {
      Error.invalid("url");
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
