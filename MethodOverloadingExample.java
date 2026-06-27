public class MethodOverloadingExample {

    public static void display(int number) {
        System.out.println("Integer Value : " + number);
    }

    public static void display(double number) {
        System.out.println("Double Value  : " + number);
    }

    public static void display(String text) {
        System.out.println("String Value  : " + text);
    }

    public static void display(char character) {
        System.out.println("Character     : " + character);
    }

    public static void display(int number, String text) {
        System.out.println("Integer + String : " + number + ", " + text);
    }

    public static void display(String text, int number) {
        System.out.println("String + Integer : " + text + ", " + number);
    }

    public static void display(int first, int second) {
        System.out.println("Sum of Integers  : " + (first + second));
    }

    public static void display(int a, int b, int c) {
        System.out.println("Average          : " + ((a + b + c) / 3.0));
    }

    public static void main(String[] args) {

        System.out.println("=== Method Overloading Demonstration ===\n");

        display(10);
        display(25.5);
        display("Hello Java");
        display('A');
        display(100, "World");
        display("Java", 2025);
        display(15, 25);
        display(10, 20, 30);
    }
}
