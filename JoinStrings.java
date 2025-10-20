import java.util.Scanner;

public class JoinStrings {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();

        String joinedString = firstString + secondString;

        System.out.println("The joined string is: " + joinedString);

        scanner.close();
    }
}
