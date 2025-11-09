
class Animal {
    void sound() {
        System.out.println("Animals make sounds");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dogs bark");
    }

    void display() {

        super.sound();


        sound();
    }
}

public class TestSuperMethod {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.display();
    }
}
