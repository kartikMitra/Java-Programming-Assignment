import java.util.*;

abstract class Loan {
    protected double principal, rate, time;

    public Loan(double principal, double rate, double time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double principal, double time) {
        super(principal, 8, time);
    }
    public double calculateInterest() { return principal * rate * time / 100; }
}

class CarLoan extends Loan {
    public CarLoan(double principal, double time) {
        super(principal, 10, time);
    }
    public double calculateInterest() { return principal * rate * time / 100; }
}

public class LoanManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String[] d = sc.nextLine().split(",");
            double principal = Double.parseDouble(d[1]);
            double time = Double.parseDouble(d[2]);

            Loan loan;
            if (d[0].equalsIgnoreCase("Home"))
                loan = new HomeLoan(principal, time);
            else
                loan = new CarLoan(principal, time);

            System.out.println(d[0] + " Loan Interest: " + loan.calculateInterest());
        }
        sc.close();
    }
}
