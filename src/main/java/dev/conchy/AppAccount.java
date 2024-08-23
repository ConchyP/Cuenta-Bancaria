package dev.conchy;


public final class AppAccount {
    private AppAccount() {
    }

  
    public static void main(String[] args) {
        Account account = new Account(5000, 0.03f);
        account.deposit(2000);
        account.withdrawal(1500);
        account.monthlyStatement();
        account.printAccountSummary();
       
    }
}
