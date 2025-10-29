public class ConstructorChaining {

    private String name;
    private int age;
    private String location;

    public ConstructorChaining() {
        System.out.println("1. Default constructor called.");
        this.name = "Unknown";
        this.age = 0;
        this.location = "Not specified";
    }

    public ConstructorChaining(String name) {
        this(); 
        System.out.println("2. Constructor with 'name' called.");
        this.name = name;
    }

    public ConstructorChaining(String name, int age) {
        this(name); 
        System.out.println("3. Constructor with 'name' and 'age' called.");
        this.age = age;
    }

    public ConstructorChaining(String name, int age, String location) {
        this(name, age); 
        System.out.println("4. Constructor with all parameters called.");
        this.location = location;
    }

    public void display() {
        System.out.println("--------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Location: " + this.location);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        
        System.out.println("Creating person 1 (using all parameters)...");
        ConstructorChaining person1 = new ConstructorChaining("Alice", 30, "New York");
        person1.display();

        System.out.println("\nCreating person 2 (using name and age)...");
        ConstructorChaining person2 = new ConstructorChaining("Bob", 25);
        person2.display();
        
        System.out.println("\nCreating person 3 (using only name)...");
        ConstructorChaining person3 = new ConstructorChaining("Charlie");
        person3.display();

        System.out.println("\nCreating person 4 (using default)...");
        ConstructorChaining person4 = new ConstructorChaining();
        person4.display();
    }
}

