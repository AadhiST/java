import java.util.*;
public class generics {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        printList(integerList);
        printList(doubleList);
    }
    public static <T> void printList(List<? extends T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}
