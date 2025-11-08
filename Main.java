class Person {
    String name;
    int age;

    Person() {
        this("Unknown", 0);
        System.out.println("Default Person constructor");
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor: " + this.name + ", " + this.age);
    }

    void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    String course;

    Student() {
        this("Unnamed", 18, "None");
        System.out.println("Default Student constructor");
    }

    Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
        System.out.println("Student constructor: " + this.course);
    }

    void showInfo() {
        super.showInfo();
        System.out.println("Course: " + course);
    }

    void display() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Parent Name using super: " + super.name);
        this.showInfo();
        super.showInfo();
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Gaurav", 21, "Computer Science");
        s.display();
    }
}
