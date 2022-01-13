package daos;

import java.io.*;
import java.util.*;

import helpers.PBKDF2;
import models.Type;
import models.User;

public abstract class UserDAO {
  private static String file = System.getProperty("user.dir") + "/src/db/User.csv";
  private static BufferedReader reader;
  private static FileWriter writer;

  public static User create(User user) throws IOException {
    writer = new FileWriter(file);
    List<User> users = list();

    // System.out.println(user);
    if (users.size() == 0) {
      users.add(user);
    } else if (users.size() > 0) {
      // System.out.println(user);

    }
    for (User u : users)
      writer.write(Integer.toString(u.id) + ',' + u.getName() + ',' +
          u.getSurname() + ',' + u.getUsername() + ','
          + PBKDF2.hash(u.getPassword()) + ',' + u.getType());

    writer.close();

    return user;
  }

  public static User read(String username) throws IOException {
    User user = null;
    for (User u : list())
      if (u.getUsername().equals(username))
        user = u;
    return user;
  }

  // public static void update(String username, boolean isLoggedIn) throws
  // IOException {
  // List<User> users = list();
  // writer = new FileWriter(file);
  // for (int i = 0; i < users.size(); i++) {
  // User u = users.get(i);
  // if (u.getUsername().equals(username))
  // u.setLoggedIn(isLoggedIn);
  // writer.write(Integer.toString(u.getId()) + ',' + u.getName() + ',' +
  // u.getSurname() + ',' + u.getUsername() + ','
  // + u.getPassword() + ',' + u.getType() + ',' + u.isLoggedIn());
  // }
  // writer.close();
  // }

  public static List<User> list() throws IOException {
    reader = new BufferedReader(new FileReader(file));
    List<User> users = new ArrayList<>();
    String row;

    while ((row = reader.readLine()) != null) {
      String[] data = row.split(",");

      if (data.length > 0)
        users.add(new User(Integer.parseInt(data[0]), data[1], data[2],
            data[3], data[4], data[5].equals("Admin") ? Type.Admin
                : Type.Candidate));
    }

    reader.close();

    return users;
  }
}
