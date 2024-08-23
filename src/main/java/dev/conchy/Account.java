package dev.conchy;

public class Account {

    protected float balance;
    protected int numbOfDeposits = 0;
    protected int numbOfWithdrawals = 0;
    protected float annualRate;
    protected float monthlyCommission = 0;

    public Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public void deposit(float amount) {
       balance += amount;
       numbOfDeposits += 1;
    }

    public void withdrawal(float amount) {
        float newBalance = balance - amount;

        if(newBalance > 0) {
            balance -= amount;
            numbOfWithdrawals +=1;
        } else {
            System.out.println("The amount to be withdrawn exceeds the current balance");
        }
    }

    public void calculateInterest() {

        float monthlyRate = annualRate / 12;
        float interest = balance * monthlyRate;
        balance += interest;
    }

    public void monthlyStatement() {
        balance -= monthlyCommission;
        calculateInterest();
    }

    public void printAccountSummary() {
        System.out.println("Balance: $" + balance);
        System.out.println("Monthly Commission: $" + monthlyCommission);
        System.out.println("Number of Deposits: " + numbOfDeposits);
        System.out.println("Number of Withdrawals: " + numbOfWithdrawals);
    }

    public float getBalance() {
        return balance;
    }

    public int getWithdrawals() {
        return numbOfWithdrawals;
    }

    public int getDeposits() {
        return numbOfDeposits;
    }

    public float getMonthlyFee() {
        return monthlyCommission;
    }

    public void chargeMonthlyFee(float fee) {
        monthlyCommission += fee;
    }
}

