package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        super.withdraw(amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest = getBalance() * rate * years / 100;
        return getBalance() + interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = getBalance() * Math.pow(1 + rate / times, times * years) - getBalance();
        return getBalance() + compoundInterest;
    }

}
