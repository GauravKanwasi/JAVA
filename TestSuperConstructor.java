
class Person {
    String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person constructor called");
    }
}

class Student extends Person {
    int grade;

    Student(String name, int grade) {

        super(name);
        this.grade = grade;
        System.out.println("Student constructor called");
    }

    void showDetails() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }
}

public class TestSuperConstructor {
    public static void main(String[] args) {
        Student s = new Student("Gaurav", 10);
        s.showDetails();
    }
}
