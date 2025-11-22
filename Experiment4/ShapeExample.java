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

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void Area() {
        System.out.printf("Circle area: %.2f\n", Math.PI * r * r);
    }

    @Override
    public void Perimeter() {
        System.out.printf("Circle perimeter: %.2f\n", 2 * Math.PI * r);
    }
}

public class ShapeExample {
    public static void main(String[] args) {
        Shape t = new Triangle(3, 4, 5);
        Shape c = new Circle(2);
        t.Area();
        t.Perimeter();
        c.Area();
        c.Perimeter();
    }
}
