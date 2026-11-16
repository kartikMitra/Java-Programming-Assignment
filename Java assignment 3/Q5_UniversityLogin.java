import java.util.Scanner;

public class Q5_UniversityLogin {
    static void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        System.out.println("Welcome, " + username);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username (type null to test exception): ");
        String username = sc.nextLine();

        if (username.trim().equalsIgnoreCase("null")) {
            username = null;
        }

        try {
            login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        sc.close();
    }
}
