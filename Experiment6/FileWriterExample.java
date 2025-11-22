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
