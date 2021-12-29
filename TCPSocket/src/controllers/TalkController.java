package controllers;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.event.*;

import interfaces.Transmissible;
import models.Message;
import views.TalkView;

public class TalkController implements Transmissible {
  private Message model;
  private TalkView view;

  public TalkController(Message model, TalkView view) {
    this.model = model;
    this.view = view;

    initController();
  }

  public Message getModel() {
    return model;
  }

  public TalkView getView() {
    return view;
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

  @Override
  public boolean send() {
    String content = view.getMessageTextField().getText();
    boolean isSend = content.length() > 0;
    if (isSend) {
      model.setContent(content);
      view.addSentMessage(model);
      view.getMessageTextField().setText("");
    }
    return isSend;
  }

  @Override
  public void receive(Message message) {
    if (message.getContent().length() > 0)
      view.addReceivedMessage(message);
  }
}
