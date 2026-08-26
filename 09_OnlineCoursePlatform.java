import java.util.*;

class Course {
    String courseName, duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class Student {
    protected String name;
    protected Course enrolledCourse;

    public Student(String name, Course enrolledCourse) {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
    }

    public String toString() {
        return "Student: " + name + " Course: " + enrolledCourse.courseName +
               " (" + enrolledCourse.duration + ")";
    }
}

class PremiumStudent extends Student {
    private double discount;

    public PremiumStudent(String name, Course course, double discount) {
        super(name, course);
        this.discount = discount;
    }

    public String toString() {
        return "Premium Student: " + name + " Course: " + enrolledCourse.courseName +
               " (" + enrolledCourse.duration + ") Discount: " + discount + "%";
    }
}

public class OnlineCoursePlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] c = sc.nextLine().split(",");
        Course course = new Course(c[0], c[1]);

        String[] s1 = sc.nextLine().split(",");
        String[] s2 = sc.nextLine().split(",");

        Student student = new Student(s1[0], course);
        PremiumStudent premium = new PremiumStudent(s2[0], course, Double.parseDouble(s2[2]));

        System.out.println(student);
        System.out.println(premium);
        sc.close();
    }
}
