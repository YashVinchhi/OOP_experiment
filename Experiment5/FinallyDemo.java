// FinallyDemo.java
public class FinallyDemo {
    public static int testFinally() {
        try {
            System.out.println("In try block");
            return 1;
        } catch (Exception e) {
            System.out.println("In catch block");
            return 2;
        } finally {
            System.out.println("In finally block - always executes");
        }
    }

    public static void main(String[] args) {
        int result = testFinally();
        System.out.println("Returned: " + result);
    }
}
