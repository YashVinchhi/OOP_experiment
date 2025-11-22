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
