import java.util.Scanner;

public class AdminAccessCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your user role: ");
        String userRole = scanner.nextLine();

        if (userRole.equalsIgnoreCase("admin")) {
            System.out.println("Access Granted. Welcome, Admin! 🛡️");
        } else {
            System.out.println("Access Denied. ⛔");
        }

        scanner.close();
    }
}
