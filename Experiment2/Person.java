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
