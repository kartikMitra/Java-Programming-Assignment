public class Q10_BankTransactionPriorities {
    static class BankTransaction extends Thread {
        private final String transactionType;
        private final int amount;

        BankTransaction(String transactionType, int amount, int priority) {
            this.transactionType = transactionType;
            this.amount = amount;
            setPriority(priority);
        }

        public void run() {
            System.out.println(transactionType + " transaction processed: Rs. " + amount
                    + " (priority " + getPriority() + ")");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankTransaction lowValue =
                new BankTransaction("Low-value", 5000, Thread.MIN_PRIORITY);
        BankTransaction highValue =
                new BankTransaction("High-value", 50000, Thread.MAX_PRIORITY);

        highValue.start();
        highValue.join();
        lowValue.start();
        lowValue.join();

        System.out.println("Note: Thread priority is a scheduling hint; "
                + "it does not guarantee execution order in every program.");
    }
}
