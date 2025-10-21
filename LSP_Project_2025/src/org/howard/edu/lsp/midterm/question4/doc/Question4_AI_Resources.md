For question 4 I utilized AI to help me structure and write the code 

here are some of my prompts:

Prompt: how do you extended classes in java
Response: Extending classes in Java is how you create a subclass (child class) that inherits properties and methods from a superclass (parent class). This is the basis of inheritance in object-oriented programming. Here’s a clear breakdown:

class Superclass {
    // Fields (variables)
    String name;

    // Constructor
    Superclass(String name) {
        this.name = name;
    }

    // Method
    void display() {
        System.out.println("Name: " + name);
    }
}

// Subclass that extends Superclass
class Subclass extends Superclass {
    int age;

    Subclass(String name, int age) {
        super(name); // Calls the constructor of the superclass
        this.age = age;
    }

    // Additional method
    void showAge() {
        System.out.println("Age: " + age);
    }

    // Overriding a method from the superclass
    @Override
    void display() {
        super.display(); // Optional: call superclass method
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Subclass obj = new Subclass("Karis", 25);
        obj.display();   // Calls overridden method
        obj.showAge();   // Calls subclass-specific method
    }
}

Prompt: Help me to design code to fit the question 4 criteria (Question 4. (30 pts.) Design and implement a small smart-campus device system showing both class inheritance (concrete classes extend a common abstract class) and interface implementation.) 

Response: 

package org.howard.edu.lsp.midterm.question4;

public interface Networked {
    void connect();
    void disconnect();
    boolean isConnected();
}

package org.howard.edu.lsp.midterm.question4;

public interface BatteryPowered {
    int getBatteryPercent();
    void setBatteryPercent(int percent);
}

package org.howard.edu.lsp.midterm.question4;

public class DoorLock extends Device implements Networked, BatteryPowered {

    private int batteryPercent;

    public DoorLock(String id, String location, int initialBattery) {
        super(id, location);
        setBatteryPercent(initialBattery);
    }

    // Networked
    @Override
    public void connect() { setConnected(true); }

    @Override
    public void disconnect() { setConnected(false); }

    @Override
    public boolean isConnected() { return super.isConnected(); }

    // BatteryPowered
    @Override
    public int getBatteryPercent() { return batteryPercent; }

    @Override
    public void setBatteryPercent(int percent) {
        if (percent < 0 || percent > 100)
            throw new IllegalArgumentException("battery 0..100");
        this.batteryPercent = percent;
    }

    // Status
    @Override
    public String getStatus() {
        String connStatus = isConnected() ? "up" : "down";
        return "DoorLock[id=" + getId() + ", loc=" + getLocation() +
               ", conn=" + connStatus + ", batt=" + batteryPercent + "%]";
    }
}

package org.howard.edu.lsp.midterm.question4;

public class Thermostat extends Device implements Networked {

    private double temperatureC;

    public Thermostat(String id, String location, double initialTempC) {
        super(id, location);
        this.temperatureC = initialTempC;
    }

    public double getTemperatureC() { return temperatureC; }
    public void setTemperatureC(double temperatureC) { this.temperatureC = temperatureC; }

    // Networked
    @Override
    public void connect() { setConnected(true); }

    @Override
    public void disconnect() { setConnected(false); }

    @Override
    public boolean isConnected() { return super.isConnected(); }

    // Status
    @Override
    public String getStatus() {
        String connStatus = isConnected() ? "up" : "down";
        return "Thermostat[id=" + getId() + ", loc=" + getLocation() +
               ", conn=" + connStatus + ", tempC=" + temperatureC + "]";
    }
}

package org.howard.edu.lsp.midterm.question4;

public class Camera extends Device implements Networked, BatteryPowered {

    private int batteryPercent;

    public Camera(String id, String location, int initialBattery) {
        super(id, location);
        setBatteryPercent(initialBattery);
    }

    // Networked
    @Override
    public void connect() { setConnected(true); }

    @Override
    public void disconnect() { setConnected(false); }

    @Override
    public boolean isConnected() { return super.isConnected(); }

    // BatteryPowered
    @Override
    public int getBatteryPercent() { return batteryPercent; }

    @Override
    public void setBatteryPercent(int percent) {
        if (percent < 0 || percent > 100)
            throw new IllegalArgumentException("battery 0..100");
        this.batteryPercent = percent;
    }

    // Status
    @Override
    public String getStatus() {
        String connStatus = isConnected() ? "up" : "down";
        return "Camera[id=" + getId() + ", loc=" + getLocation() +
               ", conn=" + connStatus + ", batt=" + batteryPercent + "%]";
    }
}

prompt: for question 4, door lock etc how does the implement and extend work in this case

response: 

In Question 4, the classes like DoorLock, Thermostat, and Camera demonstrate both inheritance and interface implementation in Java. Here's how it works in this case:
Extends (Inheritance from Device)
All three concrete classes DoorLock, Thermostat, and Camera extend the abstract class Device.
This means they inherit all the fields and methods from Device, such as id, location, heartbeat(), isConnected(), and setConnected().
They must implement the abstract method getStatus() because Device declares it as abstract.
This allows the concrete classes to share common functionality while providing their own specific behavior.
Implements (Interface Implementation)
DoorLock and Camera implement both Networked and BatteryPowered interfaces.
Thermostat implements only Networked.
Implementing an interface means the class must provide concrete implementations for all the methods declared in the interface.
For example, Networked requires connect(), disconnect(), and isConnected(). BatteryPowered requires getBatteryPercent() and setBatteryPercent().
This allows the classes to gain specific capabilities (like network connectivity or battery management) without needing multiple inheritance, which Java does not support for classes.

I reviewed the output code from chatgpt, modified where I saw fit,and tested to make sure everything compiled correctly.