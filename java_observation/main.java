import java.util.Scanner;
class Person {
    String name; // Data type: String
    int age;     // Data type: int
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        System.out.print("Enter name: ");
        person.name = scanner.nextLine();
        System.out.print("Enter age: ");
        person.age = scanner.nextInt();
        Integer ageWrapper = person.age; 
        if (ageWrapper > 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }
        person.displayInfo();
        System.out.println("Age next year: " + (ageWrapper + 1));
    }
}
