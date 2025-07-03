package Bank;

import java.util.*;

public class Account {
    private String accountNumber;
    private String name;
    private String password;
    private double balance;
    private List<Transaction> history;

    public Account(String accountNumber, String name, String password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.balance = 0.0;
        this.history = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount));
        System.out.println("✅ ₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.add(new Transaction("Withdraw", amount));
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("❌ Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        if (history.isEmpty()) {
            System.out.println("⚠️ No transactions yet.");
        } else {
            for (Transaction t : history) {
                System.out.println(t);
            }
        }
    }

    public String getName() {
        return name;
    }
}

