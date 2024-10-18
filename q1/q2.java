import java.util.*;
class q2{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int a=obj.nextInt();
        int b=obj.nextInt();
        int c=obj.nextInt();
        int d=a*b*c;
        int e=(a+b+c);
        System.out.print("Ans "+d/e);
    }
}