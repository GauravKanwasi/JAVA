public class MethodOverloadingExample {

    public static void display(int a) {
        System.out.println("Displaying integer: " + a);
    }
    public static void display(String s) {
        System.out.println("Displaying string: " + s);
    }
    public static void display(double d) {
        System.out.println("Displaying double: " + d);
    }
    public static void display(int a, String s) {
        System.out.println("Displaying int and string: " + a + " and " + s);
    }
    public static void main(String[] args) {
        display(10);
        display("Hello Java");
        display(25.5);
        display(100, "World");
    }
}
