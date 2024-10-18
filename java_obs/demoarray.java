import java.util.*;
public class demoarray
{
    public static void main(String []a)
    {
      ArrayList<String>list = new ArrayList<String>(5);
        list.add("Hi");
        list.add("Welcome");
        list.add("EEE");
        Iterator obj = list.iterator();
        while(obj.hasNext())
        {
            System.out.println(obj.next());
        }
    }
}