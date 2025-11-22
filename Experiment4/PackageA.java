// PackageA.java
// Simple demonstration of method calls (without actual packages for simplicity)

class A {
    public static void displayA() {
        System.out.println("Display A from class A");
    }
}

public class PackageA {
    public static void main(String[] args) {
        A.displayA();
    }
}

/* 
Note: This is a simplified version without actual package structure.
To use real packages:

File: A.java (in mypackage folder)
package mypackage;
public class A {
    public static void displayA() {
        System.out.println("Display A from mypackage.A");
    }
}

File: PackageA.java
import mypackage.A;
public class PackageA {
    public static void main(String[] args) {
        A.displayA();
    }
}
*/
