public class TypeChecker {

    public static void main(String[] args) {
        System.out.println("--- Checking Object Types (instanceof) ---");

        Object var1 = 100;
        Object var2 = 3.14;
        Object var3 = 'a';
        Object var4 = "Hello";
        Object var5 = true;

        checkVariableType(var1);
        checkVariableType(var2);
        checkVariableType(var3);
        checkVariableType(var4);
        checkVariableType(var5);

        System.out.println("\n--- Checking String Content (Parsing) ---");
        checkInputContent("12345");
        checkInputContent("99.99");
        checkInputContent("c");
        checkInputContent("Not a number");
        checkInputContent("1");
    }

    public static void checkVariableType(Object variable) {
        if (variable instanceof Integer) {
            System.out.println("The variable is an Integer: " + variable);
        } else if (variable instanceof Double) {
            System.out.println("The variable is a Double: " + variable);
        } else if (variable instanceof Character) {
            System.out.println("The variable is a Character: " + variable);
        } else if (variable instanceof String) {
            System.out.println("The variable is a String: " + variable);
        } else {
            System.out.println("The variable is something else: " + variable.getClass().getSimpleName());
        }
    }

    public static void checkInputContent(String input) {
        try {
            Integer.parseInt(input);
            System.out.println("Input '" + input + "' looks like an Integer.");
            return;
        } catch (NumberFormatException e) {
            // Not an int
        }

        try {
            Double.parseDouble(input);
            System.out.println("Input '" + input + "' looks like a Double.");
            return;
        } catch (NumberFormatException e) {
            // Not a double
        }

        if (input.length() == 1) {
            System.out.println("Input '" + input + "' looks like a Character.");
        } else {
            System.out.println("Input '" + input + "' is a general String.");
        }
    }
}
