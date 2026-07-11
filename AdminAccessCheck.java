import java.util.Scanner;

public class AdminAccessCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your role: ");
        String role = scanner.nextLine().trim();

        if (role.isEmpty()) {
            System.out.println("No role entered.");
            scanner.close();
            return;
        }

        switch (role.toLowerCase()) {
            case "admin":
                System.out.println("Access Granted.");
                System.out.println("Welcome, Administrator!");
                System.out.println("Full system privileges enabled.");
                break;

            case "manager":
                System.out.println("Access Granted.");
                System.out.println("Manager privileges enabled.");
                break;

            case "user":
                System.out.println("Access Granted.");
                System.out.println("Standard user access enabled.");
                break;

            case "guest":
                System.out.println("Limited guest access.");
                break;

            default:
                System.out.println("Access Denied.");
                System.out.println("Invalid role: " + role);
        }

        scanner.close();
    }
}
