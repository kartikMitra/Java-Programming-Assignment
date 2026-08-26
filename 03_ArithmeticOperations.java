import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Addition: " + (firstNumber + secondNumber));
        System.out.println("Subtraction: " + (firstNumber - secondNumber));
        System.out.println("Multiplication: " + (firstNumber * secondNumber));

        if (secondNumber != 0) {
            System.out.println("Division: " + (firstNumber / secondNumber));
            System.out.println("Modulus: " + (firstNumber % secondNumber));
        } else {
            System.out.println("Division and modulus by zero are not allowed.");
        }

        scanner.close();
    }
}
