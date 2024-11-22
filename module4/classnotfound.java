public class classnotfound {
    public static void main(String args[])
    {
        try{
            Class.forName("Class 1");

        }
        catch(ClassNotFoundException e)
        {
        System.out.println(e);
        System.out.println("class not found");
        }
    }
}
