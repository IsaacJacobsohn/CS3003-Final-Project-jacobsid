import Banking.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter a last name: ");
        String lastName = scanner.nextLine();

        Customer user = new Customer(firstName, lastName);
        String input = "c";

        int accountNum = 0;
        int balance = Integer.MIN_VALUE;
        BankAccount account;

        while (!input.equals("q")) {
            System.out.println("\n\nEnter what you would like to do: ");
            System.out.println("'c' to open a new checking account");
            System.out.println("'s' to open a new savings account");
            System.out.println("'a' to see and interact with your current accounts");
            System.out.println("'q' to quit");
            System.out.print("Enter your option: ");
            input = Character.toString(scanner.nextLine().charAt(0));
            
            if (input.equals("c")) {
                while (accountNum == 0) {
                    System.out.print("Enter an account number: ");
                    input = scanner.nextLine();
                    try {
                        accountNum = Integer.parseInt(input);
                        if (accountNum <= 0) {
                            throw new NumberFormatException("Number must be positive and non-zero");
                        }
                        if (user.getAccount(accountNum) != null) {
                            throw new NumberFormatException("Number must be original");
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Error: " + e);
                        accountNum = 0;
                    }
                }
                user.openCheckingAccount(accountNum);
                accountNum = 0;
            }
            else if (input.equals("s")) {
                while (accountNum == 0) {
                    System.out.print("Enter an account number: ");
                    input = scanner.nextLine();
                    try {
                        accountNum = Integer.parseInt(input);
                        if (accountNum <= 0) {
                            throw new NumberFormatException("Number must be positive and non-zero");
                        }
                        if (user.getAccount(accountNum) != null) {
                            throw new NumberFormatException("Number must be original");
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Error: " + e);
                        accountNum = 0;
                    }
                }
                user.openSavingsAccount(accountNum);
                accountNum = 0;
            }
            else if (input.equals("a")) {
                System.out.println();
                user.printAccounts();
                System.out.print("Enter the account number you would like to interact with (enter a non-number to quit): ");
                input = scanner.nextLine();
                try {
                    accountNum = Integer.parseInt(input);
                }
                catch (NumberFormatException e) {
                    
                }
                account = user.getAccount(accountNum);
                if (account == null) {
                    System.out.println("Error: Not a real account number");
                    input = "q";
                }
                while (!input.equals("q")) {
                    System.out.println("\nEnter what you would like to do: ");
                    System.out.println("'b' to check balance");
                    System.out.println("'w' to withdraw");
                    System.out.println("'d' deposit");
                    System.out.println("'q' to exit");
                    System.out.print("Enter your option: ");
                    input = Character.toString(scanner.nextLine().charAt(0));
                    if (input.equals("b")) {
                        System.out.println("Current Balance: " + account.getBalance());
                    }
                    else if (input.equals("w")) {
                        while (balance == Integer.MIN_VALUE) {
                            System.out.print("Enter the amount of money you would like to withdraw: ");
                            input = scanner.nextLine();
                            try {
                                balance = Integer.parseInt(input);
                                if (balance <= 0) {
                                    throw new NumberFormatException();
                                }
                                account.withdraw(balance);
                            }
                            catch (NumberFormatException e) {
                                System.out.println("Error: withdrawal must be a positive non-zero number");
                                accountNum = 0;
                            }
                            catch (IllegalStateException e) {
                                System.out.println("Error: " + e);
                            }
                        }
                        System.out.println("New balance: " + account.getBalance());
                        balance = Integer.MIN_VALUE;
                    }
                    else if (input.equals("d")) {
                        while (balance == Integer.MIN_VALUE) {
                            System.out.print("Enter the amount of money you would like to deposit: ");
                            input = scanner.nextLine();
                            try {
                                balance = Integer.parseInt(input);
                                if (balance <= 0) {
                                    throw new NumberFormatException();
                                }
                                account.deposit(balance);
                            }
                            catch (NumberFormatException e) {
                                System.out.println("Error: deposit must be a positive non-zero number");
                                accountNum = 0;
                            }
                            catch (IllegalArgumentException e) {
                                System.out.println("Error: deposit must be a positive non-zero number");
                                accountNum = 0;
                            }
                        }
                        System.out.println("New balance: " + account.getBalance());
                        balance = Integer.MIN_VALUE;
                    }
                    else if (input.equals("q")) {
                        break;
                    }
                }
                input = "g";
            }
        }
        System.out.println("\nThank you for using our bank");
        scanner.close();
    }
}
