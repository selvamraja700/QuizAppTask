package Bank;

import java.util.*;

public class BankSystem {
    private Map<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n====== Welcome to Simple Bank System ======");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> {
                    System.out.println("🚪 Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Set Password: ");
        String password = scanner.nextLine();
        String accNumber = "AC" + new Random().nextInt(100000);
        Account newAcc = new Account(accNumber, name, password);
        accounts.put(accNumber, newAcc);
        System.out.println("✅ Account created successfully. Your Account No: " + accNumber);
    }

    private void login() {
        System.out.print("Enter Account No: ");
        String accNum = scanner.nextLine();
        Account acc = accounts.get(accNum);

        if (acc == null) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();

        if (acc.authenticate(pass)) {
            System.out.println("✅ Welcome, " + acc.getName() + "!");
            accountMenu(acc);
        } else {
            System.out.println("❌ Incorrect password.");
        }
    }

    private void accountMenu(Account acc) {
        while (true) {
            System.out.println("\n=== Account Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Check");
            System.out.println("4. Transaction History");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ₹");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    acc.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ₹");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    acc.withdraw(amt);
                }
                case 3 -> System.out.println("💰 Current Balance: ₹" + acc.getBalance());
                case 4 -> acc.showTransactionHistory();
                case 5 -> {
                    System.out.println("🔒 Logged out.");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}

