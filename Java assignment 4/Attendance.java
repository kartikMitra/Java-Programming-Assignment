import java.util.HashSet;
import java.util.Scanner;

public class Attendance {

    private HashSet<String> students = new HashSet<>();

    public void markAttendance(String name) {
        if (students.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    public void displayAttendance() {
        System.out.println("Present Students:");
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();

        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name to mark attendance: ");
            String name = sc.nextLine();
            attendance.markAttendance(name);
        }

        attendance.displayAttendance();
        sc.close();
    }
}
