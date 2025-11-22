// AreaOverload.java
class Area {
    // Square: one double parameter
    public double area(double side) {
        return side * side;
    }

    // Rectangle: two double parameters
    public double area(double length, double breadth) {
        return length * breadth;
    }

    // Circle: overloaded method that takes radius and boolean flag
    public double area(double radius, boolean isCircle) {
        if (isCircle) {
            return Math.PI * radius * radius;
        }
        // fallback to square if boolean is false
        return area(radius);
    }
}

public class AreaOverload {
    public static void main(String[] args) {
        Area a = new Area();
        System.out.printf("Area of square (side=4): %.2f\n", a.area(4.0));
        System.out.printf("Area of rectangle (3x5): %.2f\n", a.area(3.0, 5.0));
        System.out.printf("Area of circle (r=2): %.2f\n", a.area(2.0, true));
    }
}
