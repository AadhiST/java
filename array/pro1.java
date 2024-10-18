import java.util.*;
    class pro1
    {
        public static void main(String args[])
        {
           Scanner obj = new Scanner(System.in);
           int size=obj.nextInt();
           int[] marks = new int[size];
           for(int i=0;i<=size-1;i++)
           {
            marks[i]=obj.nextInt();
           }
           for(int i=0;i<=size-1;i++)
           {
            System.out.println(marks[i]);
           }
        }

    }