
class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void displayAccountType() {
        System.out.println("This is a generic bank account.");
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public void displayAccountType() {
        System.out.println("This is a Savings Account with an interest rate of " + interestRate + "%.");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountType() {
        System.out.println("This is a Checking Account with a withdrawal limit of " + withdrawalLimit + ".");
    }
}
class FixedDepositAccount extends BankAccount {
    private int depositTerm;
    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }
    public int getDepositTerm() {
        return depositTerm;
    }
    public void setDepositTerm(int depositTerm) {
        this.depositTerm = depositTerm;
    }
    public void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account with a deposit term of " + depositTerm + " months.");
    }
}
public class BankAccountMain {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA12345", 5000, 4.5);
        CheckingAccount checkingAccount = new CheckingAccount("CA12345", 3000, 1500);
        FixedDepositAccount fdAccount = new FixedDepositAccount("FDA12345", 
10000, 24);
        savingsAccount.displayAccountType();
        checkingAccount.displayAccountType();
        fdAccount.displayAccountType();
    }
}

