package dev.conchy;

public class SavingAccount extends Account {

    private boolean active;

    public SavingAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.active = balance >= 10000;
    }

    public boolean active() {
        return active;
    }

    @Override
    public void withdrawal(float amount) {
        if (active) {
            super.withdrawal(amount);
        } else {
            System.out.println("Account is inactive");
        }
        this.updateAccountStatus();
    }

    @Override
    public void deposit(float amount) {
        super.deposit(amount);
        this.updateAccountStatus();
    }

    @Override
    public void monthlyStatement() {
        if (numbOfWithdrawals > 4) {
            int excessWithdrawals = numbOfWithdrawals - 4;
            chargeMonthlyFee(excessWithdrawals * 1000);
        }
        super.monthlyStatement();
        this.updateAccountStatus();
    }

    @Override
    public void printAccountSummary() {
        super.printAccountSummary();
        System.out.println("Balance: $" + balance);
        System.out.println("Monthly commission: $" + monthlyCommission);
        System.out.println("Nº transactions: " + active);

    }

    private void updateAccountStatus() {
        this.active = balance >= 10000;
    }
}
