import java.util.*;
public class demo
{
    public static void main(String []a)
    {
        Collection<Integer>list = new ArrayList<Integer>(5);
        list.add(5);
        list.add(10);
        list.add(15);
        for(Integer num:list)
        {
            System.out.println("Number = "+num);
        }
        Collection<Integer>list1 = new ArrayList<Integer>();
        list1.addAll(list);
        System.out.println("List is "+list1);
    }
}