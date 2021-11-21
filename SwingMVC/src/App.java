import controllers.Controller;
import models.Model;
import views.View;

public class App {
  public static void main(String[] args) throws Exception {
    new Controller(new Model("Luc", "Huynh Tan"), new View("SwingMVC"));
  }
}
