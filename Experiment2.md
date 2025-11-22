
## 1. Implement a Java program to create a class Student with data ‘name, city and age’ along with the method printData to display the data. Create the two objects s1 ,s2 to  declare and access the values.

```java
// Student.java
public class Student {
    String name;
    String city;
    int age;

    public Student(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public void printData() {
        System.out.println("Name : " + name);
        System.out.println("City : " + city);
        System.out.println("Age  : " + age);
        System.out.println();
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", "New York", 20);
        Student s2 = new Student("Bob", "Chicago", 22);

        System.out.println("Student 1:");
        s1.printData();

        System.out.println("Student 2:");
        s2.printData();
    }
}
```

## 2. Implement a java program to create a class Employee display the employee details such as employee id, employee name, salary, age using Scanner class. Create Employee class to object and display employee details.

```java
import java.util.Scanner;

// EmployeeInput.java
class Employee {
    int id;
    String name;
    double salary;
    int age;

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public void display() {
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary        : " + salary);
        System.out.println("Age           : " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Employee emp = new Employee(id, name, salary, age);
        System.out.println("\nEmployee Details:");
        emp.display();
        sc.close();
    }
}
```


## 3. Design a class to represent a bank account. Which contains account number, name of the depositor, type of the account, balance amount in the account. Use constructors to assign initial values, to Deposit an amount, to Withdraw amount after checking balance, to display name and balance.

```java
import java.util.Scanner;

// BankAccount.java
class BankAccount {
    private String accountNumber;
    private String depositorName;
    private String accountType;
    private double balance;

    public BankAccount(String accountNumber, String depositorName, String accountType, double initialBalance) {
        this.accountNumber = accountNumber;
        this.depositorName = depositorName;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: %.2f, New balance: %.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f, Remaining balance: %.2f\n", amount, balance);
        }
    }

    public void display() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Depositor Name : " + depositorName);
        System.out.println("Account Type   : " + accountType);
        System.out.printf("Balance        : %.2f\n", balance);
    }

    public static void main(String[] args) {
        BankAccount acct = new BankAccount("A12345", "Charlie", "Savings", 1000.00);
        System.out.println("Initial details:");
        acct.display();
        acct.deposit(250.75);
        acct.withdraw(100.00);
        acct.withdraw(2000.00); // should show insufficient
    }
}
```


## 4. Write a Java Program to Find Area of Square, Rectangle and Circle using Method Overloading.

```java
// AreaOverload.java
class Area {
    // Square: one double parameter
    public double area(double side) {
        return side * side;
    }

    // Rectangle: two double parameters
    public double area(double length, double breadth) {
        return length * breadth;
    }

    // Circle: overloaded method that takes radius and boolean flag
    public double area(double radius, boolean isCircle) {
        if (isCircle) {
            return Math.PI * radius * radius;
        }
        // fallback to square if boolean is false
        return area(radius);
    }

    public static void main(String[] args) {
        Area a = new Area();
        System.out.printf("Area of square (side=4): %.2f\n", a.area(4.0));
        System.out.printf("Area of rectangle (3x5): %.2f\n", a.area(3.0, 5.0));
        System.out.printf("Area of circle (r=2): %.2f\n", a.area(2.0, true));
    }
}
```


## 5.Implement a java program to create a class Box with necessary members  for calculating volume of Box and display it with method name Volume. Create a Box class object and to display the volume of Box.

```java
// Box.java
class Box {
    double length;
    double width;
    double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double Volume() {
        return length * width * height;
    }

    public void displayVolume() {
        System.out.printf("Box volume: %.2f\n", Volume());
    }

    public static void main(String[] args) {
        Box b = new Box(2.5, 3.0, 4.0);
        b.displayVolume();
    }
}
```


## 6.Implement a java program to create a class Person with data members like age, name ,address, mobile number. and declare them as private along with a method to take input of data member getinput() and for display details show(). Create a Person class object and display details.

```java
import java.util.Scanner;

// Person.java
class Person {
    private int age;
    private String name;
    private String address;
    private String mobileNumber;

    public void getinput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter age: ");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter address: ");
        this.address = sc.nextLine();
        System.out.print("Enter mobile number: ");
        this.mobileNumber = sc.nextLine();
    }

    public void show() {
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Address      : " + address);
        System.out.println("Mobile No.   : " + mobileNumber);
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.getinput();
        System.out.println();
        p.show();
    }
}
```

## 7.Consider 2 program problem in which add condition for which employee get highest salary and display that salary with necessary employee details.

```java
import java.util.Scanner;

// HighestSalary.java
class EmployeeShort {
    int id;
    String name;
    double salary;

    public EmployeeShort(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details for employee 1:");
        System.out.print("ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Salary: ");
        double sal1 = sc.nextDouble();

        sc.nextLine();
        System.out.println("\nEnter details for employee 2:");
        System.out.print("ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Salary: ");
        double sal2 = sc.nextDouble();

        EmployeeShort e1 = new EmployeeShort(id1, name1, sal1);
        EmployeeShort e2 = new EmployeeShort(id2, name2, sal2);

        System.out.println("\nEmployee with highest salary:");
        if (e1.salary >= e2.salary) {
            e1.display();
        } else {
            e2.display();
        }
        sc.close();
    }
}


