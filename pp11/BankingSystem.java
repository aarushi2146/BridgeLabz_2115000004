abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    public abstract double calculateInterest();
}
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
    public void applyForLoan(double amount) {
        System.out.println("Applying for loan of " + amount + " for savings account holder: " + getHolderName());
    }
    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    public double calculateInterest() {
        return getBalance() * 0.02;  
    }
    public void applyForLoan(double amount) {
        System.out.println("Applying for loan of " + amount + " for current account holder: " + getHolderName());
    }
    public double calculateLoanEligibility() {
        return getBalance() + overdraftLimit;
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[]{
            new SavingsAccount("S123", "Aarushi", 1000, 5),
            new CurrentAccount("C456", "Pratyaksh", 5000, 1000)
        };
        for (BankAccount account : accounts) {
            double interest = account.calculateInterest();
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Interest: " + interest);
            System.out.println("----------------------------");
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(2000);
                double eligibility = ((Loanable) account).calculateLoanEligibility();
                System.out.println("Loan Eligibility: " + eligibility);
            }
        }
    }
}





