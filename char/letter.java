/*import java.util.*;
class letter
{
public static void main(String a[])
{
    System.out.println("Enter a String:");
    Scanner obj=new Scanner(System.in);
    char name=obj.nextCharAt(4);
    System.out.println("Letter:"+name);
}
}*/
// Base class: Employee
abstract class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public abstract double calculateBonus();
    public abstract String generatePerformanceReport();
    public abstract void manageProject();
}

// Subclass: Manager
class Manager extends Employee {
    public Manager(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.2;
    }

    @Override
    public String generatePerformanceReport() {
        return "Excellent";
    }

    @Override
    public void manageProject() {
        System.out.println(name + " is managing a project.");
    }
}

// Subclass: Developer
class Developer extends Employee {
    public Developer(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.12;
    }

    @Override
    public String generatePerformanceReport() {
        return "Good";
    }

    @Override
    public void manageProject() {
        System.out.println(name + " is writing code in Java.");
    }
}

// Subclass: Programmer
class Programmer extends Employee {
    public Programmer(String name, String address, double salary, String jobTitle) {
        super(name, address, salary, jobTitle);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15;
    }

    @Override
    public String generatePerformanceReport() {
        return "Excellent";
    }

    @Override
    public void manageProject() {
        System.out.println(name + " is debugging code in Python.");
    }
}

// Public Main class to test the program
public class letter {
    public static void main(String[] args) {
        Manager manager = new Manager("X", "123 Main St", 100000, "Manager");
        Developer developer = new Developer("Y", "456 Elm St", 80000, "Developer");
        Programmer programmer = new Programmer("Z", "789 Oak St", 90000, "Programmer");

        System.out.println("Manager's Bonus: " + manager.calculateBonus());
        System.out.println("Developer's Bonus: " + developer.calculateBonus());
        System.out.println("Programmer's Bonus: " + programmer.calculateBonus());

        System.out.println("Performance report for Manager: " + manager.generatePerformanceReport());
        System.out.println("Performance report for Developer: " + developer.generatePerformanceReport());
        System.out.println("Performance report for Programmer: " + programmer.generatePerformanceReport());

        manager.manageProject();
        developer.manageProject();
        programmer.manageProject();
    }
}
