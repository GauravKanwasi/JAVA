class Person {
    protected String name;
    protected int age;
    private static int count = 0;

    Person() {
        this("Unknown", 0);
        System.out.println("Default Person Constructor");
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
        System.out.println("Person Constructor -> " + name + ", " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0)
            this.age = age;
    }

    static void showCount() {
        System.out.println("Total Persons Created: " + count);
    }

    final void greet() {
        System.out.println("Welcome " + name + "!");
    }

    void showInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    private String course;
    private double cgpa;

    Student() {
        this("Unknown", 18, "None", 0.0);
        System.out.println("Default Student Constructor");
    }

    Student(String name, int age, String course, double cgpa) {
        super(name, age);
        this.course = course;
        this.cgpa = cgpa;
        System.out.println("Student Constructor -> " + course);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        if (cgpa >= 0 && cgpa <= 10)
            this.cgpa = cgpa;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("Course : " + course);
        System.out.println("CGPA   : " + cgpa);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age +
               ", course='" + course + "', cgpa=" + cgpa + "}";
    }

    void display() {
        System.out.println("\n----- Display -----");
        System.out.println("this.name  : " + this.name);
        System.out.println("super.name : " + super.name);

        System.out.println("\nCalling Overridden Method");
        this.showInfo();

        System.out.println("\nCalling Parent Method");
        super.showInfo();

        System.out.println("\nCalling Final Method");
        super.greet();

        System.out.println("\nUsing toString()");
        System.out.println(this);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Gaurav", 21, "Computer Science", 9.25);

        System.out.println();
        s1.display();

        System.out.println("\nUpdating Details");
        s1.setAge(22);
        s1.setCgpa(9.50);
        s1.showInfo();

        System.out.println();

        Student s2 = new Student();

        System.out.println();
        Person.showCount();
    }
}
