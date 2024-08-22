package dev.conchy;

public class CheckingAccount extends Account {

    public float overdraft = 0;

    public CheckingAccount(float balance, float annualRate, float overdraft) {
        super(balance, annualRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdrawal(float amount) {
        if (amount <= balance) {
            super.withdrawal(amount);
        } else {
            overdraft += amount - balance;
            balance = 0;
            numbOfWithdrawals += 1;
            System.out.println("Overdraft applied. New overdraft: $" + overdraft);
        }
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
            } else {
                overdraft -= amount;
                amount = 0;
            }
        }
        super.deposit(amount);
    }

    @Override
    public void printAccountSummary() {
        super.printAccountSummary();
        System.out.println("Overdraft: $" + overdraft);
    }
}

