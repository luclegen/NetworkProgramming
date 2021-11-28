package controllers;

import java.awt.event.*;

import javax.swing.*;

import models.User;
import views.LoginView;

public class LoginController {
  private User model;
  private LoginView view;

  public LoginController(User model, LoginView view) {
    this.model = model;
    this.view = view;

    initController();
  }

  private void initController() {
    view.addWindowListener(close());
    view.getLoginButton().addActionListener(e -> login());
  }

  private WindowAdapter close() {
    return new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(view, "Are you sure to close?", "Close Window?",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
          System.exit(0);
      }
    };
  }

  private void login() {
    model.setUsername(view.getUsernameTextField().getText());
    model.setPassword(String.valueOf(view.getPasswordField().getPassword()));
    JOptionPane.showMessageDialog(view, "Username: " + model.getUsername() + "\nPassword: " + model.getPassword(),
        "User information", JOptionPane.INFORMATION_MESSAGE);
  }

}
