package dev.conchy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    private CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount(10000, 0.05f, 0);
    }

    @Test
    void testDepositWithoutOverdraft() {
        checkingAccount.deposit(5000);
        assertEquals(15000, checkingAccount.getBalance());
        assertEquals(0, checkingAccount.overdraft);
    }

    @Test
    void testDepositWithOverdraft() {
        checkingAccount.withdrawal(12000); 
        checkingAccount.deposit(3000);      

        assertEquals(1000, checkingAccount.getBalance());
        assertEquals(0, checkingAccount.overdraft);
    }

    @Test
    void testWithdrawalWithoutOverdraft() {
        checkingAccount.withdrawal(4000);
        assertEquals(6000, checkingAccount.getBalance());
        assertEquals(0, checkingAccount.overdraft);
        assertEquals(1, checkingAccount.getWithdrawals());
    }

    @Test
    void testWithdrawalWithOverdraft() {
        checkingAccount.withdrawal(12000);  

        assertEquals(0, checkingAccount.getBalance());
        assertEquals(2000, checkingAccount.overdraft);
        assertEquals(1, checkingAccount.getWithdrawals());
    }

    @Test
    void testMonthlyStatement() {
        checkingAccount.withdrawal(12000);  
        checkingAccount.deposit(3000);     
        checkingAccount.monthlyStatement(); 

        float expectedBalance = 1000 + (1000 * (0.05f / 12));  
        assertEquals(expectedBalance, checkingAccount.getBalance(), 0.01);
    }

   
}

