// Box.java
class Box {
    double length;
    double width;
    double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double Volume() {
        return length * width * height;
    }

    public void displayVolume() {
        System.out.printf("Box volume: %.2f\n", Volume());
    }

    public static void main(String[] args) {
        Box b = new Box(2.5, 3.0, 4.0);
        b.displayVolume();
    }
}
