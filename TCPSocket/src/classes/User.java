package classes;

import helpers.*;
import interfaces.Authenticatable;

public class User implements Authenticatable {
  private String firstName;
  private String lastName;
  private String username;
  private String password;

  public User(String firstName, String lastName, String username, String password) {
    if (!Checker.isUsername(username)) {
      throw new IllegalArgumentException("Tên người dùng không hợp lệ.");
    } else if (password.length() < 8) {
      throw new IllegalArgumentException("Mật khẩu phải ít nhất 8 kí tự.");
    } else {
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = username;
      this.password = PBKDF2.hash(password);
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public boolean authenticate(String password) {
    return PBKDF2.compareSync(password, this.password);
  }
}
