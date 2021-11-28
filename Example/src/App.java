import controllers.LoginController;
import models.User;
import views.LoginView;

public class App {
  public static void main(String[] args) throws Exception {
    // User user = new User("one", "123");
    // User user1 = new User("two", "456");
    // System.out.println(user.getId());
    // System.out.println(user.getUsername());
    // System.out.println(user.getPassword());
    // user1.setPassword("Test123!@#");
    // System.out.println(user1.getId());
    // System.out.println(user1.getUsername());
    // System.out.println(user1.getPassword());
    User user = new User();
    LoginView loginView = new LoginView("Login");
    new LoginController(user, loginView);
  }
}
