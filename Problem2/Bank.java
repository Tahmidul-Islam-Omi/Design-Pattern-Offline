// common interface for Account product

import java.util.Scanner;

interface Account{
    double calculateInterest(double principal , double time);
}

// 
class RegularAccount implements Account {
    private double interestRate = 2.5;

    @Override
    public double calculateInterest(double principal , double time) {
        return (principal * time * interestRate) / 100 ;
    }
}

class PremiumAccount implements Account {
    private double interestRate = 3.5;
    
    @Override
    public double calculateInterest(double principal , double time) {
        return (principal * time * interestRate) / 100;
    }
}

class VIPAccount implements Account {
    private double interestRate = 5;

    @Override
    public double calculateInterest(double principal , double time) {
        return (principal * time * interestRate) / 100;
    }
}
// Common interface for Loan product
interface Loan{
    public double calculateInterest(double principal , double time);
}

class RegularLoan implements Loan {
    private double interestRate = 14;

    @Override
    public double calculateInterest(double principal , double time) {
        return (principal * time * interestRate) / 100;
    }
}

class PremiumLoan implements Loan {
    private double interestRate = 12;

    @Override
    public double calculateInterest(double principal, double time) {
        return (principal*time*interestRate) / 100;
    }
}

class VIPLoan implements Loan {
    private double interestRate = 10;

    @Override
    public double calculateInterest(double principal, double time) {
        return (principal*time*interestRate) / 100;
    }
}

// Abstract Factory
interface BankFactory {
    Account createAccount();
    Loan createLoan();
}

class RegularCustomerFactory implements BankFactory {

    @Override
    public Account createAccount() {
        return new RegularAccount();
    }
    
    @Override
    public Loan createLoan() {
        return new RegularLoan();
    }
}

class PremiumCustomerFactory implements BankFactory {

    @Override
    public Account createAccount() {
        return new PremiumAccount();
    }
    
    @Override
    public Loan createLoan() {
        return new PremiumLoan();
    }
}

class VIPCustomerFactory implements BankFactory {

    @Override
    public Account createAccount() {
        return new VIPAccount();
    }
    
    @Override
    public Loan createLoan() {
        return new VIPLoan();
    }
}

class Application {
    public Account account;
    public Loan loan;

    public Application(BankFactory factory) {
        account = factory.createAccount();
        loan = factory.createLoan();
    }

    public void calculateInterest(double principal , double time) {
        account.calculateInterest(principal, time);
        loan.calculateInterest(principal, time);
    }
}

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Bank Application!");

        while (!exit) {
            System.out.println("Select Customer Type:");
            System.out.println("1. Regular Customer");
            System.out.println("2. Premium Customer");
            System.out.println("3. VIP Customer");
            System.out.println("4. Exit");

            int customerType = scanner.nextInt();

            if (customerType == 4) {
                exit = true;
                System.out.println("Thank you for using the Bank Application. Goodbye!");
                break;
            }

            BankFactory factory = null;

            switch (customerType) {
                case 1:
                    factory = new RegularCustomerFactory();
                    break;
                case 2:
                    factory = new PremiumCustomerFactory();
                    break;
                case 3:
                    factory = new VIPCustomerFactory();
                    break;
                default:
                    System.out.println("Invalid selection. Please restart.");
                    continue;
            }

            System.out.println("Enter principal amount: ");
            double principal = scanner.nextDouble();

            System.out.println("Enter time (in years): ");
            double time = scanner.nextDouble();

            // Create application using the selected factory
            Application application = new Application(factory);

            // Ask the customer whether they want to calculate for Account, Loan, or both
            System.out.println("What would you like to calculate?");
            System.out.println("1. Account Interest");
            System.out.println("2. Loan Interest");
            System.out.println("3. Both");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double accountInterest = application.account.calculateInterest(principal, time);
                    System.out.println("Interest on Account: " + accountInterest);
                    break;
                case 2:
                    double loanInterest = application.loan.calculateInterest(principal, time);
                    System.out.println("Interest on Loan: " + loanInterest);
                    break;
                case 3:
                    accountInterest = application.account.calculateInterest(principal, time);
                    loanInterest = application.loan.calculateInterest(principal, time);
                    System.out.println("Interest on Account: " + accountInterest);
                    System.out.println("Interest on Loan: " + loanInterest);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            System.out.println("Would you like to perform another operation? (yes/no)");
            String continueChoice = scanner.next().toLowerCase();

            if (continueChoice.equals("no")) {
                exit = true;
                System.out.println("Thank you for using the Bank Application. Goodbye!");
            }
        }

        scanner.close();
    }
}





