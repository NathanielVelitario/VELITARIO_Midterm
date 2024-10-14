import java.util.Scanner;

class Person {
    private String name; // person's name
    private int age; // person's age
    public Person(String name, int age) { // Constructor to initialize Person object
        this.name = name;
        this.age = age;
    }
    public void displayInfo() { // Method to display the person's information
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    private String studentID, course; // student's ID and course
    private int units; // number of units taken
    private static final int FEE_PER_UNIT = 1000; // fee per unit
    public Student(String name, int age, String studentID, String course, int units) { // Constructor to initialize Student object
        super(name, age);
        this.studentID = studentID;
        this.course = course;
        this.units = units;
    }
    public double calculateFees() { // Method to calculate total fees for the student
        return units * FEE_PER_UNIT; // Total fee calculation
    }
    @Override
    public void displayInfo() { // Overridden method to display student information
        super.displayInfo(); // Call the displayInfo of Person class
        System.out.println("Total Fee: P" + calculateFees());
    }
}

class Instructor extends Person {
    private String employeeID, department; // instructor's ID and department
    private double salary; // instructor's salary
    public Instructor(String name, int age, String employeeID, String department, double salary) { // Constructor to initialize Instructor object
        super(name, age);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public void displayInfo() { // Overridden method to display instructor information
        super.displayInfo(); // Call the displayInfo of Person class
        System.out.println("Salary: P" + salary);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter details for the Student:");
        Student student = createStudent(scanner); // Create and get Student object
        student.displayInfo(); // Display student information
        System.out.println("\nEnter details for the Instructor:");
        Instructor instructor = createInstructor(scanner); // Create and get Instructor object
        instructor.displayInfo(); // Display instructor information
        scanner.close(); // Close the scanner resource
    }
    private static Student createStudent(Scanner scanner) { // Method to create a Student object based on user input
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Course: ");
        String course = scanner.nextLine();
        System.out.print("Units: ");
        int units = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return new Student(name, age, id, course, units); // Return new Student object
    }
    private static Instructor createInstructor(Scanner scanner) { // Method to create an Instructor object based on user input
        System.out.print("Enter Instructor Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        return new Instructor(name, age, id, department, salary); // Return new Instructor object
    }
}