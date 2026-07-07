public class NestedIfElseExample {

    public static void main(String[] args) {
        int age = 70;

        System.out.println("Checking details for age: " + age);

        if (age >= 0) {

            if (age >= 18) {
                System.out.println("Status: Adult");

                if (age >= 65) {
                    System.out.println("Category: Senior Citizen");
                    System.out.println("Eligible for senior discount.");
                } else {
                    System.out.println("Category: Regular Adult");
                    System.out.println("Not eligible for senior discount.");
                }

                if (age >= 21) {
                    System.out.println("Eligible to consume alcohol (where legal).");
                } else {
                    System.out.println("Not eligible to consume alcohol.");
                }

            } else {
                System.out.println("Status: Minor");

                if (age < 13) {
                    System.out.println("Category: Child");
                } else {
                    System.out.println("Category: Teenager");
                }
            }

        } else {
            System.out.println("Invalid age entered.");
        }
    }
}
