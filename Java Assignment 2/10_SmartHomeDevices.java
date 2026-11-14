import java.util.*;

interface Device {
    void turnOn();
    void turnOff();
}

class Fan implements Device {
    public void turnOn() { System.out.println("Fan is now ON"); }
    public void turnOff() { System.out.println("Fan is now OFF"); }
}

class Light implements Device {
    public void turnOn() { System.out.println("Light is now ON"); }
    public void turnOff() { System.out.println("Light is now OFF"); }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String type = sc.nextLine();
            Device device = type.equalsIgnoreCase("Fan") ? new Fan() : new Light();
            device.turnOn();
            device.turnOff();
        }

        sc.close();
    }
}
