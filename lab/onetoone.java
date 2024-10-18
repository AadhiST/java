import java.util.*;
class person
{
    private String name;
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name=name;
    }
}
class passport 
{
    private int passportno;
    public int getpassportno()
    {
        return passportno;
    }
    public int setpassportno(int passportno)
    {
        this.passportno=passportno;
        return 0;
    }
}
public class onetoone
{
    public static void main(String []args)
    {
        person p1=new person();
        p1.setname("Mr.D");
        person p2=new person();
        p2.setname("Mr.A");
        passport p3=new passport();
        p3.setpassportno(5654676);
        passport p4=new passport();
        p4.setpassportno(9484665);
        System.out.println(p1.getname()+" has a passport which have a number "+p3.getpassportno());
        System.out.println(p2.getname()+" has a passport which have a number "+p4.getpassportno());
    }
}