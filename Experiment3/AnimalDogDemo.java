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
