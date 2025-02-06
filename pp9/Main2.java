
import java.util.ArrayList;
class Account {
    private String accountNumber;
    private double balance;
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
class Customer {
    private String name;
    private ArrayList<Account> accounts;
    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void openAccount(Account account) {
        accounts.add(account);
    }
    public void viewBalance() {
        if (accounts.isEmpty()) {
            System.out.println(name + " has no accounts.");
        } else {
            System.out.println(name + "'s Accounts:");
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }
}
class Bank {
    private String bankName;
    private ArrayList<Customer> customers;
    public Bank(String bankName) {
        this.bankName = bankName;
        customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void openAccount(Customer customer, Account account) {
        customer.openAccount(account);
        System.out.println("Account opened for " + customer.getName() + " with Account Number: " + account.getAccountNumber());
    }
    public void viewCustomerAccounts(Customer customer) {
        customer.viewBalance();
    }
}
public class Main2 {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");
        Customer customer1 = new Customer("Aarushi");
        Customer customer2 = new Customer("Aditya");
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        Account account1 = new Account("123456");
        Account account2 = new Account("789012");
        bank.openAccount(customer1, account1);
        bank.openAccount(customer2, account2);
        account1.deposit(1000);
        account2.deposit(2000);
        bank.viewCustomerAccounts(customer1);
        bank.viewCustomerAccounts(customer2);
        account1.withdraw(500);
        account2.withdraw(2500);
        bank.viewCustomerAccounts(customer1);
        bank.viewCustomerAccounts(customer2);
    }
}

