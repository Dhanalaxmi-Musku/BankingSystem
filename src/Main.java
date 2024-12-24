public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer[] customers = new Customer[10];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(bank, (i % 5) + 1);
            customers[i].start();
        }

        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("Final balance for account " + i + ": " + bank.getBalance(i));
        }
    }
}