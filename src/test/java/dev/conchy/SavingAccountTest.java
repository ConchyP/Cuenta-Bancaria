package dev.conchy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {

    private SavingAccount savingAccount;

    @BeforeEach
    void setUp() {
        savingAccount = new SavingAccount(12000, 0.50f); 
    }

    @Test
    void testAccountActiveOnInitialization() {
        assertTrue(savingAccount.active());
    }

    @Test
    void testDepositWhenActive() {
        savingAccount.deposit(2000);
        assertEquals(14000, savingAccount.getBalance());
        assertTrue(savingAccount.active());
    }

    @Test
    void testWithdrawalWhenActive() {
        savingAccount.withdrawal(3000);
        assertEquals(9000, savingAccount.getBalance());
        assertFalse(savingAccount.active());
        assertEquals(1, savingAccount.getWithdrawals());
    }
    

    @Test
    void testWithdrawalWhenInactive() {
        savingAccount = new SavingAccount(8000, 0.05f); 
        savingAccount.withdrawal(1000); 
        assertEquals(8000, savingAccount.getBalance()); 
        assertFalse(savingAccount.active());
        assertEquals(0, savingAccount.getWithdrawals());
    }

}
