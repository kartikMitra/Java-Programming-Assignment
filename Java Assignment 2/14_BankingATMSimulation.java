import java.util.*;

class Account {
    private String accNo, holderName;
    private double balance;

    public Account(String accNo, String holderName, double balance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() { return balance; }
}

public class BankingATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("ACC101", "User", 0.0);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if (op.equalsIgnoreCase("deposit"))
                account.deposit(sc.nextDouble());
            else if (op.equalsIgnoreCase("withdraw"))
                account.withdraw(sc.nextDouble());
            else if (op.equalsIgnoreCase("getBalance"))
                System.out.println("Balance: " + account.getBalance());
        }
        sc.close();
    }
}
