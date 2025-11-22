## **Q-1**

Create a class **Animal** as a parent class with:

* method `eat()`
* variable `name`

Create a class **Dog** that:

* declares its own method `display()`
* inherits all properties of `Animal`

Create object(s) of **Dog** and access all methods and variables of the parent class.
Print complete details of Dog.

### **Write Code Below:**

```java
// AnimalDogDemo.java
class Animal {
  String name;

  public void eat() {
    System.out.println(name + " is eating.");
  }
}

class Dog extends Animal {
  public void display() {
    System.out.println("Dog name: " + name);
    eat();
  }

  public static void main(String[] args) {
    Dog d = new Dog();
    d.name = "Buddy"; // inherit name from Animal
    d.display();
  }
}
```

---

## **Q-2**

Create a class **Vehicle** with method `run()`.
Create class **Bike** that extends Vehicle and overrides `run()` method.
Demonstrate **method overriding**.

### **Write Code Below:**

```java
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
```

---

## **Q-3**

Create classes **Car**, **Maruti**, and **Maruti800**.

Hierarchy:

```
Car → Maruti → Maruti800
```

* **Car** has:

  * method `Speed()`
  * data member `fuel`
* **Maruti** has:

  * method `gear()`
  * data member `geartype`
* **Maruti800** has:

  * method `getModel()`
  * data member `modelname`

Using **Maruti800 class**, display all details (from all three classes).

### **Write Code Below:**

```java
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
```

---

## **Q-4**

Create a class **Bank** with method:

```
GetInterestRate()
```

Implement **hierarchical inheritance** with child classes:

* ICICI
* SBI
* BOB

Each subclass overrides `GetInterestRate()`.
Demonstrate **method overriding**.

### **Write Code Below:**

```java
// BankInheritanceDemo.java
class Bank {
  public double GetInterestRate() {
    return 0.0;
  }
}

class ICICI extends Bank {
  @Override
  public double GetInterestRate() { return 7.5; }
}

class SBI extends Bank {
  @Override
  public double GetInterestRate() { return 6.8; }
}

class BOB extends Bank {
  @Override
  public double GetInterestRate() { return 7.0; }
}

class BankInheritanceDemo {
  public static void main(String[] args) {
    Bank b1 = new ICICI();
    Bank b2 = new SBI();
    Bank b3 = new BOB();

    System.out.println("ICICI Interest Rate: " + b1.GetInterestRate() + "%");
    System.out.println("SBI Interest Rate: " + b2.GetInterestRate() + "%");
    System.out.println("BOB Interest Rate: " + b3.GetInterestRate() + "%");
  }
}
```

---

## **Q-5**

Create a class **Student** with:

* Static methods:

  * `getName()`
  * `SetName()`
  * `ShowDetails()`
* Data members:
  `name`, `rollno`, `branch`, `sem`, `college`

`getName()` → Take user input
`SetName()` → Change/assign values
`ShowDetails()` → Display updated details

### **Write Code Below:**

```java
// StudentStaticDemo.java
import java.util.Scanner;

public class StudentStaticDemo {
  // static data members
  static String name;
  static String rollno;
  static String branch;
  static String sem;
  static String college;

  public static void getName() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = sc.nextLine();
  }

  public static void SetName(String newName, String newRoll, String newBranch, String newSem, String newCollege) {
    name = newName;
    rollno = newRoll;
    branch = newBranch;
    sem = newSem;
    college = newCollege;
  }

  public static void ShowDetails() {
    System.out.println("Name: " + name);
    System.out.println("Roll No: " + rollno);
    System.out.println("Branch: " + branch);
    System.out.println("Semester: " + sem);
    System.out.println("College: " + college);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter initial name: ");
    name = sc.nextLine();
    System.out.print("Enter rollno: ");
    rollno = sc.nextLine();
    System.out.print("Enter branch: ");
    branch = sc.nextLine();
    System.out.print("Enter sem: ");
    sem = sc.nextLine();
    System.out.print("Enter college: ");
    college = sc.nextLine();

    System.out.println("\nInitial details:");
    ShowDetails();

    // change using SetName
    System.out.print("\nEnter new name to set: ");
    String newName = sc.nextLine();
    SetName(newName, rollno, branch, sem, college);

    System.out.println("\nUpdated details:");
    ShowDetails();
    sc.close();
  }
}
```

---

## **Q-6**

Design class **Circle** with:

* data member `radius`
* `pie` declared as **final variable**

Find the **area of the circle**.

### **Write Code Below:**

```java
// CircleAreaDemo.java
class Circle {
  double radius;
  final double pie = 3.141592653589793; // final variable

  public Circle(double r) { this.radius = r; }

  public double area() {
    return pie * radius * radius;
  }

  public static void main(String[] args) {
    Circle c = new Circle(2.5);
    System.out.printf("Area of circle with radius %.2f = %.4f\n", c.radius, c.area());
  }
}
```

---

## **Q-7**

Demonstrate usage of the **this** keyword in Java with a suitable example.

### **Write Code Below:**

```java
// ThisKeywordDemo.java
class ThisDemo {
  String name;

  ThisDemo(String name) {
    // 'this' distinguishes instance variable from parameter
    this.name = name;
  }

  public void setName(String name) {
    this.name = name; // this refers to current instance
  }

  public void show() {
    System.out.println("Name = " + this.name);
  }

  public static void main(String[] args) {
    ThisDemo td = new ThisDemo("Original");
    td.show();
    td.setName("Updated");
    td.show();
  }
}
```

---

## **Q-8**

Design class **Shape** where `draw()` is declared as **final**.
Extend Shape class using subclass **Rectangle**, and try to override `draw()`.

Take a *screenshot of the output or error* (or write the expected error message).

### **Write Code Below:**

```java
// FinalMethodDemo.java
class Shape {
  public final void draw() {
    System.out.println("Drawing shape (final method)");
  }
}

class Rectangle extends Shape {
  // Attempting to override draw() will cause a compile-time error.
  /*
  @Override
  public void draw() {
    System.out.println("Rectangle draw");
  }
  */

  public static void main(String[] args) {
    Rectangle r = new Rectangle();
    r.draw();
  }
}

/* Expected error message if overriding is attempted:
   error: draw() in Rectangle cannot override draw() in Shape
   overridden method is final
*/
```
