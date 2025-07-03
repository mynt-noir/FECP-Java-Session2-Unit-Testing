package org.example;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private ArrayList<BankAccount> accounts;

    @BeforeEach
    public void setUp() {
        accounts = new ArrayList<>();
    }

    @AfterEach
    public void tearDown() {
        accounts.clear();
    }

    @Test
    public void testDepositValidAmount() {
        // should be equal to balance and return true
        BankAccount account = new BankAccount(1, "Alice");
        boolean depositSuccess = account.deposit(100);

        assertTrue(depositSuccess);
        assertEquals(100, account.getAccountBalance(), 0.001);
    }

    @Test
    public void testDepositInvalidAmount() {
        // should be equal to old balance and return false
        BankAccount account = new BankAccount(2, "Bob", 100);
        boolean depositSuccess = account.deposit(-1);

        assertFalse(depositSuccess);
        assertEquals(100, account.getAccountBalance(), 0.001);
    }
    
    @Test
    public void testWithdrawValidAmount() {
        // should be equal to balance-withdrawal amount and return true
        BankAccount account = new BankAccount(1, "Charlie", 500);
        boolean withdrawSuccess = account.withdraw(100);

        assertTrue(withdrawSuccess);
        assertEquals(400, account.getAccountBalance(), 0.001);
    }

    @Test
    public void testWithdrawInvalidAmount() {
        // should be equal to old balance amount and return false
        BankAccount account = new BankAccount(1, "Delta", 500);
        boolean withdrawSuccess = account.withdraw(-100);

        assertFalse(withdrawSuccess);
        assertEquals(500, account.getAccountBalance(), 0.001);
    }


    @Test
    public void testWithdrawExceededAmount() {
        // should be equal to old balance amount and return false
        BankAccount account = new BankAccount(1, "Echo", 500);
        boolean withdrawSuccess = account.withdraw(700);

        assertFalse(withdrawSuccess);
        assertEquals(500, account.getAccountBalance(), 0.001);

    }

    @Test
    public void testGetAccountNumber() {
        // should return account number
        BankAccount account = new BankAccount(10, "Foxtrot", 500);
        int actual = account.getAccountNumber();

        assertEquals(10, actual);
    }

    @Test
    public void testCreateAccountNoDeposits() {
        // should be no error and can get all account details
        BankAccount account = new BankAccount(101, "Golf");
        assertEquals(101, account.getAccountNumber());
        assertEquals("Golf", account.getAccountName());
        assertEquals(0, account.getAccountBalance(), 0.001);
    }
}