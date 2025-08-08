import java.util.ArrayList;

import Banking.*;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<BankAccount> getAccounts() {
        return this.accounts;
    }

    public void printAccounts() {
        for (BankAccount account : this.accounts) {
            System.out.println("Account Number: " + account.getAccountNum());
            System.out.println("Account Balance: " + account.getBalance());
            System.out.println();
        }
    }

    public BankAccount getAccount(int accountNum) {
        for (BankAccount account: this.accounts) {
            if (account.getAccountNum() == accountNum) {
                return account;
            }
        }
        return null;
    }

    public void openCheckingAccount(int accountNum) {
        CheckingAccount newCheckingAccount = new CheckingAccount(accountNum, this.firstName + this.lastName, 0);
        this.accounts.add(newCheckingAccount);
    }

    public void openSavingsAccount(int accountNum) {
        SavingsAccount newSavingsAccount = new SavingsAccount(accountNum, this.firstName + this.lastName, 0);
        this.accounts.add(newSavingsAccount);
    }
}
