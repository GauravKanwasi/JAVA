class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }

    void sound() {
        System.out.println("Animals make sounds");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor called");
    }

    @Override
    void sound() {
        System.out.println("Dogs bark");
    }

    void display() {
        System.out.println("\nCalling parent class method:");
        super.sound();

        System.out.println("\nCalling child class method:");
        sound();
    }
}

public class TestSuperMethod {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println();
        d.display();
    }
}
