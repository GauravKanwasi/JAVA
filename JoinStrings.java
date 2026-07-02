import java.util.Scanner;

public class JoinStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine().trim();

        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine().trim();

        if (firstString.isEmpty() && secondString.isEmpty()) {
            System.out.println("Both strings are empty.");
        } else {
            StringBuilder joinedString = new StringBuilder();
            if (!firstString.isEmpty()) {
                joinedString.append(firstString);
            }
            if (!firstString.isEmpty() && !secondString.isEmpty()) {
                joinedString.append(" ");
            }
            if (!secondString.isEmpty()) {
                joinedString.append(secondString);
            }
            System.out.println("\nJoined String : " + joinedString);
            System.out.println("Length        : " + joinedString.length());
            System.out.println("Uppercase     : " + joinedString.toString().toUpperCase());
            System.out.println("Lowercase     : " + joinedString.toString().toLowerCase());
        }

        scanner.close();
    }
}
