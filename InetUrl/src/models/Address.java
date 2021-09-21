package models;

import java.net.*;
import java.time.LocalDateTime;

import helpers.*;

public class Address {

  private URL url;
  private String hostName, time, hostAddress;

  public Address(String spec) {
    url = Creator.URL(spec);
    hostName = url.getHost();
    hostAddress = Creator.ip(hostName).getHostAddress();
    time = VNDateTime.getDateShortTime(LocalDateTime.now());
  }

  public URL getUrl() {
    return url;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public String getHostAddress() {
    return hostAddress;
  }

  public void setHostAddress(String hostAddress) {
    this.hostAddress = hostAddress;
  }

  public String getTime() {
    return time;
  }

  @Override
  public String toString() {
    return url.toString() + "\t" + time;
  }
}
