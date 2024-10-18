import java.util.Scanner;
class q1{
    public static void main(String args[])
    {
        Scanner obj =new Scanner (System.in);
        String name =obj.nextLine();
        int age =obj.nextInt();
        obj.nextLine();
        String address=obj.nextLine();
        System.out.println("My name is "+name);
        System.out.println("My age is "+age);
        System.out.println("My address is "+address);
    }
}