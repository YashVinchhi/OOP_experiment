## **1. Interface Shape**

Create an interface named **Shape** containing two empty methods:

* `Area()`
* `Perimeter()`

Create two classes **Triangle** and **Circle** that implement **Shape**.
Both classes must implement `Area()` and `Perimeter()` to print the area and perimeter.

### **Code :**

```java
// ShapeExample.java
interface Shape {
	void Area();
	void Perimeter();
}

class Triangle implements Shape {
	private double a, b, c; // sides

	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public void Area() {
		double s = (a + b + c) / 2.0;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		System.out.printf("Triangle area: %.2f\n", area);
	}

	@Override
	public void Perimeter() {
		System.out.printf("Triangle perimeter: %.2f\n", (a + b + c));
	}
}

class Circle implements Shape {
	private double r;

	public Circle(double r) { this.r = r; }

	@Override
	public void Area() {
		System.out.printf("Circle area: %.2f\n", Math.PI * r * r);
	}

	@Override
	public void Perimeter() {
		System.out.printf("Circle perimeter: %.2f\n", 2 * Math.PI * r);
	}

// Quick runner for Shape
class ShapeExample {
	public static void main(String[] args) {
		Shape t = new Triangle(3, 4, 5);
		Shape c = new Circle(2);
		t.Area(); t.Perimeter();
		c.Area(); c.Perimeter();
	}
}
```

---

## **2. Abstract Class Insect**

Create an abstract class **Insect** with an abstract method:

```java
void flystatus();
```

Create classes **Termite**, **Grasshopper**, and **Ant**, each implementing `flystatus()`.

### **Expected Output**

```
Termite cannot fly
Grasshopper can fly
Ant cannot fly
```

### **Code :**

```java
// InsectExample.java
abstract class Insect {
	abstract void flystatus();
}

class Termite extends Insect {
	@Override
	void flystatus() { System.out.println("Termite cannot fly"); }
}

class Grasshopper extends Insect {
	@Override
	void flystatus() { System.out.println("Grasshopper can fly"); }
}

class Ant extends Insect {
	@Override
	void flystatus() { System.out.println("Ant cannot fly"); }
}

class InsectExample {
	public static void main(String[] args) {
		Insect[] arr = { new Termite(), new Grasshopper(), new Ant() };
		for (Insect ins : arr) ins.flystatus();
	}
}
```

---

## **3. Vehicle Inheritance**

Create a base class **Vehicle**.
Derive the following classes from it:

* **two_wheeler**
* **three_wheeler**
* **four_wheeler**

Display properties such as **speed**, **fuel type**, etc., using member functions.

### **Code :**

```java
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
	public two_wheeler(String fuelType, double maxSpeed) { super(fuelType, maxSpeed); }
	public void show() { System.out.println("Two wheeler"); display(); }
}

class three_wheeler extends Vehicle {
	public three_wheeler(String fuelType, double maxSpeed) { super(fuelType, maxSpeed); }
	public void show() { System.out.println("Three wheeler"); display(); }
}

class four_wheeler extends Vehicle {
	public four_wheeler(String fuelType, double maxSpeed) { super(fuelType, maxSpeed); }
	public void show() { System.out.println("Four wheeler"); display(); }
}

class VehicleExample {
	public static void main(String[] args) {
		two_wheeler t = new two_wheeler("Petrol", 120);
		three_wheeler th = new three_wheeler("Diesel", 80);
		four_wheeler f = new four_wheeler("Electric", 160);

		t.show(); System.out.println();
		th.show(); System.out.println();
		f.show();
	}
}
```

---

## **4. Interface Vegetable**

Create an interface **Vegetable** with methods:

* `color()`
* `grow()`

Implement these methods in:

* **Spinach**
* **Potato**
* **Onion**
* **Tomato**

### **Expected Output**

```
Color of spinach is green
Spinach grows above ground
Color of Potato is browny white
Potato grows under ground
Color of Onion is red
Onion grows under ground
Color of Tomato is red
Tomato grows above ground
```

### **Code :**

