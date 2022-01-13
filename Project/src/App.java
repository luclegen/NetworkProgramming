import java.util.ArrayList;
import java.util.List;

import controllers.LoginController;
import daos.UserDAO;
import helpers.Input;
import models.Type;
import models.User;
import views.LoginView;

public class App {
	public static void main(String[] args) throws Exception {
		List<User> users = new ArrayList<>();

		User admin = new User(
				Input.getInput(
						"Tên           : "),
				Input.getInput(
						"Họ            : "),
				Input.getUsername(users,
						"Tên người dùng: "),
				Input.getPassword("Mật khẩu      : ", "Xác nhận      : "), Type.Admin);
		UserDAO.create(admin);

		new LoginController(new User(), new LoginView());
	}
}
