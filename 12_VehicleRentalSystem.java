import java.util.*;

class Vehicle {
    protected String regNo, brand;
    protected double baseRate;

    public Vehicle(String regNo, String brand, double baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public double calculateRent() { return baseRate; }
}

class Car extends Vehicle {
    public Car(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }
    public double calculateRent() { return baseRate * 1.5; }
    public String toString() {
        return "Car " + regNo + " " + brand + " Rent: " + calculateRent();
    }
}

class Bike extends Vehicle {
    public Bike(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }
    public double calculateRent() { return baseRate * 1.2; }
    public String toString() {
        return "Bike " + regNo + " " + brand + " Rent: " + calculateRent();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String[] d = sc.nextLine().split(",");
            Vehicle v = d[0].equalsIgnoreCase("Car")
                    ? new Car(d[1], d[2], Double.parseDouble(d[3]))
                    : new Bike(d[1], d[2], Double.parseDouble(d[3]));
            System.out.println(v);
        }
        sc.close();
    }
}
