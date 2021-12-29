package components;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.Document;

public class PlaceholderTextField extends JTextField {
  private String placeholder;

  public PlaceholderTextField() {
  }

  public PlaceholderTextField(String placeholder) {
    this.placeholder = placeholder;
  }

  public PlaceholderTextField(String text, String placeholder) {
    super(text);
    this.placeholder = placeholder;
  }

  public PlaceholderTextField(int columns, String placeholder) {
    super(columns);
    this.placeholder = placeholder;
  }

  public PlaceholderTextField(String text, int columns, String placeholder) {
    super(text, columns);
    this.placeholder = placeholder;
  }

  public PlaceholderTextField(Document doc, String text, int columns, String placeholder) {
    super(doc, text, columns);
    this.placeholder = placeholder;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (placeholder == null || placeholder.length() == 0 || getText().length() > 0)
      return;

    final Graphics2D g2D = (Graphics2D) g;
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2D.setColor(getDisabledTextColor());
    g2D.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
  }
}