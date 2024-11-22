import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bufferedreader
{
    public static void main(String args[]) throws IOException
    {
        //input using bufferedreader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //read input using readLine();
        System.out.println("Read input:");
        String name = reader.readLine();
        System.out.println(name);
    }
}