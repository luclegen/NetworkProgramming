package models;

import java.time.LocalDateTime;

public class Message {
  private String name = "Anonymous";
  private String content = null;
  private LocalDateTime timestamp = LocalDateTime.now();

  public Message(String name) {
    if (name != null && name.length() > 0)
      this.name = name;
  }

  public Message(String name, String content) {
    if (name != null && name.length() > 0)
      this.name = name;
    this.content = content;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
