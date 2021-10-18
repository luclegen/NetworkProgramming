package apps.ex3;

import java.io.*;
import java.net.Socket;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.event.*;

import clis.Layout;
import helpers.*;
import models.Message;
import views.Talk;

public class TCPTalkTelnetClient {
  private static Layout layout = new Layout(72, "CLIENT");
  private Message model;
  private Talk view;
  private static Socket socket = null;
  private static BufferedWriter out = null;
  private static BufferedReader in = null;

  public TCPTalkTelnetClient(Message model, Talk view) {
    this.model = model;
    this.view = view;
    try {
      out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    } catch (IOException e) {
      System.out.println("Không thể tạo đầu viết: " + e);
    }
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch (IOException e) {
      System.out.println("Không thể tạo đầu đọc: " + e);
    }
    initController();
  }

  private void initController() {
    view.addComponentListener(resize());
    view.getConversationScrollPane().getViewport().addChangeListener(fit());
    view.getMessageTextField().getDocument().addDocumentListener(check());
    view.getMessageTextField().addActionListener(e -> send());
    view.getSendButton().addActionListener(e -> send());
  }

  private ComponentListener resize() {
    return new ComponentListener() {

      @Override
      public void componentHidden(ComponentEvent e) {
      }

      @Override
      public void componentMoved(ComponentEvent e) {
      }

      @Override
      public void componentResized(ComponentEvent e) {
        view.getMainSplitPane().setDividerLocation(view.getHeight() - 90);
        view.getMessageTextField().setColumns((view.getWidth() - view.getSendButton().getWidth() - 30) / 30);
      }

      @Override
      public void componentShown(ComponentEvent e) {
      }
    };
  }

  private DocumentListener check() {
    return new DocumentListener() {
      public void check() {
        view.getSendButton().setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/"
            + (view.getMessageTextField().getText().length() > 0 ? "" : "inactive-") + "send.png"));
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        check();
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        check();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        check();
      }
    };
  }

  public void send() {
    String content = view.getMessageTextField().getText();
    if (content.length() > 0) {
      try {
        model.setContent(content);
        out.write(model.getName());
        out.newLine();
        out.write(model.getContent());
        out.newLine();
        out.flush();
        view.addSentMessage(model);
        view.getMessageTextField().setText("");
      } catch (IOException e) {
        System.err.println("Không thể gửi tin nhắn: " + e);
      }
    }
  }

  private ChangeListener fit() {
    return new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        view.getConversationPanel()
            .setSize(view.getWidth() - (view.getConversationScrollPane().getVerticalScrollBar().isVisible()
                ? view.getConversationScrollPane().getVerticalScrollBar().getWidth()
                : 0) - 5, view.getConversationPanel().getHeight());
      }
    };
  }

  public void receive(Message message) {
    if (message.getContent().length() > 0)
      view.addReceivedMessage(message);
  }

  public static void main(String[] args) {
    layout.header(1);
    try {
      socket = new Socket(Input.getHostAddress("Hãy nhập địa chỉ IP của server: ").toString(), 23);
      System.out.println("Đã kết nối tới: " + socket);
      TCPTalkTelnetClient client = new TCPTalkTelnetClient(new Message(Input.getInput("Hãy nhập tên bạn: ")),
          new Talk("Client", Talk.RIGHT));
      while (true) {
        client.receive(new Message(in.readLine(), in.readLine()));
      }
    } catch (IOException e) {
      System.err.println("Không thể kết nối tới server.");
    } finally {
      if (socket != null)
        try {
          layout.footer(1, "Client đã đóng kết nối.");
          socket.close();
        } catch (IOException e) {
          System.err.println("Không thể đóng: " + socket);
        }
    }
  }
}
