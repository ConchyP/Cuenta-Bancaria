package dev.conchy;


public final class AppAccount {
    private AppAccount() {
    }

  
    public static void main(String[] args) {
        Account account = new Account(1000.0f, 0.05f);
        account.deposit(500.0f);
        account.withdrawal(200.0f);
        account.calculateInterest();

        System.out.println("Balance: " + account.balance);
        System.out.println("Number of Deposits: " + account.numbOfDeposits);
        System.out.println("Number of Withdrawals: " + account.numbOfWithdrawals);
        System.out.println("Annual Rate: " + account.annualRate);
        System.out.println("Monthly Commission: " + account.monthlyCommission);
       
    }
}
