import java.util.*;
public class lambda {
    public static void main(String[] args) {
        // Lambda expression
        MyInterface myInterface = (a, b) -> a + b;
        System.out.println("Sum: " + myInterface.add(5, 3));
        // forEach() method
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        list.forEach(item -> System.out.println(item));
    }
    interface MyInterface {
        int add(int a, int b);
    }
}
