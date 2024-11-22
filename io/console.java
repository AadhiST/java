import java.io.Console;
public class console
{
    public static void main(String args[])
    {
        String name;
        Console obj=System.console();
        //read input 
        name = obj.readLine("Enter the name:");
        System.out.println("Name is "+name);
        //crearte password
        System.out.println("Entre the password:");
        char[] ch = obj.readPassword();
        //display
        //convert char[] to string
        String pw = String.valueOf(ch);
        System.out.println("password is: "+pw);
    }
}