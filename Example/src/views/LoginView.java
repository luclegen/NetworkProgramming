package views;

import java.awt.BorderLayout;
import javax.swing.*;

public class LoginView extends JFrame {
  private JLabel usernameLabel;
  private JLabel passwordLabel;
  private JTextField usernameTextField;
  private JPasswordField passwordField;
  private JButton loginButton;

  public LoginView(String title) {
    super(title);
    this.getContentPane().setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setSize(300, 150);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    usernameLabel = new JLabel("Username: ");
    passwordLabel = new JLabel("Password: ");
    usernameTextField = new JTextField();
    passwordField = new JPasswordField();
    loginButton = new JButton("Login");
    GroupLayout layout = new GroupLayout(this.getContentPane());
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(usernameLabel)
            .addComponent(passwordLabel).addComponent(loginButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(usernameTextField)
            .addComponent(passwordField)));
    layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(usernameLabel)
            .addComponent(usernameTextField))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(passwordLabel)
            .addComponent(passwordField).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(loginButton)));
    this.getContentPane().setLayout(layout);
  }

  public JTextField getUsernameTextField() {
    return usernameTextField;
  }

  public void setUsernameTextField(JTextField usernameTextField) {
    this.usernameTextField = usernameTextField;
  }

  public JPasswordField getPasswordField() {
    return passwordField;
  }

  public void setPasswordField(JPasswordField passwordField) {
    this.passwordField = passwordField;
  }

  public JButton getLoginButton() {
    return loginButton;
  }

  public void setLoginButton(JButton loginButton) {
    this.loginButton = loginButton;
  }

  public void addWindowListener(Object object) {
  }

}
