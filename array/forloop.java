import java.util.*;
class forloop
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int[] marks = new int[5];
       /* marks[0]=obj.nextInt();
        marks[1]=obj.nextInt();
        marks[2]=obj.nextInt();
        marks[3]=obj.nextInt();
        marks[4]=obj.nextInt();*/
        for (int i=0;i<5;i++)
        {
            marks[i]=obj.nextInt();
            System.out.println("Number:"+marks[i]);
        }
    }
}