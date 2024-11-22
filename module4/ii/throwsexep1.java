class throwsexep1 {
    static void func()
    throws IllegalAccessException
    {
        System.out.println("Inside func");
        throw new IllegalAccessException("demo");
    }
    public static void main(String args[])
    {
        try{
            func();
        }
        catch(IllegalAccessException e)
        {
            System.out.println("caught in main");
        }
    }
}
