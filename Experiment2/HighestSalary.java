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
}

public class HighestSalary {
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
