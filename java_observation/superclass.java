interface Animal {
    void sound();
}
class Mammal {
    String name;
    Mammal(String name) {
        this.name = name;
    }
    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
class Dog extends Mammal implements Animal {
    Dog(String name) {
        super(name);
    }
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}
class superclass {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.sound();
        dog.sleep();
    }
}
