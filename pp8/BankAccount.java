
public class BankAccount {    
    static String bankName = "HDFC Bank"; 
    static int totalAccounts = 0; 
    final int accountNumber;  
    String accountHolderName;
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;  
    }
    public static void getTotalAccounts() {
        System.out.println("Total accounts in " + bankName + ": " + totalAccounts);
    }
    public void displayAccountDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Name: " + bankName);
    }
    public static void main(String[] args) {        
        BankAccount account1 = new BankAccount("Aarushi", 12345);
        BankAccount account2 = new BankAccount("Pratyaksh", 67890);
        BankAccount.getTotalAccounts();      
        if (account1 instanceof BankAccount) {
            account1.displayAccountDetails();
        }
        if (account2 instanceof BankAccount) {
            account2.displayAccountDetails();
        }
    }
}

