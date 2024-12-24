class Customer extends Thread {
    private Bank bank;
    private int accountNumber;

    public Customer(Bank bank, int accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            if (Math.random() < 0.5) {
                bank.deposit(accountNumber, 100);
            } else {
                bank.withdraw(accountNumber, 50);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}