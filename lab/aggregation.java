import java.util.*;
class address
{
    String city,state,country;
    public address(String city,String state,String country)
    {
        this.city=city;
        this.state=state;
        this.country=country;
    }
}
class employee
{
    int id;
    String name;
    address a;
    public employee(int id,String name,address a)
    {
        this.id=id;
        this.name=name;
        this.a=a;
    }
    public void display()
    {
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Name: "+name);
        System.out.println("City: "+a.city);
        System.out.println("State: "+a.state);
        System.out.println("Country: "+a.country);
        System.out.println();
    }
}

public class aggregation
{
    public static void main(String args[])
    {
    address a1=new address("salem","TN","India");
    address a2=new address("chennai","TN","India");
    employee emp1=new employee(001,"Mr.A",a1);
    employee emp2=new employee(002,"Mr.D",a2);
    System.out.println("****EMPLOYEE 1****");
    emp1.display();
    System.out.println("****EMPLOYEE 2****");
    emp2.display();
    }
}
