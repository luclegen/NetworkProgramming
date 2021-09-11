package examples;

public class Account {
  private double balance;

  public Account(double balance) {
    this.balance = balance;
  }

  public synchronized double getBalance() {
    return balance;
  }

  public synchronized void setBalance(double amount) {
    this.balance += amount;
  }

}
