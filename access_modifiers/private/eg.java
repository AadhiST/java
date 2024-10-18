class democlass
{
    /*public  int data =200;
    public void msg()*/
    private  int data =200;
    private void msg()
    {
        System.out.println("HI");
    }
}
public class eg
{
    public static void main(String [] args)
    {
        democlass obj = new democlass();
        obj.msg();
        System.out.println(obj.data);
    }
}