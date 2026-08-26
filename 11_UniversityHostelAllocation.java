import java.util.*;

class Room {
    private String roomNumber, block, type;

    public Room(String roomNumber, String block, String type) {
        this.roomNumber = roomNumber;
        this.block = block;
        this.type = type;
    }

    public String toString() {
        return "Room: " + roomNumber + " " + block + " " + type;
    }
}

class Student {
    private String name, course;
    private int roll;
    private Room room;

    public Student(String name, int roll, String course, Room room) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.room = room;
    }

    public String toString() {
        return "Student: " + name + " (" + roll + ") " + course + "\n" + room;
    }
}

public class UniversityHostelAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        String[] r = sc.nextLine().split(",");

        Student student = new Student(s[0], Integer.parseInt(s[1]), s[2],
                new Room(r[0], r[1], r[2]));

        System.out.println(student);
        sc.close();
    }
}
