import java.time.*;
import java.util.*;
public class lmst {
    public static void main(String[] args) {
        // List operations
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List: " + list);
        // Map operations
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        System.out.println("Map: " + map);
        // Set operations
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");
        System.out.println("Set: " + set);
        // Date and Time operations
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date: " + date);
        System.out.println("Current Time: " + time);
        System.out.println("Current DateTime: " + dateTime);
    }
}
