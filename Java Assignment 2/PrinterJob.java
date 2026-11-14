import java.util.Scanner;

class PrintTask implements Runnable {
    private int jobNumber;
    private String studentName;

    PrintTask(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("Printing job " + jobNumber + " by " + studentName);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Printing interrupted");
        }
    }
}

public class PrinterJob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int jobs = sc.nextInt();

        Thread[] threads = new Thread[jobs];

        for (int i = 0; i < jobs; i++) {
            String studentName = "Student " + (char) ('A' + i);
            PrintTask task = new PrintTask(i + 1, studentName);

            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < jobs; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        sc.close();
    }
}
