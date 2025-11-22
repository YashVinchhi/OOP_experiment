// VehicleExample.java
class Vehicle {
    String fuelType;
    double maxSpeed;

    public Vehicle(String fuelType, double maxSpeed) {
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }

    public void display() {
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class two_wheeler extends Vehicle {
    public two_wheeler(String fuelType, double maxSpeed) {
        super(fuelType, maxSpeed);
    }

    public void show() {
        System.out.println("Two wheeler");
        display();
    }
}

class three_wheeler extends Vehicle {
    public three_wheeler(String fuelType, double maxSpeed) {
        super(fuelType, maxSpeed);
    }

    public void show() {
        System.out.println("Three wheeler");
        display();
    }
}

class four_wheeler extends Vehicle {
    public four_wheeler(String fuelType, double maxSpeed) {
        super(fuelType, maxSpeed);
    }

    public void show() {
        System.out.println("Four wheeler");
        display();
    }
}

public class VehicleExample {
    public static void main(String[] args) {
        two_wheeler t = new two_wheeler("Petrol", 120);
        three_wheeler th = new three_wheeler("Diesel", 80);
        four_wheeler f = new four_wheeler("Electric", 160);

        t.show();
        System.out.println();
        th.show();
        System.out.println();
        f.show();
    }
}
