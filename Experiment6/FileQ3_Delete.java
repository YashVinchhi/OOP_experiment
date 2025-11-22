// FileQ3_Delete.java
import java.io.File;

public class FileQ3_Delete {
    public static void main(String[] args) {
        File file = new File("second_renamed.txt");
        if (!file.exists()) {
            System.out.println("File does not exist - creating for demo.");
            try {
                file.createNewFile();
            } catch (Exception e) {
                /* ignore */
            }
        }

        boolean deleted = file.delete();
        System.out.println("delete() result: " + deleted);
    }
}
