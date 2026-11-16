import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Q9_IoTSensorMonitoring {
    private static final int STOP = -1;

    static class SquareCalculator implements Runnable {
        private final BlockingQueue<Integer> queue;

        SquareCalculator(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    int number = queue.take();
                    if (number == STOP) break;
                    System.out.println("Square: " + (number * number));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class CubeCalculator implements Runnable {
        private final BlockingQueue<Integer> queue;

        CubeCalculator(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    int number = queue.take();
                    if (number == STOP) break;
                    System.out.println("Cube: " + (number * number * number));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class RandomNumberGenerator extends Thread {
        private final BlockingQueue<Integer> evenQueue;
        private final BlockingQueue<Integer> oddQueue;

        RandomNumberGenerator(BlockingQueue<Integer> evenQueue,
                              BlockingQueue<Integer> oddQueue) {
            this.evenQueue = evenQueue;
            this.oddQueue = oddQueue;
        }

        public void run() {
            Random random = new Random();
            try {
                for (int i = 0; i < 3; i++) {
                    int number = random.nextInt(10) + 1;
                    System.out.println("Generated: " + number);
                    if (number % 2 == 0) evenQueue.put(number);
                    else oddQueue.put(number);
                    if (i < 2) Thread.sleep(1000);
                }
                evenQueue.put(STOP);
                oddQueue.put(STOP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            BlockingQueue<Integer> evenQueue = new LinkedBlockingQueue<>();
            BlockingQueue<Integer> oddQueue = new LinkedBlockingQueue<>();

            Thread square = new Thread(new SquareCalculator(evenQueue));
            Thread cube = new Thread(new CubeCalculator(oddQueue));
            Thread generator = new RandomNumberGenerator(evenQueue, oddQueue);

            square.start();
            cube.start();
            generator.start();

            generator.join();
            square.join();
            cube.join();
        } else {
            System.out.println("Simulation exited.");
        }
        sc.close();
    }
}
