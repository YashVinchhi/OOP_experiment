# Experiment 5
## **Q-1**

**Find the type of exception** that occurs in the given code.
Rewrite the code to **handle the exception** using `try` and `catch` block.

### **Given Code:**

```java
public class ExceptionDemo1
{  
    public static void main(String args[])
    {  
        int number = 50/0;  
        System.out.println("number=" + number);  
    }  
}
```

### **Corrected code :**

```java
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
```

---

## **Q-2**

Create an array of numbers with size **5**.
Try to access an element at **index 10** and identify the exception.
Write code to **handle the exception**.

### **code :**

```java
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
```

---

## **Q-3**

Find the type of exception in the given code.
Rewrite the code using **nested try-catch** and **finally** block.

### **Given Code:**

```java
public class nestedtry
{
    public static void main(String args[])
    {
        int b = 30/0;
        System.out.println("going to divide by 0");

        int a[] = new int[5];
        a[5] = 10;
        System.out.println(a[5]);
    }
}
```

### **Corrected code :**

```java
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
```

---

## **Q-4**

Demonstrate the **different usage of `final`** in Java.
Give differences for all use cases:

* final variable
* final method
* final class

### **Write Explanation & Examples Below:**

```java
// FinalUsageDemo.java
// Demonstrates final variable, final method, and final class

final class FinalClassDemo {
    public void show() { System.out.println("Final class cannot be extended."); }
}

class Base {
    public final void finalMethod() {
        System.out.println("This final method cannot be overridden.");
    }
}

class Derived extends Base {
    // attempting to override finalMethod() would cause a compile error
}

public class FinalUsageDemo {
    public static void main(String[] args) {
        // final variable
        final int CONST = 10;
        System.out.println("Final variable CONST = " + CONST);

        // final method
        Derived d = new Derived();
        d.finalMethod();

        // final class
        FinalClassDemo fcd = new FinalClassDemo();
        fcd.show();
    }
}

/*
Differences summary:
- final variable: value cannot be changed once assigned.
- final method: cannot be overridden by subclasses.
- final class: cannot be extended (no subclasses allowed).
*/
```

---

## **Q-5**

Demonstrate the **usage of `finally` block** in Java.

### **Code :**

```java
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
```

---

## **Q-6**

Create a **user-defined exception** named `MyException`.
Throw the exception using a **constructor** and **override `toString()`** method.

### **Code :**

```java
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
```

---