package models;

import java.io.Serializable;

import helpers.PBKDF2;

public class User implements Serializable {
  public int id;
  private String name;
  private String surname;
  private String username;
  private String password;
  private Type type;

  public User() {
  }

  public User(String name, String surname, String username, String password, Type type) {
    this.name = name;
    this.surname = surname;
    this.username = username;
    this.password = password;
    this.type = type;
  }

  public User(int id, String name, String surname, String username, String password, Type type) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.username = username;
    this.password = password;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public boolean authenticate(String password) {
    return PBKDF2.compareSync(password, this.password);
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", password=" + password + ", surname=" + surname + ", type=" + type
        + ", username=" + username + "]";
  }

}
