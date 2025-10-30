class Person {
    String name;
    int age;

    Person(String name) {
        this.name = name;
        System.out.println("Person(String) constructor called.");
    }

    Person(String name, int age) {
        this(name);
        this.age = age;
        System.out.println("Person(String, int) constructor called.");
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    String employeeId;
    double salary;

    Employee(String name, int age, String employeeId) {
        super(name, age);
        this.employeeId = employeeId;
        System.out.println("Employee constructor (3 params) called.");
    }

    Employee(String name, int age, String employeeId, double salary) {
        this(name, age, employeeId);
        this.salary = salary;
        System.out.println("Employee constructor (4 params) called.");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: $" + salary);
    }

    void work() {
        System.out.println(name + " is working.");
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        System.out.println("--- Creating Employee ---");
        Employee emp1 = new Employee("Jane Doe", 30, "E12345", 75000.0);
        
        System.out.println("\n--- Displaying Details ---");
        emp1.displayDetails();
        
        System.out.println("\n--- Calling Method ---");
        emp1.work();
    }
}
