package views;

import java.awt.*;
import javax.swing.*;

import components.*;
import helpers.Converter;
import models.Message;

public class Talk extends JFrame {
  private JSplitPane mainSplitPane;
  private JPanel conversationPanel = new JPanel(new GridLayout(0, 1));
  private JScrollPane conversationScrollPane = new JScrollPane(conversationPanel);
  private JPanel formPanel = new JPanel();
  private RoundTextField messageTextField = new RoundTextField(14, "Message");
  private Font messageFont = new Font("Helvetica", Font.PLAIN, 20);
  private JButton sendButton = new JButton(
      new ImageIcon(System.getProperty("user.dir") + "/src/images/inactive-send.png"));
  public static final int LEFT = -1;
  public static final int CENTER = 0;
  public static final int RIGHT = 1;

  public Talk(String type, int position) throws HeadlessException {
    super(type + " - Talk");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setMinimumSize(new Dimension(500, 500));
    setLocation(((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 500) / 2 + 250 * position,
        (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 500) / 2);
    setLayout(new BorderLayout());
    getContentPane().setLayout(new BorderLayout());
    messageTextField.setFont(new Font("Helvetica", Font.PLAIN, 31));
    messageTextField.setBorder(
        BorderFactory.createCompoundBorder(messageTextField.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 5)));
    sendButton.setPreferredSize(new Dimension(40, 40));
    sendButton.setOpaque(false);
    sendButton.setContentAreaFilled(false);
    sendButton.setBorderPainted(false);
    formPanel.add(messageTextField);
    formPanel.add(sendButton);
    mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, conversationScrollPane, formPanel);
    mainSplitPane.setOneTouchExpandable(true);
    mainSplitPane.setDividerLocation(getHeight() - 90);
    mainSplitPane.setDividerSize(0);
    add(mainSplitPane);
    setVisible(true);
  }

  public void addReceivedMessage(Message message) {
    JPanel messagePanel = new JPanel();
    messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    messagePanel.setLayout(new BorderLayout());
    messagePanel.add(new JLabel(message.getName() + ":"), BorderLayout.LINE_START);
    JTextArea content = new JTextArea(" " + message.getContent());
    content.setEditable(false);
    content.setFont(messageFont);
    messagePanel.add(content);
    conversationPanel.add(messagePanel);
    repaint();
    revalidate();
  }

  public void addSentMessage(Message message) {
    JPanel messagePanel = new JPanel();
    messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    messagePanel.setLayout(new BorderLayout());
    JTextArea content = new JTextArea();
    content.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    content.setText(Converter.toReserveMessage(message.getContent()));
    content.setLineWrap(true);
    content.setWrapStyleWord(true);
    content.setEditable(false);
    content.setFont(messageFont);
    messagePanel.add(content);
    conversationPanel.add(messagePanel);
    SwingUtilities.updateComponentTreeUI(this);
  }

  public JSplitPane getMainSplitPane() {
    return mainSplitPane;
  }

  public JScrollPane getConversationScrollPane() {
    return conversationScrollPane;
  }

  public JPanel getConversationPanel() {
    return conversationPanel;
  }

  public RoundTextField getMessageTextField() {
    return messageTextField;
  }

  public JButton getSendButton() {
    return sendButton;
  }
}
