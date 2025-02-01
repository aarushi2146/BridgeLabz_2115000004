
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return this.balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void printAccountDetails() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Balance: " + getBalance());
    }
}
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "Aarushi", 1000.0);
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(500.0);
        System.out.println("Balance after deposit: " + account.getBalance());
        account.withdraw(300.0);
        System.out.println("Balance after withdrawal: " + account.getBalance());
        
        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Pratyaksh", 2000.0);
        savingsAccount.printAccountDetails();
    }
}

