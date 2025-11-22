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

class StudentInfo implements College {
    private String collegeName;
    private String studentName;
    private String sem;
    private String branch;

    public StudentInfo(String collegeName, String studentName, String sem, String branch) {
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
}

public class CollegeExample {
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

        College c1 = new StudentInfo(col, name, sem, branch);
        System.out.println("\nDetails using College reference (Student):");
        c1.Showdetails();

        College c2 = new Department(branch, name);
        System.out.println("\nDetails using College reference (Department):");
        c2.Showdetails();
        sc.close();
    }
}
