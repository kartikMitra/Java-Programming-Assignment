import java.util.Scanner;

public class AverageAndGrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] marks = new int[5];
        int total = 0;

        // Read marks
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            total += marks[i];
        }

        // Calculate average
        double average = total / 5.0;

        // Calculate grade
        String grade;

        if (average >= 90) {
            grade = "A";
        } 
        else if (average >= 75) {
            grade = "B";
        } 
        else if (average >= 50) {
            grade = "C";
        } 
        else {
            grade = "Fail";
        }

        // Display result
        System.out.println("\n----- Student Result -----");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}