public class arithmeticexception
{
    public static void main(String arg[])
    {
        try{
            int a=30;
            int b=5;
            int c=a/b;
            System.out.println("Result = "+c);
        }
        catch(ArithmeticException e)
        {
            System.out.println("cannot divide");
        }
    }
}