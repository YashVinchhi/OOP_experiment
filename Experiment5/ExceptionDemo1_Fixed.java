// ExceptionDemo1_Fixed.java
public class ExceptionDemo1_Fixed {
    public static void main(String[] args) {
        try {
            int number = 50 / 0; // will throw ArithmeticException
            System.out.println("number=" + number);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}
