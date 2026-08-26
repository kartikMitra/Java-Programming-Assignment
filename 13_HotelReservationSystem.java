import java.util.*;

class Guest {
    private String name, idProof;
    private int age;

    public Guest(String name, int age, String idProof) {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
    }

    public String toString() {
        return name + "," + age + "," + idProof;
    }
}

class Reservation {
    private String reservationId, roomType;
    private List<Guest> guests = new ArrayList<>();

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
    }

    public void addGuest(Guest guest) { guests.add(guest); }

    public String toString() {
        StringBuilder s = new StringBuilder("Reservation ID: " + reservationId +
                " Room: " + roomType + "\nGuests:");
        for (Guest g : guests) s.append("\n").append(g);
        return s.toString();
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] r = sc.nextLine().split(",");
        Reservation reservation = new Reservation(r[0], r[1]);
        int n = Integer.parseInt(r[2]);

        for (int i = 0; i < n; i++) {
            String[] g = sc.nextLine().split(",");
            reservation.addGuest(new Guest(g[0], Integer.parseInt(g[1]), g[2]));
        }

        System.out.println(reservation);
        sc.close();
    }
}
