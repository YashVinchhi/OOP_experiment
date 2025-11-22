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
