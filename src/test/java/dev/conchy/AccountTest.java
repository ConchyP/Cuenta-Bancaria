package dev.conchy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void testDeposit() {
        Account account = new Account(1000, 0.05f);
        account.deposit(500.0f);
        assertEquals(1500.0f, account.balance, "Deposit should increase the balance");
        assertEquals(1, account.numbOfDeposits, "Number of deposits should be incremented.");
    }

    @Test
    void testWithdrawal() {
        Account account = new Account(1000.0f, 0.05f);
        account.withdrawal(200.0f);
        assertEquals(800.0f, account.balance, "Withdraw should decrease the balance.");
        assertEquals(1, account.numbOfWithdrawals, "Number of withdrawals should be incremented.");
    }

    @Test
    void testWithdrawExceedsBalance() {
        Account account = new Account(1000, 0.05f);
        account.withdrawal(1500);
        assertEquals(1000, account.balance);
        assertEquals(0, account.numbOfWithdrawals);
    }

    @Test
    void testCalculateInterest() {
        Account account = new Account(1200, 0.12f);
        account.calculateInterest();
        assertEquals(1212, account.balance, 0.01);
    }

    @Test
    void testMonthlyStatement() {
        Account account = new Account(1200, 0.12f);
        account.monthlyCommission = 50;
        account.monthlyStatement();
        assertEquals(1161.5, account.balance, 0.01);
    }

}
