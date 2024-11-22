import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CommandLineIO {

    public static void main(String[] args) {
        // Check if command line arguments are provided
        if (args.length != 2) {
            System.out.println("Usage: java CommandLineIO <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];  // Input file name from command-line
        String outputFile = args[1]; // Output file name from command-line

        try {
            // FileReader to read from the input file
            FileReader fr = new FileReader(inputFile);
            // FileWriter to write to the output file
            FileWriter fw = new FileWriter(outputFile);

            int character;
            // Read characters from the input file and write to output file
            while ((character = fr.read()) != -1) {
                fw.write(character);
            }

            // Close the readers/writers
            fr.close();
            fw.close();

            System.out.println("File copied successfully from " + inputFile + " to " + outputFile);

        } catch (IOException e) {
            // Handle exceptions during file operations
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}