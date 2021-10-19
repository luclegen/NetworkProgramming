package apps.ex3;

import java.io.*;
import java.net.*;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.event.*;

import clis.Layout;
import helpers.Input;
import models.Message;
import views.Talk;

public class STCTalkTelnetServer {
  private static Layout layout = new Layout(72, "SERVER TUẦN TỰ");
  private Message model;
  private Talk view;
  private final static int SERVER_PORT = 23;
  private static Socket socket = null;
  private static BufferedWriter out = null;
  private static BufferedReader in = null;

  public STCTalkTelnetServer(Message model, Talk view) {
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
    ServerSocket serverSocket = null;
    layout.header(1);
    try {
      System.out.println("Đang liên kết tới cổng " + SERVER_PORT + " ...");
      serverSocket = new ServerSocket(SERVER_PORT);
      System.out.println("Server đã khởi động: " + serverSocket);
      System.out.println("Đang chờ client ...");

      while (true) {
        try {
          socket = serverSocket.accept();
          System.out.println("Client đã được chấp nhận: " + socket);
          STCTalkTelnetServer server = new STCTalkTelnetServer(new Message(Input.getInput("Hãy nhập tên bạn: ")),
              new Talk("Server", Talk.LEFT));

          while (true) {
            server.receive(new Message(in.readLine(), in.readLine()));
          }
        } catch (IOException e) {
          System.err.println(" Kết nối bị lỗi: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("Tạo server thất bại: " + e);
    } finally {
      if (serverSocket != null)
        try {
          serverSocket.close();
        } catch (IOException e) {
          System.err.println("Đóng server thất bại: " + e);
        }
    }
  }
}
