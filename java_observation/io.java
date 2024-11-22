import java.io.*;
public class io {
    public static void main(String[] args) throws IOException {
        File file = new File("output.txt");
        FileWriter writer = new FileWriter(file);
        for (String arg : args) {
            writer.write(arg + "\n");
        }
        writer.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
