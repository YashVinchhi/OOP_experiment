// NestedTryDemo.java
public class NestedTryDemo {
    public static void main(String[] args) {
        try {
            try {
                int b = 30 / 0; // ArithmeticException
                System.out.println("Result: " + b);
            } catch (ArithmeticException ae) {
                System.out.println("Caught inner ArithmeticException: " + ae.getMessage());
            }

            try {
                int a[] = new int[5];
                a[5] = 10; // ArrayIndexOutOfBoundsException
                System.out.println(a[5]);
            } catch (ArrayIndexOutOfBoundsException ie) {
                System.out.println("Caught inner ArrayIndexOutOfBoundsException: " + ie.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Caught outer Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
