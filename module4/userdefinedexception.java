//the exception created by user is called userdefined exception

class MyException extends Exception
{
public MyException(String s)
   {
    super(s);
   }
class userdefinedexception
{
    public static void main(String[] args) {
        try
        {
            throw new MyException("Hi EEE");
        }
        catch(MyException e)
        {
            System.out.println("caught");
            System.out.println(e.getMessage());
        }
    }
}
}