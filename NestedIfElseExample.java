public class NestedIfElseExample {

    public static void main(String[] args) {
        int age = 70;

        System.out.println("Checking eligibility for age: " + age);

        if (age >= 18) {
            System.out.println("You are an adult.");

            if (age >= 65) {
                System.out.println("You are eligible for a senior discount.");
            } else {
                System.out.println("You are not eligible for a senior discount.");
            }

        } else {
            System.out.println("You are a minor.");
        }
    }
}
