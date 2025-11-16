interface A {
    default void message() {
        System.out.println("Message from Interface A");
    }
}

interface B {
    default void message() {
        System.out.println("Message from Interface B");
    }
}

class Test implements A, B {
    @Override
    public void message() {
        // resolving the conflict
        A.super.message();
        B.super.message();
    }
}

public class InterfaceConflictExample {
    public static void main(String[] args) {
        Test t = new Test();
        t.message();
    }
}
