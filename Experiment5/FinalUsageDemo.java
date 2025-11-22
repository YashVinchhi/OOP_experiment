// FinalUsageDemo.java
// Demonstrates final variable, final method, and final class

final class FinalClassDemo {
    public void show() {
        System.out.println("Final class cannot be extended.");
    }
}

class Base {
    public final void finalMethod() {
        System.out.println("This final method cannot be overridden.");
    }
}

class Derived extends Base {
    // attempting to override finalMethod() would cause a compile error
}

public class FinalUsageDemo {
    public static void main(String[] args) {
        // final variable
        final int CONST = 10;
        System.out.println("Final variable CONST = " + CONST);

        // final method
        Derived d = new Derived();
        d.finalMethod();

        // final class
        FinalClassDemo fcd = new FinalClassDemo();
        fcd.show();
    }
}

/*
Differences summary:
- final variable: value cannot be changed once assigned.
- final method: cannot be overridden by subclasses.
- final class: cannot be extended (no subclasses allowed).
*/
