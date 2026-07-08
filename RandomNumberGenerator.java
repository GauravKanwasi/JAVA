import java.util.*;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Random Number Generator ===");

        while (true) {
            int count = readPositiveInt(scanner, "How many random numbers do you want? ");

            System.out.print("Enter minimum value: ");
            int min = scanner.nextInt();

            System.out.print("Enter maximum value: ");
            int max = scanner.nextInt();

            if (min > max) {
                System.out.println("Minimum value cannot be greater than maximum value.\n");
                continue;
            }

            System.out.print("Generate unique numbers? (yes/no): ");
            String choice = scanner.next().trim().toLowerCase();

            boolean unique = choice.equals("yes") || choice.equals("y");

            if (unique && count > (max - min + 1)) {
                System.out.println("Not enough unique numbers available in the selected range.\n");
                continue;
            }

            System.out.println("\nGenerated Numbers:");

            if (unique) {
                List<Integer> numbers = new ArrayList<>();
                for (int i = min; i <= max; i++) {
                    numbers.add(i);
                }
                Collections.shuffle(numbers);

                for (int i = 0; i < count; i++) {
                    System.out.printf("%2d. %d%n", i + 1, numbers.get(i));
                }
            } else {
                for (int i = 0; i < count; i++) {
                    int number = random.nextInt(max - min + 1) + min;
                    System.out.printf("%2d. %d%n", i + 1, number);
                }
            }

            System.out.print("\nGenerate again? (yes/no): ");
            String again = scanner.next().trim().toLowerCase();

            if (!again.equals("yes") && !again.equals("y")) {
                break;
            }

            System.out.println();
        }

        System.out.println("Thank you for using Random Number Generator!");
        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String message) {
        int value;

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();

                if (value > 0) {
                    return value;
                }

                System.out.println("Please enter a positive number.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }
}
