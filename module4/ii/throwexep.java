public class throwexep {
    static void help() 
    {
        try
        {
            throw new NullPointerException("ERROR UNKNOWN");
        }
        catch(NullPointerException e)
        {
            System.out.println("caught inside help.");
            throw e;
        }
    }
    public static void main(String[] args) {
        try
        {
            help();
        }
        catch(NullPointerException e)
        {
            System.out.println("caugth in main");
            System.out.println(e);
        }
    }
}
