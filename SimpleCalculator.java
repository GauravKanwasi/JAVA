public class SimpleCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            return 0.0;
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        int num1 = 20;
        int num2 = 5;

        System.out.println("Simple Calculator Example");
        
        int sum = calc.add(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + sum);

        int difference = calc.subtract(num1, num2);
        System.out.println(num1 + " - " + num2 + " = " + difference);

        int product = calc.multiply(num1, num2);
        System.out.println(num1 + " * " + num2 + " = " + product);

        double quotient = calc.divide(num1, num2);
        System.out.println(num1 + " / " + num2 + " = " + quotient);
    }
}
