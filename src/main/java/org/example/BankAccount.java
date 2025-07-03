package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double accountBalance = 0;

    public BankAccount (int accountNumber, String accountName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public BankAccount (int accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void displayInfo() {
        System.out.println();
        System.out.printf("Account Number: %d\n", accountNumber);
        System.out.printf("Account Name: %s\n", accountName);
        System.out.printf("Account Balance: %.2f\n", accountBalance);
    }

    public boolean deposit(double depositAmount) {
        if (depositAmount < 0) {
            System.out.println("Invalid deposit. Please deposit a non-negative amount.");
            return false;
        }
        accountBalance += depositAmount;
        System.out.printf("Deposited %.2f successfully! Your new balance is %.2f.\n", depositAmount, accountBalance);
        return true;
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount < 0 || withdrawAmount > accountBalance) {
            System.out.println("Invalid withdrawal. Please deposit a non-negative amount less than or equal to your balance.");
            return false;
        }
        accountBalance -= withdrawAmount;
        System.out.printf("Withdrawn %.2f successfully! Your new balance is %.2f.\n", withdrawAmount, accountBalance);
        return true;
    }


}
