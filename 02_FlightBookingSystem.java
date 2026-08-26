import java.util.*;

abstract class Flight {
    private String flightNumber, airline;
    private double fare;

    public Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    protected double getFare() { return fare; }
    public abstract double calculateFare();

    public String toString() {
        return "Flight No: " + flightNumber + " Airline: " + airline +
               " Fare: " + calculateFare();
    }
}

class DomesticFlight extends Flight {
    public DomesticFlight(String number, String airline, double fare) {
        super(number, airline, fare);
    }
    public double calculateFare() { return getFare() * 1.10; }
}

class InternationalFlight extends Flight {
    public InternationalFlight(String number, String airline, double fare) {
        super(number, airline, fare);
    }
    public double calculateFare() { return getFare() * 1.25; }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String[] d = sc.nextLine().split(",");
            Flight f = d[0].equalsIgnoreCase("Domestic")
                    ? new DomesticFlight(d[1], d[2], Double.parseDouble(d[3]))
                    : new InternationalFlight(d[1], d[2], Double.parseDouble(d[3]));
            System.out.println(f);
        }
        sc.close();
    }
}
