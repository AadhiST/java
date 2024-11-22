public class numberformat
{
    public static void main(String[] args) {
        try{
            int num = Integer.parseInt("abcd");
            System.out.println(num);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Number format exception");
        }
    }
}