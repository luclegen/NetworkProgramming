package views;

public class ManageView extends javax.swing.JFrame {
  private javax.swing.JPanel candidatePanel;
  private javax.swing.JScrollPane candidatesScrollPanen;
  private javax.swing.JTable candidatesTable;
  private javax.swing.JPanel candidatesPanel;
  private javax.swing.JSplitPane candidatesSplitPane;
  private javax.swing.JLabel confirmLabel;
  private javax.swing.JPasswordField confirmPasswordField;
  private javax.swing.JButton createButton;
  private javax.swing.JButton createSubjectButton;
  private javax.swing.JLabel dateLabel;
  private javax.swing.JTextField dateTextField;
  private javax.swing.JTabbedPane examTabbedPane;
  private javax.swing.JPanel examsPanel;
  private javax.swing.JScrollPane examsScrollPane;
  private javax.swing.JSplitPane examsSplitPane;
  private javax.swing.JPanel examsSubPanel;
  private javax.swing.JTable examsTable;
  private javax.swing.JSplitPane jSplitPane2;
  private javax.swing.JTable jTable2;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField nameTextField;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JLabel startTimeLabel;
  private javax.swing.JTextField startTimeTextField;
  private javax.swing.JComboBox<String> subjectComboBox;
  private javax.swing.JLabel subjectLabel;
  private javax.swing.JPanel subjectPanel;
  private javax.swing.JPanel subjectsPanel;
  private javax.swing.JScrollPane subjectsScrollPanen;
  private javax.swing.JTable subjectsTable;
  private javax.swing.JLabel surnameLabel;
  private javax.swing.JTextField surnameTextField;
  private javax.swing.JLabel timeLabel;
  private javax.swing.JPasswordField timePasswordField;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JTextField titleTextField;
  private javax.swing.JLabel usernameLabel;
  private javax.swing.JTextField usernameTextField;

  public ManageView() {
    super("Quản lý hệ thống");

    initComponents();
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ManageView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ManageView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ManageView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ManageView.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }

    setVisible(true);
    setLocationRelativeTo(null);

