import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        // String functions
        String str = "Hello, World!";
        System.out.println("Length: " + str.length());
        System.out.println("Char at position 1: " + str.charAt(1));
        System.out.println("Substring (7, 12): " + str.substring(7, 12));
        System.out.println("Equals 'Hello, World!': " + str.equals("Hello, World!"));
        // StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World!");
        System.out.println("StringBuilder: " + sb.toString());
        // StringBuffer
        StringBuffer sbf = new StringBuffer("Thread-safe");
        sbf.append(" StringBuffer");
        System.out.println("StringBuffer: " + sbf.toString());
        // Regex example
        String text = "The quick brown fox jumps over the lazy dog";
        String regex = "fox";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println("Found 'fox' at position: " + matcher.start());
        }
    }
}
