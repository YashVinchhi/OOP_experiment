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
