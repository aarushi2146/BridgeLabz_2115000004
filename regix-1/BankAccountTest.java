import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccount {
    private double balance = 0.0;
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public double getBalance() {
        return balance;
    }
}
class BankAccountTest {
    BankAccount account = new BankAccount();
    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }
    @Test
    void testWithdraw() {
        account.deposit(200.0);
        assertTrue(account.withdraw(100.0));
        assertEquals(100.0, account.getBalance());
    }
    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(50.0);
        assertFalse(account.withdraw(100.0));
        assertEquals(50.0, account.getBalance());
    }
    @Test
    void testBalanceAfterMultipleTransactions() {
        account.deposit(500.0);
        account.withdraw(200.0);
        account.deposit(100.0);
        account.withdraw(150.0);
        assertEquals(250.0, account.getBalance());
    }
}




