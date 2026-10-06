import java.util.Scanner;

public class BankTransaction extends Thread {
    private final int amount;
    private final String transactionType;

    BankTransaction(int amount, String transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public void run() {
        if (transactionType.equals("High-value")) {
            System.out.println("High-value transaction processed first: ₹" + amount);
        } else {
            System.out.println("Low-value transaction processed later: ₹" + amount);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Transaction interrupted");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Transaction1: ₹");
        int amount1 = sc.nextInt();

        System.out.print("Transaction2: ₹");
        int amount2 = sc.nextInt();

        BankTransaction highValue;
        BankTransaction lowValue;

        if (amount1 >= amount2) {
            highValue = new BankTransaction(amount1, "High-value");
            lowValue = new BankTransaction(amount2, "Low-value");
        } else {
            highValue = new BankTransaction(amount2, "High-value");
            lowValue = new BankTransaction(amount1, "Low-value");
        }

        highValue.setPriority(Thread.MAX_PRIORITY);
        lowValue.setPriority(Thread.MIN_PRIORITY);

        highValue.start();

        try {
            highValue.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        lowValue.start();

        try {
            lowValue.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        sc.close();
    }
}
