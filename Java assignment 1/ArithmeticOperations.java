import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int number2 = scanner.nextInt();

        System.out.println("Addition: " + (number1 + number2));
        System.out.println("Subtraction: " + (number1 - number2));
        System.out.println("Multiplication: " + (number1 * number2));

        if (number2 != 0) {
            System.out.println("Division: " + (number1 / number2));
            System.out.println("Modulus: " + (number1 % number2));
        } else {
            System.out.println("Division: Cannot divide by zero.");
            System.out.println("Modulus: Cannot divide by zero.");
        }

        scanner.close();
    }
}