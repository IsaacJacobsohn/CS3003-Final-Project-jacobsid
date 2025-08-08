package Banking;
public class CheckingAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = -500.0;
    private static final double OVERDRAFT_FEE = 7.5;

    public CheckingAccount(int accountNum, String accountHolder, double balance) {
        super(accountNum, accountHolder, balance);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be postitive.");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be postitive.");
        }
        double newBalance = this.balance - amount;
        if (newBalance < 0) {
            newBalance -= OVERDRAFT_FEE;
        }
        if (newBalance < OVERDRAFT_LIMIT) {
            throw new IllegalStateException("Overdraft limit exceeded.");
        }
        this.balance = newBalance;
    }

    
}
