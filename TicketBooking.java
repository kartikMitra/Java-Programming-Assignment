import java.util.Scanner;

class RailwayBooking {
    private int availableSeats;

    RailwayBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookSeat(String userName, int seats) {
        if (seats <= availableSeats) {
            System.out.println(userName + " booked " + seats + " seat(s) successfully");
            availableSeats -= seats;
        } else {
            System.out.println(userName + " booking failed. Not enough seats");
        }
    }
}

class User1 extends Thread {
    RailwayBooking booking;
    int seats;

    User1(RailwayBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat("User1", seats);
    }
}

class User2 extends Thread {
    RailwayBooking booking;
    int seats;

    User2(RailwayBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat("User2", seats);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int user1Seats = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int user2Seats = sc.nextInt();

        RailwayBooking booking = new RailwayBooking(availableSeats);

        User1 user1 = new User1(booking, user1Seats);
        User2 user2 = new User2(booking, user2Seats);

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        sc.close();
    }
}
