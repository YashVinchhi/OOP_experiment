// MyExceptionDemo.java
class MyException extends Exception {
    private String message;

    public MyException(String msg) throws MyException {
        this.message = msg;
        // throw when constructed (as requested)
        throw this;
    }

    @Override
    public String toString() {
        return "MyException: " + message;
    }
}

public class MyExceptionDemo {
    public static void main(String[] args) {
        try {
            // creating MyException will throw it via constructor
            new MyException("Something went wrong in constructor");
        } catch (MyException e) {
            System.out.println("Caught: " + e);
        }
    }
}
