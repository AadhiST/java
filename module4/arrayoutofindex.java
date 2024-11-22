public class arrayoutofindex {

    public static void main(String args[])
    {
        try{
            int a[]=new int[5];
            a[5]=10;
            a[6]=9;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array out of bound");
        }
    }
}