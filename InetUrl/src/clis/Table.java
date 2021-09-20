package clis;

import java.util.*;

import helpers.*;
import helpers.Error;

public class Table {
  private String table = "", title = "TITLE", header[];
  private int widthColumn[];
  private List<String[]> data = new ArrayList<>();

  public Table(String title, String... header) {
    this.title = title;
    this.header = header;

    this.widthColumn = new int[header.length];
    for (int i = 0; i < header.length; i++)
      this.widthColumn[i] = header[i].length();
  }

  public void add(String... data) {
    if (data.length == getColumnNum()) {
      this.data.add(data);
      for (int i = 0; i < data.length; i++)
        if (this.widthColumn[i] < data[i].length())
          this.widthColumn[i] = data[i].length();
    } else
      Error.invalid("column");
  }

  private void title() {
    int width = 3;
    for (int w : widthColumn)
      width += w + 3;
    table += space((width - title.length()) / 2) + title + "\n";
  }

  private void header() {
    border(2);
    table += "||";
    for (int i = 0; i < header.length; i++) {
      int num = (widthColumn[i] - header[i].length()) / 2;
      table += space(num);
      table += " " + header[i];
      table += space(widthColumn[i] - num - header[i].length());
      table += " |";
    }
    table += "|\n";
    border(2);
  }

  private void data() {
    for (String[] row : data) {
      table += "||";
      int i = 0;
      for (String column : row) {
        if (Checker.isInteger(column))
          table += space(widthColumn[i] - column.length() + 1) + column;
        else
          table += " " + column + space(widthColumn[i] - column.length());
        table += " |";
        i++;
      }
      table += "|\n";
      border(data.indexOf(row) < data.size() - 1 ? 1 : 2);
    }
  }

  private String space(int n) {
    String s = "";
    for (int i = 0; i < n; i++)
      s += " ";
    return s;
  }

  private void border(int num) {
    char symbol = ' ';
    switch (num) {
      case 1:
        symbol = '-';
        break;

      case 2:
        symbol = '=';
        break;

      default:
        break;
    }
    table += "++";
    for (int i = 0, k = 0; k < getColumnNum(); k++, i++) {
      for (int j = 0; j <= widthColumn[i]; j++)
        table += symbol;
      table += symbol + "+";
    }
    table += "+\n";
  }

  public int getColumnNum() {
    return widthColumn.length;
  }

  @Override
  public String toString() {
    title();
    header();
    data();

    return table;
  }
}