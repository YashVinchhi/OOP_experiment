import java.util.Scanner;

// BankAccount.java
class BankAccount {
    private String accountNumber;
    private String depositorName;
    private String accountType;
    private double balance;

    public BankAccount(String accountNumber, String depositorName, String accountType, double initialBalance) {
        this.accountNumber = accountNumber;
        this.depositorName = depositorName;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: %.2f, New balance: %.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f, Remaining balance: %.2f\n", amount, balance);
        }
    }

    public void display() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Depositor Name : " + depositorName);
        System.out.println("Account Type   : " + accountType);
        System.out.printf("Balance        : %.2f\n", balance);
    }

    public static void main(String[] args) {
        BankAccount acct = new BankAccount("A12345", "Charlie", "Savings", 1000.00);
        System.out.println("Initial details:");
        acct.display();
        acct.deposit(250.75);
        acct.withdraw(100.00);
        acct.withdraw(2000.00); // should show insufficient
    }
}
