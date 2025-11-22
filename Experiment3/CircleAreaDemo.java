// CircleAreaDemo.java
class Circle {
    double radius;
    final double pie = 3.141592653589793; // final variable

    public Circle(double r) {
        this.radius = r;
    }

    public double area() {
        return pie * radius * radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(2.5);
        System.out.printf("Area of circle with radius %.2f = %.4f\n", c.radius, c.area());
    }
}
