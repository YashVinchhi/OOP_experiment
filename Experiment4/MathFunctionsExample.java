// MathFunctionsExample.java
public class MathFunctionsExample {
    public static void main(String[] args) {
        double r = Math.random();
        System.out.println("random() -> " + r);

        System.out.println("min(3,7) -> " + Math.min(3, 7));
        System.out.println("max(3,7) -> " + Math.max(3, 7));

        System.out.println("sqrt(16) -> " + Math.sqrt(16));
        System.out.println("pow(2,5) -> " + Math.pow(2, 5));

        System.out.println("abs(-10) -> " + Math.abs(-10));
        System.out.println("round(3.6) -> " + Math.round(3.6));
    }
}
