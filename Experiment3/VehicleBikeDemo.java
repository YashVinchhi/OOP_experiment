// VehicleBikeDemo.java
class Vehicle {
    public void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {
    @Override
    public void run() {
        System.out.println("Bike is running safely with speed 60 km/h");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.run();

        Bike b = new Bike();
        b.run(); // method overriding demonstration
    }
}
