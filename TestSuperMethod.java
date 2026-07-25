class Animal {

    Animal() {
        System.out.println("Animal constructor called.");
    }

    void sound() {
        System.out.println("Animal Sound : Animals make sounds.");
    }
}

class Dog extends Animal {

    Dog() {
        super(); // Calls the parent class constructor
        System.out.println("Dog constructor called.");
    }

    @Override
    void sound() {
        System.out.println("Dog Sound    : Dogs bark.");
    }

    void display() {
        System.out.println("\n===== Demonstrating super Keyword =====");

        System.out.println("\n1. Calling Parent Class Method:");
        super.sound();

        System.out.println("\n2. Calling Overridden Child Class Method:");
        sound();

        System.out.println("\n=======================================");
    }
}

public class TestSuperMethod {

    public static void main(String[] args) {

        System.out.println("Creating Dog object...\n");

        Dog dog = new Dog();

        System.out.println();

        dog.display();
    }
}
