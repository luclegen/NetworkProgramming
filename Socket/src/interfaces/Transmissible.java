package interfaces;

import models.Message;

public interface Transmissible {
  public boolean send();

  public void receive(Message message);
}
