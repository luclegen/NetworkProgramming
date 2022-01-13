package views;

public class LoginView extends javax.swing.JFrame {
  private javax.swing.JButton loginButton;
  private javax.swing.JPanel loginPanel;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JLabel usernameLabel;
  private javax.swing.JTextField usernameTextField;

  public LoginView() {
    super("Đăng nhập");

    initComponents();
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    }

    loginPanel = new javax.swing.JPanel();
    usernameLabel = new javax.swing.JLabel();
    usernameTextField = new javax.swing.JTextField();
    passwordLabel = new javax.swing.JLabel();
    passwordField = new javax.swing.JPasswordField();
    loginButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);

    usernameLabel.setText("Tên người dùng:");

    usernameTextField.setMaximumSize(new java.awt.Dimension(112, 118));
    usernameTextField.setMinimumSize(new java.awt.Dimension(112, 118));
    usernameTextField.setName("");

    passwordLabel.setText("Mật khẩu          :");

    loginButton.setText("Đăng nhập");

    javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
    loginPanel.setLayout(loginPanelLayout);
    loginPanelLayout.setHorizontalGroup(
        loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loginPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(passwordLabel,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(usernameLabel,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(loginButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    loginPanelLayout.setVerticalGroup(
        loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                            35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                    loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));

    pack();
    setVisible(true);
  }

  public javax.swing.JButton getLoginButton() {
    return loginButton;
  }

  public void setLoginButton(javax.swing.JButton loginButton) {
    this.loginButton = loginButton;
  }

  public javax.swing.JPasswordField getPasswordField() {
    return passwordField;
  }

  public void setPasswordField(javax.swing.JPasswordField passwordField) {
    this.passwordField = passwordField;
  }

  public javax.swing.JTextField getUsernameTextField() {
    return usernameTextField;
  }

  public void setUsernameTextField(javax.swing.JTextField usernameTextField) {
    this.usernameTextField = usernameTextField;
  }

}
