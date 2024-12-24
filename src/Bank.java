import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        for (int i = 1; i <= 5; i++) {
            accounts.put(i, new Account(1000));
        }
    }

    public synchronized void deposit(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        account.balance += amount;
        System.out.println("Deposit: Account " + accountNumber + " new balance: " + account.balance);
    }

    public synchronized void withdraw(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        if (account.balance >= amount) {
            account.balance -= amount;
            System.out.println("Withdrawal: Account " + accountNumber + " new balance: " + account.balance);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    public synchronized int getBalance(int accountNumber) {
        return accounts.get(accountNumber).balance;
    }
}