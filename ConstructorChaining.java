public class ConstructorChaining {

    private int id;
    private String name;
    private int age;
    private String location;
    private String profession;

    public ConstructorChaining() {
        System.out.println("1. Default Constructor");
        id = 0;
        name = "Unknown";
        age = 0;
        location = "Not Specified";
        profession = "Student";
    }

    public ConstructorChaining(String name) {
        this();
        System.out.println("2. Constructor with Name");
        this.name = name;
    }

    public ConstructorChaining(String name, int age) {
        this(name);
        System.out.println("3. Constructor with Name and Age");
        this.age = age;
    }

    public ConstructorChaining(String name, int age, String location) {
        this(name, age);
        System.out.println("4. Constructor with Name, Age and Location");
        this.location = location;
    }

    public ConstructorChaining(int id, String name, int age, String location, String profession) {
        this(name, age, location);
        System.out.println("5. Constructor with All Details");
        this.id = id;
        this.profession = profession;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Location   : " + location);
        System.out.println("Profession : " + profession);
        System.out.println("Adult      : " + (isAdult() ? "Yes" : "No"));
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        System.out.println("\nCreating Person 1");
        ConstructorChaining p1 = new ConstructorChaining(101, "Alice", 28, "New York", "Software Engineer");
        p1.display();

        System.out.println("\nCreating Person 2");
        ConstructorChaining p2 = new ConstructorChaining("Bob", 22, "Chicago");
        p2.display();

        System.out.println("\nCreating Person 3");
        ConstructorChaining p3 = new ConstructorChaining("Charlie", 16);
        p3.display();

        System.out.println("\nCreating Person 4");
        ConstructorChaining p4 = new ConstructorChaining("David");
        p4.display();

        System.out.println("\nCreating Person 5");
        ConstructorChaining p5 = new ConstructorChaining();
        p5.display();
    }
}
