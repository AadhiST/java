import java.util.Scanner;
class basic
{
    public static void main(String args[])
    {
       /* boolean rain =true;
        if(rain)
        {
            System.out.println("Take an umbrella");
        }
        else
        {
            System.out.println("Enjoy the sunlight");
        }*/
       Scanner obj = new Scanner(System.in);
       int n=obj.nextInt();
       if(n>34)
       {
        System.out.println("Pass");
       }
       else{
        System.out.println("Fail");
       }
      /*String f1 = new String ("apple");//f1 create new obj in heap
      String f2 = new String ("apple");//f2 creates new obj in heap so both have diff address because of keyword new
      System.out.println(f1.equals(f2));
      System.out.println(f1==f2);
      String a1 =  "apple";//a1 stores in string poll
      String a2 =  "apple";//a2 have reference of a2
      System.out.println(a1==a2);*/
      /*Scanner obj = new Scanner (System.in);
      String RCB = obj.nextLine();
      if(RCB.equals("win"))
      {
        System.out.println("esala cup namdey");
      }
      else{
        System.out.println("cup nahi");
      }*/
    }
}