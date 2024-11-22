import java.util.*;
class q3
{
    public static void main (String args[])
    {
        Scanner obj = new Scanner (System.in);
        String name = obj.nextLine();
        double mark = obj.nextDouble();
        obj.nextLine();
        String department = obj.nextLine();
        System.out.println("My name is "+name);
        System.out.println("My mark out of 10 is " +mark/10+ "/10" );
        System.out.println("My dept is "+department);
    }
}