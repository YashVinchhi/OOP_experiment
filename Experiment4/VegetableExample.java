// VegetableExample.java
interface Vegetable {
    void color();
    void grow();
}

class Spinach implements Vegetable {
    public void color() {
        System.out.println("Color of spinach is green");
    }

    public void grow() {
        System.out.println("Spinach grows above ground");
    }
}

class Potato implements Vegetable {
    public void color() {
        System.out.println("Color of Potato is browny white");
    }

    public void grow() {
        System.out.println("Potato grows under ground");
    }
}

class Onion implements Vegetable {
    public void color() {
        System.out.println("Color of Onion is red");
    }

    public void grow() {
        System.out.println("Onion grows under ground");
    }
}

class Tomato implements Vegetable {
    public void color() {
        System.out.println("Color of Tomato is red");
    }

    public void grow() {
        System.out.println("Tomato grows above ground");
    }
}

public class VegetableExample {
    public static void main(String[] args) {
        Vegetable[] vegs = {new Spinach(), new Potato(), new Onion(), new Tomato()};
        for (Vegetable v : vegs) {
            v.color();
            v.grow();
        }
    }
}
