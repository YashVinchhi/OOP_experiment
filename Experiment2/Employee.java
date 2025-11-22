import java.util.Scanner;

// Employee.java
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
