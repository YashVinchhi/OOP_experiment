// ArrayAccessDemo.java
public class ArrayAccessDemo {
    public static void main(String[] args) {
        int[] arr = new int[5];
        try {
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
