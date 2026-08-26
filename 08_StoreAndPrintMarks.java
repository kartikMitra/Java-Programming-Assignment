import java.util.Scanner;

public class StoreAndPrintMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[5];

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        System.out.println("\nStudent Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }

        scanner.close();
    }
}
