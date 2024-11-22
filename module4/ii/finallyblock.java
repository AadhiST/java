public class finallyblock {
    public static void main(String at[])
    {
        try
        {
            System.out.println("Try block");
            int data = 12515;
            System.out.println("Result = "+data);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Catch block");
            System.out.println(e);
        }
        finally
        {
            System.out.println("Finally Block");
            System.out.println("No exception");
            System.out.println("Rest of the code");
        }
    }
}
