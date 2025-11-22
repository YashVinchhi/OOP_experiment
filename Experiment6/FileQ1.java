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
