// FinalMethodDemo.java
class Shape {
    public final void draw() {
        System.out.println("Drawing shape (final method)");
    }
}

class Rectangle extends Shape {
    // Attempting to override draw() will cause a compile-time error.
    /*
    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
    */

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.draw();
    }
}

/* Expected error message if overriding is attempted:
   error: draw() in Rectangle cannot override draw() in Shape
   overridden method is final
*/
