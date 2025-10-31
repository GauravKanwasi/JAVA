import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter how many random numbers you want: ");
        int count = scanner.nextInt();

        System.out.print("Enter the maximum value for random numbers: ");
        int max = scanner.nextInt();

        System.out.println("\nHere are your random numbers:");
        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(max + 1); // generates from 0 to max
            System.out.println(randomNumber);
        }

        scanner.close();
    }
}
