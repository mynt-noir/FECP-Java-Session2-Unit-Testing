package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    private static void createAccount(ArrayList<BankAccount> accounts, int accountNumber, String accountName, String answer) {
        answer = answer.toLowerCase();

        if (!isValidAccountNumber(accounts, accountNumber)) {
            return;
        }

        if (!isValidAnswer(answer)) {
            return;
        }

        if (answer.equals("yes")) {
            System.out.print("Enter initial deposit amount: ");
            Scanner scanner = new Scanner(System.in);
            double depositAmount = scanner.nextDouble();
            if (depositAmount < 0) {
                System.out.println("Invalid deposit. Please deposit a non-negative amount.");
                return;
            }
            accounts.add(new BankAccount(accountNumber, accountName, depositAmount));
        } else {
            accounts.add(new BankAccount(accountNumber, accountName, 0));
        }
        System.out.println("Account Created Successfully!");
        };


    private static void viewAllAccounts(ArrayList<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        for (BankAccount account : accounts) {
            account.displayInfo();
        }
        System.out.println("--- End of Account List ---");

    }

    private static void checkBalance(ArrayList<BankAccount> accounts, int accountNumber) {
        BankAccount account = findAccount(accounts, accountNumber);
        if (account != null) {
            account.displayInfo();
        } else {
            System.out.println("Invalid account number. Please input a valid account number.");
        }
    }

    private static void deposit(ArrayList<BankAccount> accounts, int accountNumber, double depositAmount) {
        BankAccount account = findAccount(accounts, accountNumber);
        if (account != null) {
            account.deposit(depositAmount);
        } else {
            System.out.println("Invalid account number. Please input a valid account number.");
        }
    }

    private static void withdraw(ArrayList<BankAccount> accounts, int accountNumber, double withdrawAmount) {
        BankAccount account = findAccount(accounts, accountNumber);
        if (account != null) {
            account.withdraw(withdrawAmount);
        } else {
            System.out.println("Invalid account number. Please input a valid account number.");
        }
    }

    private static BankAccount findAccount(ArrayList<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (accountNumber == account.getAccountNumber()) {
                return account;
            }
        }
        return null;
    }

    public static boolean isValidAnswer(String answer) {
    if (answer.equals("yes") || answer.equals("no")) {
        return true;
    };
    System.out.println("Invalid answer. Please answer either yes/no.");
    return false;
    }


    public static boolean isValidAccountNumber(ArrayList<BankAccount> accounts, int accountNumber) {
        // check for invalid
        if (accountNumber < 1) {
            System.out.println("Invalid account number. Please input an account number greater than 0.");
            return false;
        };

        // check for duplicates
        for (BankAccount account : accounts) {
            if (accountNumber == account.getAccountNumber()) {
                System.out.println("Account number taken. Please input a unique account number.");
                return false;
            }
        };
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isFirst = true;
        ArrayList<BankAccount> accounts = new ArrayList<>();


        do {

            if (!isFirst) {
                System.out.print("Would you like to return to the menu? (yes/no): ");
                String returnAnswer = scanner.next().toLowerCase();

                if (!returnAnswer.equals("yes")) {
                    System.out.println("---Thank you!---");
                    return;
                }
            }
                System.out.println("=== Bank Menu ===");
                System.out.println("1. Create Account");
                System.out.println("2. View All Accounts");
                System.out.println("3. Check Balance");
                System.out.println("4. Deposit");
                System.out.println("5. Withdraw");
                System.out.println("6. Exit");

                System.out.print("Enter choice (1-5): ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        // create account

                        System.out.print("Enter Account Number: ");
                        int accountNumber = scanner.nextInt();
                        System.out.print("Enter Holder Name: ");
                        String accountName = scanner.next();
                        System.out.print("Initial Deposit (yes/no): ");
                        String answer = scanner.next();
                        createAccount(accounts, accountNumber, accountName, answer);

                    }
                    case 2 -> {
                        viewAllAccounts(accounts);
                    }
                    case 3 -> {
                        // check balance
                        System.out.print("Enter Account Number: ");
                        int accountNumber = scanner.nextInt();
                        checkBalance(accounts, accountNumber);

                    }
                    case 4 -> {
                        // deposit
                        System.out.print("Enter Account Number: ");
                        int accountNumber = scanner.nextInt();
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        deposit(accounts, accountNumber, depositAmount);
                    }
                    case 5 -> {
                        System.out.print("Enter Account Number: ");
                        int accountNumber = scanner.nextInt();
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(accounts, accountNumber, withdrawAmount);
                        // withdraw
                    }
                    default -> {
                        // exit
                        System.out.println("---Thank you!---");
                        return;
                    }
                }
                isFirst = false;
        } while (choice != 6);

    }

}