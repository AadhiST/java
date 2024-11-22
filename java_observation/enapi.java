abstract class Animal {
    abstract void sound();
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
class Person {
    private String name; // Encapsulation
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
class enapi {
    public static void main(String[] args) {
        // Inheritance & Polymorphism
        Animal dog = new Dog();
        dog.sound();
        // Encapsulation
        Person person = new Person();
        person.setName("John");
        System.out.println("Name: " + person.getName());
    }
}
