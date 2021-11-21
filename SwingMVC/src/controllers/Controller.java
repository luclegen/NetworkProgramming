package controllers;

import java.awt.event.*;
import javax.swing.*;

import models.Model;
import views.View;

public class Controller {
  private Model model;
  private View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;

    initView();
    initController();
  }

  private void initView() {
    view.getFirstNameTextField().setText(model.getFirstName());
    view.getLastNameTextField().setText(model.getLastName());
  }

  private void initController() {
    view.getFrame().addWindowListener(close());
    view.getFirstNameSaveButton().addActionListener(e -> saveFirstName());
    view.getLastNameSaveButton().addActionListener(e -> saveLastName());
    view.getHello().addActionListener(e -> sayHello());
    view.getBye().addActionListener(e -> sayBye());
  }

  private WindowAdapter close() {
    return new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(view.getFrame(), "Are you sure to close?", "Close Window?",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
          System.exit(0);
      }
    };
  }

  private void saveFirstName() {
    model.setFirstName(view.getFirstNameTextField().getText());
    JOptionPane.showMessageDialog(null, "FirstName saved : " + model.getFirstName(), "Info",
        JOptionPane.INFORMATION_MESSAGE);
  }

  private void saveLastName() {
    model.setLastName(view.getLastNameTextField().getText());
    JOptionPane.showMessageDialog(null, "LastName saved : " + model.getLastName(), "Info",
        JOptionPane.INFORMATION_MESSAGE);
  }

  private void sayHello() {
    JOptionPane.showMessageDialog(null, "Hello " + model.getFirstName() + " " + model.getLastName(), "Info",
        JOptionPane.INFORMATION_MESSAGE);
  }

  private void sayBye() {
    System.exit(0);
  }
}
