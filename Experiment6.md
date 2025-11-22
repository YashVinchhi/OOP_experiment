---

# **JAVA FILE HANDLING – QUESTION PAPER (Markdown Format)**

---

## **Q-1**

Create a file **"first.txt"** using the **File** class.
Implement the following methods:

1. `createNewFile()`
2. `getName()`
3. `getAbsolutePath()`
4. `canRead()`
5. `canWrite()`
6. `canRead()`
7. `length()`
8. `isFile()`
9. `isDirectory()`
10. `exists()`

### **Code :**

```java
// FileQ1.java
import java.io.File;
import java.io.IOException;

public class FileQ1 {
    public static void main(String[] args) {
        File f = new File("first.txt");
        try {
            boolean created = f.createNewFile();
            System.out.println("createNewFile(): " + created);
            System.out.println("getName(): " + f.getName());
            System.out.println("getAbsolutePath(): " + f.getAbsolutePath());
            System.out.println("canRead(): " + f.canRead());
            System.out.println("canWrite(): " + f.canWrite());
            System.out.println("length(): " + f.length());
            System.out.println("isFile(): " + f.isFile());
            System.out.println("isDirectory(): " + f.isDirectory());
            System.out.println("exists(): " + f.exists());
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}
```

---

## **Q-2**

Create file **"second.txt"** using **File** class and **change the file name** using `renameTo()`.

### **Code :**

```java
// FileQ2_Rename.java
import java.io.File;

public class FileQ2_Rename {
    public static void main(String[] args) {
        File original = new File("second.txt");
        try {
            if (!original.exists()) original.createNewFile();
        } catch (Exception e) {
            System.out.println("Could not create second.txt: " + e.getMessage());
        }

        File renamed = new File("second_renamed.txt");
        boolean result = original.renameTo(renamed);
        System.out.println("renameTo() result: " + result);
        System.out.println("New name: " + renamed.getName());
    }
}
```

---

## **Q-3**

Modify **Question 2** and perform **delete operation** using `delete()`.

### **Code :**

```java
// FileQ3_Delete.java
import java.io.File;

public class FileQ3_Delete {
    public static void main(String[] args) {
        File file = new File("second_renamed.txt");
        if (!file.exists()) {
            System.out.println("File does not exist - creating for demo.");
            try { file.createNewFile(); } catch (Exception e) { /* ignore */ }
        }

        boolean deleted = file.delete();
        System.out.println("delete() result: " + deleted);
    }
}
```

---

## **Q-4**

Find the **error** in the given code.
Also **complete the code** and **correct it**.

### **Given Code:**

```java
import java.io.File;

class File
{
    public static void main(String args[])
    {
        try
        {
            File f = new File("D\File\");
        }
        catch()
        {
            System.out.println(i);
        }
    }
}
```

### **Expected Output:**

```
File Created:false
File name is:File1.txt
File path is D:\RKU\First.java
File read operation:true
File write operation:true
File length in bytes:0
is File:true
is directory:false
is exists:true
```

### **Corrected Code:**

```java
// FileExample_Corrected.java
import java.io.File;
import java.io.IOException;

public class FileExample_Corrected {
    public static void main(String args[]) {
        try {
            // use double backslashes for Windows paths
            File f = new File("D:\\RKU\\First.java");
            boolean created = false;
            try {
                // createNewFile will return true if file did not exist and was created
                created = f.createNewFile();
            } catch (IOException ioe) {
                // directory may not exist; this demo just reports the exception
            }

            System.out.println("File Created:" + created);
            System.out.println("File name is:" + f.getName());
            System.out.println("File path is " + f.getAbsolutePath());
            System.out.println("File read operation:" + f.canRead());
            System.out.println("File write operation:" + f.canWrite());
            System.out.println("File length in bytes:" + f.length());
            System.out.println("is File:" + f.isFile());
            System.out.println("is directory:" + f.isDirectory());
            System.out.println("is exists:" + f.exists());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

---

## **Q-5**

Implement **FileWriter** class with `try` and `catch` block.

### **Code :**

```java
// FileWriterExample.java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("fw_demo.txt")) {
            fw.write("This is a sample line written by FileWriter.\n");
            fw.write("Second line.\n");
            System.out.println("FileWriter: Write successful.");
        } catch (IOException e) {
            System.out.println("FileWriter error: " + e.getMessage());
        }
    }
}
```

---

## **Q-6**

Implement **FileReader** and **BufferedReader** classes with necessary methods.

### **Code :**

```java
// FileReaderBufferedReaderExample.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderBufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("fw_demo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
```

---