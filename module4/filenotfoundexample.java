import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class filenotfoundexample {
    public static void main(String[] args) {
        try {
            File file = new File("E://name.jpg");
            FileReader fr = new FileReader(file);
            // You can add code to read from the file here if needed
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
        }
    }
}