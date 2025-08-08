package Banking;

public class SavingsAccount extends BankAccount {
    private static double INTEREST_RATE = 0.02;
    private static double WITHDRAWAL_FEE = 10.0;
    

    public SavingsAccount(int accountNum, String accountHolder, double balance) {
        super(accountNum, accountHolder, balance);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be postitive.");
        }
        this.balance += amount + amount * INTEREST_RATE;
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be postitive.");
        }
        double newBalance = this.balance - amount - WITHDRAWAL_FEE;
        if (newBalance < 0) {
            throw new IllegalStateException("Withdrawal is too much.");
        }
        this.balance = newBalance;
    }
}

