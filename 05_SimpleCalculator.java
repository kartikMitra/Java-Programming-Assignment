import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double secondNumber = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        if (operator == '+') {
            System.out.println("Result: " + (firstNumber + secondNumber));
        } else if (operator == '-') {
            System.out.println("Result: " + (firstNumber - secondNumber));
        } else if (operator == '*') {
            System.out.println("Result: " + (firstNumber * secondNumber));
        } else if (operator == '/') {
            if (secondNumber != 0) {
                System.out.println("Result: " + (firstNumber / secondNumber));
            } else {
                System.out.println("Cannot divide by zero.");
            }
        } else {
            System.out.println("Invalid operator.");
        }

        scanner.close();
    }
}
