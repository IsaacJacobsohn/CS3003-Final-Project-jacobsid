package Banking;
public abstract class BankAccount {
    protected int accountNum;
    protected String accountHolder;
    protected double balance;
    
    public BankAccount(int accountNum, String accountHolder, double balance) {
        this.accountNum = accountNum;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public BankAccount(BankAccount otherAccount) {
        this.accountNum = otherAccount.getAccountNum();
        this.accountHolder = otherAccount.getAccountHolder();
        this.balance = otherAccount.getBalance();
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);
}
