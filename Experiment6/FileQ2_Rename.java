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
