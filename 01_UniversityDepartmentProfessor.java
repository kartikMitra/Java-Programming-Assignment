import java.util.*;

class Professor {
    private String name, employeeId, specialization;

    public Professor() {}
    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String toString() {
        return "Name: " + name + ", ID: " + employeeId + ", Specialization: " + specialization;
    }
}

class Department {
    private String deptName, hodName;
    private List<Professor> professors = new ArrayList<>();

    public Department() {}
    public Department(String deptName, String hodName) {
        this.deptName = deptName;
        this.hodName = hodName;
    }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getHodName() { return hodName; }
    public void setHodName(String hodName) { this.hodName = hodName; }
    public List<Professor> getProfessors() { return professors; }
    public void setProfessors(List<Professor> professors) { this.professors = professors; }
    public void addProfessor(Professor p) { professors.add(p); }

    public String toString() {
        StringBuilder s = new StringBuilder("Department: " + deptName + "\nHOD: " + hodName + "\nProfessors:");
        for (Professor p : professors) s.append("\n").append(p);
        return s.toString();
    }
}

public class UniversityDepartmentProfessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] d = sc.nextLine().split(",");
        Department dept = new Department(d[0], d[1]);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().split(",");
            dept.addProfessor(new Professor(p[0], p[1], p[2]));
        }

        System.out.println(dept);
        sc.close();
    }
}
