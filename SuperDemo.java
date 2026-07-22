class Person {
    protected String name;
    protected int age;
    private static int personCount = 0;

    Person(String name) {
        this.name = name;
        personCount++;
        System.out.println("Person(String) constructor called.");
    }

    Person(String name, int age) {
        this(name);
        this.age = age;
        System.out.println("Person(String, int) constructor called.");
    }

    void displayDetails() {
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
    }

    void introduce() {
        System.out.println("Hello, I am " + name + ".");
    }

    static void showPersonCount() {
        System.out.println("Total Persons Created: " + personCount);
    }
}

class Employee extends Person {
    protected String employeeId;
    protected double salary;
    protected String department;

    Employee(String name, int age, String employeeId) {
        super(name, age);
        this.employeeId = employeeId;
        System.out.println("Employee(3 params) constructor called.");
    }

    Employee(String name, int age, String employeeId, double salary) {
        this(name, age, employeeId);
        this.salary = salary;
        System.out.println("Employee(4 params) constructor called.");
    }

    Employee(String name, int age, String employeeId, double salary, String department) {
        this(name, age, employeeId, salary);
        this.department = department;
        System.out.println("Employee(5 params) constructor called.");
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Department  : " + department);
        System.out.printf("Salary      : $%.2f%n", salary);
    }

    @Override
    void introduce() {
        System.out.println("Hi, I'm " + name + " from " + department + " department.");
    }

    void work() {
        System.out.println(name + " is working on assigned tasks.");
    }

    void increaseSalary(double percentage) {
        salary += salary * percentage / 100;
        System.out.printf("Salary increased by %.2f%%. New Salary: $%.2f%n", percentage, salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    Manager(String name, int age, String employeeId, double salary,
            String department, int teamSize) {
        super(name, age, employeeId, salary, department);
        this.teamSize = teamSize;
        System.out.println("Manager constructor called.");
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size   : " + teamSize);
    }

    @Override
    void work() {
        System.out.println(name + " is managing a team of " + teamSize + " employees.");
    }

    void conductMeeting() {
        System.out.println(name + " is conducting a project meeting.");
    }
}

public class SuperDemo {
    public static void main(String[] args) {

        System.out.println("===== Creating Employee =====");
        Employee emp = new Employee(
                "Jane Doe",
                30,
                "E12345",
                75000,
                "Software Development"
        );

        System.out.println("\n===== Employee Details =====");
        emp.displayDetails();

        System.out.println("\n===== Employee Actions =====");
        emp.introduce();
        emp.work();
        emp.increaseSalary(10);

        System.out.println("\n===== Polymorphism =====");
        Person person = new Employee(
                "John Smith",
                28,
                "E54321",
                60000,
                "Quality Assurance"
        );
        person.introduce();
        person.displayDetails();

        System.out.println("\n===== Creating Manager =====");
        Manager manager = new Manager(
                "Alice Johnson",
                40,
                "M1001",
                120000,
                "Engineering",
                15
        );

        System.out.println("\n===== Manager Details =====");
        manager.displayDetails();

        System.out.println("\n===== Manager Actions =====");
        manager.work();
        manager.conductMeeting();

        System.out.println("\n===== Statistics =====");
        Person.showPersonCount();
    }
}
