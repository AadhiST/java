import java.util.*;
class mobile
{
    public String name;
    public String ram;
    public String rom;
    mobile(String name,String ram,String rom)//create a constructor in name of class
    {
        this.name=name;
        this.ram=ram;
        this.rom=rom;
    }
}//end 

class mobilestore
{
    private final List<mobile>mobiles;
    mobilestore(List<mobile>mobiles)
    {
        this.mobiles=mobiles;
    }
    public List<mobile>gettotalmobile()
    {
        return mobiles;
    }
}//end 

class composition
{
    public static void main(String []args)
    {
        mobile mob1=new mobile("Oppo","16GB","256GB");
        mobile mob2=new mobile("Samsung","8GB","128GB");
        mobile mob3=new mobile("Moto","8GB","256GB");
        List<mobile>mobiles=new ArrayList<mobile>();
        mobiles.add(mob1);
        mobiles.add(mob2);
        mobiles.add(mob3);
        mobilestore store=new mobilestore(mobiles);
        List<mobile>mob=store.gettotalmobile();
        for(mobile mb:mob)
        {
            System.out.println("Name:" + mb.name + "  RAM:" + mb.ram + "  ROM:" + mb.rom);
        }
    }
}