package Banking;
import java.time.LocalDate;

public class SavingsAccount extends BankAccount {
    private static double INTEREST_RATE = 0.02;
    private static int MONTHLY_WITHDRAWAL_LIMIT = 6;
    private static double WITHDRAWAL_FEE = 10.0;
    private int withdrawals;
    private int currentMonth;
    

    public SavingsAccount(int accountNum, String accountHolder, double balance) {
        super(accountNum, accountHolder, balance);
        this.withdrawals = 0;
        this.currentMonth = Integer.parseInt(LocalDate.now().toString().substring(5, 7));
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be postitive.");
        }
        this.currentMonth = Integer.parseInt(LocalDate.now().toString().substring(5, 7));
        this.balance += amount + amount * INTEREST_RATE;
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be postitive.");
        }
        double newBalance = this.balance - amount;
        checkMontlyWithdrawals();
        this.withdrawals++;
        if (this.withdrawals > MONTHLY_WITHDRAWAL_LIMIT) {
            newBalance -= WITHDRAWAL_FEE;
        }
        if (newBalance < 0) {
            throw new IllegalStateException("Withdrawal is too much.");
        }
        this.balance = newBalance;
    }

    private void checkMontlyWithdrawals() {
        if (this.currentMonth != Integer.parseInt(LocalDate.now().toString().substring(5, 7))) {
            this.withdrawals = 0;
            this.currentMonth = Integer.parseInt(LocalDate.now().toString().substring(5, 7));
        }
    }

}

