import java.util.*;

class Employee {
    protected String name, id;
    protected double basicSalary;

    public Employee() {}
    public Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() { return basicSalary; }

    public String toString() {
        return "Employee " + name + " (" + id + ") Salary: " + calculateSalary();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    public double calculateSalary() { return basicSalary + bonus; }

    public String toString() {
        return "Manager " + name + " (" + id + ") Salary: " + calculateSalary();
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String[] d = sc.nextLine().split(",");
            if (d[0].equalsIgnoreCase("Employee"))
                System.out.println(new Employee(d[1], d[2], Double.parseDouble(d[3])));
            else
                System.out.println(new Manager(d[1], d[2], Double.parseDouble(d[3]), Double.parseDouble(d[4])));
        }
        sc.close();
    }
}
