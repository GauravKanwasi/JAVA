public class TypeCheckerEnhanced {

    public static void main(String[] args) {
        System.out.println("--- Checking Object Types (Pattern Matching) ---");
        Object[] variables = {100, 3.14, 'a', "Hello", true, null};
        
        for (Object var : variables) {
            checkVariableType(var);
        }

        System.out.println("\n--- Checking String Content (Regex) ---");
        String[] inputs = {"12345", "-99.99", "c", "Not a number", "1", "true", null, "   "};
        
        for (String input : inputs) {
            checkInputContent(input);
        }
    }

    public static void checkVariableType(Object variable) {
        if (variable == null) {
            System.out.println("The variable is null.");
            return;
        }

        switch (variable) {
            case Integer i   -> System.out.println("The variable is an Integer: " + i);
            case Double d    -> System.out.println("The variable is a Double: " + d);
            case Character c -> System.out.println("The variable is a Character: " + c);
            case String s    -> System.out.println("The variable is a String: " + s);
            case Boolean b   -> System.out.println("The variable is a Boolean: " + b);
            default          -> System.out.println("The variable is something else: " + variable.getClass().getSimpleName());
        }
    }

    public static void checkInputContent(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Input is empty or null.");
            return;
        }

        input = input.trim();

        if (input.matches("-?\\d+")) {
            System.out.println("Input '" + input + "' looks like an Integer.");
        } else if (input.matches("-?\\d*\\.\\d+")) {
            System.out.println("Input '" + input + "' looks like a Double.");
        } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            System.out.println("Input '" + input + "' looks like a Boolean.");
        } else if (input.length() == 1) {
            System.out.println("Input '" + input + "' looks like a Character.");
        } else {
            System.out.println("Input '" + input + "' is a general String.");
        }
    }
}
