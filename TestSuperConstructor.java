class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

class Student extends Person {
    private int grade;
    private String school;

    Student(String name, int age, int grade, String school) {
        super(name, age);
        this.grade = grade;
        this.school = school;
        System.out.println("Student constructor called");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade : " + grade);
        System.out.println("School: " + school);
    }

    public void study() {
        System.out.println(getName() + " is studying...");
    }
}

public class TestSuperConstructor {
    public static void main(String[] args) {

        Student s = new Student("Gaurav", 16, 10, "ABC Public School");

        System.out.println("\n--- Student Details ---");
        s.displayInfo();

        System.out.println();
        s.study();
    }
}
