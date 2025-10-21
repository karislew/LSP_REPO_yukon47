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

Prompt: Help me to design code to fit the question 4 criteria 

Response: 

package org.howard.edu.lsp.midterm.question4;

public interface Networked {
    void connect();
    void disconnect();
    boolean isConnected();
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

I reviewed the output code from chatgpt, modified where I saw fit,and tested to make sure everything compiled correctly.