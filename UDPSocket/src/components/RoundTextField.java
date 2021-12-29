package components;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.text.Document;

public class RoundTextField extends PlaceholderTextField {
  private Shape shape;

  public RoundTextField() {
    setOpaque(false);
  }

  public RoundTextField(String placeholder) {
    super(placeholder);
    setOpaque(false);
  }

  public RoundTextField(String text, String placeholder) {
    super(text, placeholder);
    setOpaque(false);
  }

  public RoundTextField(int columns, String placeholder) {
    super(columns, placeholder);
    setOpaque(false);
  }

  public RoundTextField(String text, int columns, String placeholder) {
    super(text, columns, placeholder);
    setOpaque(false);
  }

  public RoundTextField(Document doc, String text, int columns, String placeholder) {
    super(doc, text, columns, placeholder);
    setOpaque(false);
  }

  protected void paintComponent(Graphics g) {
    g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    super.paintComponent(g);
  }

  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
    g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
  }

  public boolean contains(int x, int y) {
    if (shape == null || !shape.getBounds().equals(getBounds()))
      shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    return shape.contains(x, y);
  }
}