    jTable2 = new javax.swing.JTable();
    examTabbedPane = new javax.swing.JTabbedPane();
    candidatesPanel = new javax.swing.JPanel();
    candidatesSplitPane = new javax.swing.JSplitPane();
    candidatesScrollPanen = new javax.swing.JScrollPane();
    candidatesTable = new javax.swing.JTable();
    candidatePanel = new javax.swing.JPanel();
    createButton = new javax.swing.JButton();
    nameLabel = new javax.swing.JLabel();
    surnameLabel = new javax.swing.JLabel();
    usernameLabel = new javax.swing.JLabel();
    usernameTextField = new javax.swing.JTextField();
    surnameTextField = new javax.swing.JTextField();
    nameTextField = new javax.swing.JTextField();
    confirmLabel = new javax.swing.JLabel();
    passwordLabel = new javax.swing.JLabel();
    confirmPasswordField = new javax.swing.JPasswordField();
    passwordField = new javax.swing.JPasswordField();
    subjectsPanel = new javax.swing.JPanel();
    jSplitPane2 = new javax.swing.JSplitPane();
    subjectsScrollPanen = new javax.swing.JScrollPane();
    subjectsTable = new javax.swing.JTable();
    subjectPanel = new javax.swing.JPanel();
    createSubjectButton = new javax.swing.JButton();
    dateLabel = new javax.swing.JLabel();
    titleLabel = new javax.swing.JLabel();
    startTimeLabel = new javax.swing.JLabel();
    startTimeTextField = new javax.swing.JTextField();
    titleTextField = new javax.swing.JTextField();
    dateTextField = new javax.swing.JTextField();
    timeLabel = new javax.swing.JLabel();
    timePasswordField = new javax.swing.JPasswordField();
    examsPanel = new javax.swing.JPanel();
    examsSplitPane = new javax.swing.JSplitPane();
    examsSubPanel = new javax.swing.JPanel();
    subjectLabel = new javax.swing.JLabel();
    subjectComboBox = new javax.swing.JComboBox<>();
    examsScrollPane = new javax.swing.JScrollPane();
    examsTable = new javax.swing.JTable();

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null },
            { null, null, null },
            { null, null, null },
            { null, null, null }
        },
        new String[] {
            "Mã  bài thi", "Nội dung bài thi", "Thời điểm nộp"
        }) {
      Class[] types = new Class[] {
          java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean[] {
          false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);

    candidatesSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

    candidatesTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null }
        },
        new String[] {
            "Mã", "Họ", "Tên", "Tên người dùng"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    candidatesScrollPanen.setViewportView(candidatesTable);

    candidatesSplitPane.setTopComponent(candidatesScrollPanen);

    createButton.setText("Tạo");

    nameLabel.setText("Tên                   :");

    surnameLabel.setText("Họ                     :");

    usernameLabel.setText("Tên người dùng:");

    confirmLabel.setText("Xác nhận          :");

    passwordLabel.setText("Mật khẩu          :");

    javax.swing.GroupLayout candidatePanelLayout = new javax.swing.GroupLayout(candidatePanel);
    candidatePanel.setLayout(candidatePanelLayout);
    candidatePanelLayout.setHorizontalGroup(
        candidatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                candidatePanelLayout
                    .createSequentialGroup()
                    .addContainerGap(251, Short.MAX_VALUE)
                    .addGroup(candidatePanelLayout
                        .createParallelGroup(
                            javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(candidatePanelLayout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                false)
                            .addGroup(candidatePanelLayout
                                .createSequentialGroup()
                                .addComponent(usernameLabel,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    116,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    150,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(candidatePanelLayout
                                .createSequentialGroup()
                                .addComponent(confirmLabel,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    116,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmPasswordField,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    150,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(candidatePanelLayout
                                .createSequentialGroup()
                                .addComponent(surnameLabel,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    116,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surnameTextField,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    150,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(candidatePanelLayout
                                .createSequentialGroup()
                                .addComponent(passwordLabel,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    116,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    150,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                candidatePanelLayout
                                    .createSequentialGroup()
                                    .addComponent(nameLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        116,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(nameTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(candidatePanelLayout
                            .createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(createButton)))
                    .addGap(232, 232, 232)));
    candidatePanelLayout.setVerticalGroup(
        candidatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(candidatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(candidatePanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameTextField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(candidatePanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(candidatePanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(candidatePanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(candidatePanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPasswordField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE)));

    candidatesSplitPane.setRightComponent(candidatePanel);

    javax.swing.GroupLayout candidatesPanelLayout = new javax.swing.GroupLayout(candidatesPanel);
    candidatesPanel.setLayout(candidatesPanelLayout);
    candidatesPanelLayout.setHorizontalGroup(
        candidatesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(candidatesSplitPane));
    candidatesPanelLayout.setVerticalGroup(
        candidatesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(candidatesSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE,
                526, Short.MAX_VALUE));

    examTabbedPane.addTab("Thí sinh", candidatesPanel);

    jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

    subjectsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null, null }
        },
        new String[] {
            "Mã", "Tiêu đề", "Ngày thi", "Thời điểm bắt đầu", "Thời điểm kết thúc",
            "Thời gian thi"
        }) {
      Class[] types = new Class[] {
          java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
          java.lang.String.class,
          java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean[] {
          false, false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    subjectsScrollPanen.setViewportView(subjectsTable);

    jSplitPane2.setTopComponent(subjectsScrollPanen);

    createSubjectButton.setText("Tạo");

    dateLabel.setText("Ngày thi               :");

    titleLabel.setText("Tiêu đề                :");

    startTimeLabel.setText("Thời điểm bắt đầu:");

    timeLabel.setText("Thời gian thi        :");

    javax.swing.GroupLayout subjectPanelLayout = new javax.swing.GroupLayout(subjectPanel);
    subjectPanel.setLayout(subjectPanelLayout);
    subjectPanelLayout.setHorizontalGroup(
        subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectPanelLayout
                .createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addGroup(subjectPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectPanelLayout
                        .createSequentialGroup()
                        .addGroup(subjectPanelLayout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                116,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                116,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                116,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startTimeLabel))
                        .addGap(27, 27, 27)
                        .addGroup(subjectPanelLayout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                false)
                            .addComponent(startTimeTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                150,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                150,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timePasswordField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                150,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTextField,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                150,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(subjectPanelLayout
                        .createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(createSubjectButton)))
                .addGap(219, 219, 219)));
    subjectPanelLayout.setVerticalGroup(
        subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGroup(subjectPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleTextField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subjectPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateTextField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(subjectPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeTextField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(subjectPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timePasswordField,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createSubjectButton)
                .addGap(0, 301, Short.MAX_VALUE)));

    jSplitPane2.setRightComponent(subjectPanel);

    javax.swing.GroupLayout subjectsPanelLayout = new javax.swing.GroupLayout(subjectsPanel);
    subjectsPanel.setLayout(subjectsPanelLayout);
    subjectsPanelLayout.setHorizontalGroup(
        subjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2));
    subjectsPanelLayout.setVerticalGroup(
        subjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526,
                Short.MAX_VALUE));

    examTabbedPane.addTab("Môn thi", subjectsPanel);

    examsSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

    subjectLabel.setText("Môn thi:");

    subjectComboBox.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout examsSubPanelLayout = new javax.swing.GroupLayout(examsSubPanel);
    examsSubPanel.setLayout(examsSubPanelLayout);
    examsSubPanelLayout.setHorizontalGroup(
        examsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(examsSubPanelLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(subjectLabel)
                .addGap(2, 2, 2)
                .addComponent(subjectComboBox,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE)));
    examsSubPanelLayout.setVerticalGroup(
        examsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(examsSubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(examsSubPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING,
                        false)
                    .addComponent(subjectComboBox)
                    .addComponent(subjectLabel,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE)));

    examsSplitPane.setTopComponent(examsSubPanel);

    examsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null },
            { null, null, null },
            { null, null, null },
            { null, null, null }
        },
        new String[] {
            "Mã", "Tên thí sinh", "Thời điểm nộp"
        }) {
      Class[] types = new Class[] {
          java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean[] {
          false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    examsScrollPane.setViewportView(examsTable);

    examsSplitPane.setRightComponent(examsScrollPane);

    javax.swing.GroupLayout examsPanelLayout = new javax.swing.GroupLayout(examsPanel);
    examsPanel.setLayout(examsPanelLayout);
    examsPanelLayout.setHorizontalGroup(
        examsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(examsSplitPane));
    examsPanelLayout.setVerticalGroup(
        examsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(examsSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 526,
                Short.MAX_VALUE));

    examTabbedPane.addTab("Bài thi", examsPanel);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(examTabbedPane,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    781,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(examTabbedPane));

    pack();
  }

  // public static void main(String args[]) {
  // java.awt.EventQueue.invokeLater(new Runnable() {
  // public void run() {
  // new ManageView().setVisible(true);
  // }
  // });
  // }

}
