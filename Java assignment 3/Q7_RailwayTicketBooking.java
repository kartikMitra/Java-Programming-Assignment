import java.util.Scanner;

public class Q7_RailwayTicketBooking {
    static class TicketBooking {
        private int availableSeats;

        TicketBooking(int availableSeats) {
            this.availableSeats = availableSeats;
        }

        synchronized void bookSeat(String user, int seats) {
            if (seats > 0 && seats <= availableSeats) {
                availableSeats -= seats;
                System.out.println(user + " booked " + seats + " seat(s) successfully");
            } else {
                System.out.println(user + " booking failed. Not enough seats");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Available Seats: ");
        int available = sc.nextInt();
        System.out.print("User1 wants to book: ");
        int first = sc.nextInt();
        System.out.print("User2 wants to book: ");
        int second = sc.nextInt();

        TicketBooking booking = new TicketBooking(available);
        Thread user1 = new Thread(() -> booking.bookSeat("User1", first));
        Thread user2 = new Thread(() -> booking.bookSeat("User2", second));

        user1.start();
        user1.join();
        user2.start();
        user2.join();
        sc.close();
    }
}
