interface A {
    default void message() {
        System.out.println("Message from Interface A");
    }

    default void greet() {
        System.out.println("Hello from Interface A");
    }
}

interface B {
    default void message() {
        System.out.println("Message from Interface B");
    }

    default void goodbye() {
        System.out.println("Goodbye from Interface B");
    }
}

class Test implements A, B {

    @Override
    public void message() {
        System.out.println("Resolving default method conflict:");
        A.super.message();
        B.super.message();
        System.out.println("Custom implementation in Test");
    }

    public void showInterfaceMessages() {
        System.out.println("\nCalling individual interface methods:");
        A.super.message();
        B.super.message();
    }
}

public class InterfaceConflictExample {
    public static void main(String[] args) {
        Test obj = new Test();

        System.out.println("=== Default Method Conflict Resolution ===");
        obj.message();

        System.out.println("\n=== Other Default Methods ===");
        obj.greet();
        obj.goodbye();

        obj.showInterfaceMessages();
    }
}
