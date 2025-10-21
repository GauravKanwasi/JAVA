public class MethodOverloadingExample {

    public void display(int a) {
        System.out.println("Displaying integer: " + a);
    }

    public void display(String s) {
        System.out.println("Displaying string: " + s);
    }

    public void display(double d) {
        System.out.println("Displaying double: " + d);
    }

    public void display(int a, String s) {
        System.out.println("Displaying int and string: " + a + " and " + s);
    }
    public static void main(String[] args) {

        MethodOverloadingExample obj = new MethodOverloadingExample();

        obj.display(10);             
        obj.display("Hello Java"); 
        obj.display(25.5);
        obj.display(100, "World");
    }
}