```java
// VegetableExample.java
interface Vegetable {
	void color();
	void grow();
}

class Spinach implements Vegetable {
	public void color() { System.out.println("Color of spinach is green"); }
	public void grow()  { System.out.println("Spinach grows above ground"); }
}

class Potato implements Vegetable {
	public void color() { System.out.println("Color of Potato is browny white"); }
	public void grow()  { System.out.println("Potato grows under ground"); }
}

class Onion implements Vegetable {
	public void color() { System.out.println("Color of Onion is red"); }
	public void grow()  { System.out.println("Onion grows under ground"); }
}

class Tomato implements Vegetable {
	public void color() { System.out.println("Color of Tomato is red"); }
	public void grow()  { System.out.println("Tomato grows above ground"); }
}

class VegetableExample {
	public static void main(String[] args) {
		Vegetable[] vegs = { new Spinach(), new Potato(), new Onion(), new Tomato() };
		for (Vegetable v : vegs) { v.color(); v.grow(); }
	}
}
```

---

## **5. Interface College**

Create an interface **College** with fields:

* College Name
* Branch
* Student Name
* Semester

And a method:

```java
void Showdetails();
```

Create two classes:

* **Department** → Display Branch & Student Name
* **Student** → Display College Name, Student Name, Sem, Branch

All details must be taken through **user input**.
Display using **reference variable of College interface**.

### **Code :**

```java
// CollegeExample.java
import java.util.Scanner;

interface College {
	void Showdetails();
}

class Department implements College {
	private String branch;
	private String studentName;

	public Department(String branch, String studentName) {
		this.branch = branch;
		this.studentName = studentName;
	}

	@Override
	public void Showdetails() {
		System.out.println("Branch: " + branch);
		System.out.println("Student Name: " + studentName);
	}
}

class Student implements College {
	private String collegeName;
	private String studentName;
	private String sem;
	private String branch;

	public Student(String collegeName, String studentName, String sem, String branch) {
		this.collegeName = collegeName;
		this.studentName = studentName;
		this.sem = sem;
		this.branch = branch;
	}

	@Override
	public void Showdetails() {
		System.out.println("College Name: " + collegeName);
		System.out.println("Student Name: " + studentName);
		System.out.println("Semester: " + sem);
		System.out.println("Branch: " + branch);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter College Name: ");
		String col = sc.nextLine();
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Semester: ");
		String sem = sc.nextLine();
		System.out.print("Enter Branch: ");
		String branch = sc.nextLine();

		College c1 = new Student(col, name, sem, branch);
		System.out.println("\nDetails using College reference (Student):");
		c1.Showdetails();

		College c2 = new Department(branch, name);
		System.out.println("\nDetails using College reference (Department):");
		c2.Showdetails();
		sc.close();
	}
}
```

---

## **6. Packages in Java**

Perform the following:

1. Create a package **mypackage** in **A.java**
2. Define a class with method `displayA()`
3. Create another file **b.java**
4. Import **mypackage**
5. Access `displayA()` method inside `b.java`

### **Code :**

```java
// Packages example (A.java and B.java) - shown inline for clarity

/*
File: A.java
package mypackage;
public class A {
	public static void displayA() {
		System.out.println("Display A from mypackage.A");
	}
}

File: B.java
import mypackage.A;
public class B {
	public static void main(String[] args) {
		A.displayA();
	}
}
*/

// Note: Save the above two classes in separate files with package declaration for A.java
```

---

## **7. Java Math Class Functions**

Implement the following built-in functions from `java.lang.Math`:

* `random()`
* `min()`
* `max()`
* `sqrt()`
* `pow()`
* `abs()`
* `round()`

### **Code :**

```java
// MathFunctionsExample.java
class MathFunctionsExample {
	public static void main(String[] args) {
		double r = Math.random();
		System.out.println("random() -> " + r);

		System.out.println("min(3,7) -> " + Math.min(3, 7));
		System.out.println("max(3,7) -> " + Math.max(3, 7));

		System.out.println("sqrt(16) -> " + Math.sqrt(16));
		System.out.println("pow(2,5) -> " + Math.pow(2, 5));

		System.out.println("abs(-10) -> " + Math.abs(-10));
		System.out.println("round(3.6) -> " + Math.round(3.6));
	}
}
```
