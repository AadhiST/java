import java.util.*;
class pro1
{
    public static void main (String args[])
    {
        /*Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
        int b = obj.nextInt();
        int count =0;
        for(int i=a;i<=b;i++)
        {
            if(i%2==0)
            {
                //System.out.println(i);
            }
            else
            //count odd number
            {
                
                count=count+1;
                System.out.println(i);
            }
        }
        System.out.println(count);*/
        for(int i=1;i<=100;i++){
            if(i%3==0 && i%5==0){
                System.out.println(i);
            }
        }
    }
}