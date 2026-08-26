import java.util.Scanner;

public class EligibilityCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Are you a citizen? (true/false): ");
        boolean citizen = scanner.nextBoolean();

        boolean eligible = (age >= 18 && citizen) || (age >= 18 && citizen == true);

        if (eligible) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }

        scanner.close();
    }
}
