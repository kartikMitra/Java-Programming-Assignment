import java.util.LinkedHashSet;
import java.util.Scanner;

public class CourseEnrollment {

    private LinkedHashSet<String> students = new LinkedHashSet<>();

    public void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment enrollment = new CourseEnrollment();

        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enroll: ");
            String name = sc.nextLine();
            enrollment.enrollStudent(name);
        }

        enrollment.displayEnrolledStudents();
        sc.close();
    }
}
