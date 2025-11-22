// MarutiHierarchyDemo.java
class Car {
    String fuel;

    public Car(String fuel) {
        this.fuel = fuel;
    }

    public void Speed() {
        System.out.println("Car speed: 100 km/h");
    }
}

class Maruti extends Car {
    String geartype;

    public Maruti(String fuel, String geartype) {
        super(fuel);
        this.geartype = geartype;
    }

    public void gear() {
        System.out.println("Gear type: " + geartype);
    }
}

class Maruti800 extends Maruti {
    String modelname;

    public Maruti800(String fuel, String geartype, String modelname) {
        super(fuel, geartype);
        this.modelname = modelname;
    }

    public void getModel() {
        System.out.println("Model name: " + modelname);
    }

    public static void main(String[] args) {
        Maruti800 m = new Maruti800("Petrol", "Manual", "Maruti800-STD");
        m.Speed();
        System.out.println("Fuel: " + m.fuel);
        m.gear();
        System.out.println("Gear type: " + m.geartype);
        m.getModel();
        System.out.println("Model: " + m.modelname);
    }
}
