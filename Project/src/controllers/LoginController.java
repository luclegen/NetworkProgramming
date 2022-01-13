package controllers;

import java.io.IOException;

import javax.swing.JOptionPane;

import daos.UserDAO;
import helpers.Checker;
import models.Type;
import models.User;
import views.LoginView;
import views.ManageView;

public class LoginController {
  private User model;
  private LoginView view;

  public LoginController(User model, LoginView view) {
    this.model = model;
    this.view = view;

    initController();
  }

  private void initController() {
    view.getUsernameTextField().addActionListener(e -> login());
    view.getPasswordField().addActionListener(e -> login());
    view.getLoginButton().addActionListener(e -> login());
  }

  private Object login() {
    String password = String.valueOf(view.getPasswordField().getPassword());
    if (view.getUsernameTextField().getText().length() > 0 && password.length() > 0)
      if (Checker.isUsername(view.getUsernameTextField().getText())) {
        if (password.length() >= 8) {
          try {
            User user = UserDAO.read(view.getUsernameTextField().getText());
            if (user != null)
              if (user.authenticate(password)) {
                model = user;
                if (user.getType().equals(Type.Admin)) {
                  view.setVisible(false);
                  new ManageView();
                } else {

                }
                view.dispose();
                System.out.println(model);
              } else
                JOptionPane.showMessageDialog(view, "Sai mật khẩu!", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            else
              JOptionPane.showMessageDialog(view, "Tên người dùng chưa đăng ký!", "Cảnh báo",
                  JOptionPane.WARNING_MESSAGE);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      } else
        JOptionPane.showMessageDialog(view, "Tên người dùng không hợp lệ!", "Lỗi",
            JOptionPane.ERROR_MESSAGE);

    return null;
  }

}
