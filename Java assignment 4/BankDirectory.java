import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankDirectory {

    private HashMap<Integer, String> accounts = new HashMap<>();

    public void addAccount(int accountNo, String customerName) {
        accounts.put(accountNo, customerName);
        System.out.println("Account added successfully.");
        System.out.println("Account No: " + accountNo + " → " + customerName);
    }

    public void getCustomer(int accountNo) {
        if (accounts.containsKey(accountNo)) {
            System.out.println("Customer Name: " + accounts.get(accountNo));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("All Accounts:");
        for (Map.Entry<Integer, String> entry : accounts.entrySet()) {
            System.out.println("Account No: " + entry.getKey()
                    + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankDirectory directory = new BankDirectory();

        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accountNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    directory.addAccount(accountNo, customerName);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int searchAccount = sc.nextInt();
                    directory.getCustomer(searchAccount);
                    break;

                case 3:
                    directory.displayAll();
                    break;

                case 4:
                    System.out.println("Exiting Bank Directory.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
