import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentCourseRegistrationSystem {
    private Map<String, Course> courseDatabase;
    private Map<String, Student> studentDatabase;

    public StudentCourseRegistrationSystem() {
        courseDatabase = new HashMap<>();
        studentDatabase = new HashMap<>();
    }

    public void addCourse(Course course) {
        courseDatabase.put(course.getCode(), course);
    }

    public void addStudent(Student student) {
        studentDatabase.put(student.getStudentID(), student);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            int availableSlots = course.getCapacity() - course.getRegisteredStudents().size();
            System.out.println(course.getCode() + " - " + course.getTitle() + " (" + availableSlots + " slots available)");
        }
    }

    public void registerStudentForCourse(String studentID, String courseCode) {
        Student student = studentDatabase.get(studentID);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            if (course.registerStudent(student.getName())) {
                student.registerCourse(courseCode);
                System.out.println("Registration successful.");
            } else {
                System.out.println("Registration failed. Course is full.");
            }
        } else {
            System.out.println("Invalid student or course.");
        }
    }

    public void removeStudentFromCourse(String studentID, String courseCode) {
        Student student = studentDatabase.get(studentID);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            course.removeStudent(student.getName());
            student.dropCourse(courseCode);
            System.out.println("Course removal successful.");
        } else {
            System.out.println("Invalid student or course.");
        }
    }

    public static void main(String[] args) {
        StudentCourseRegistrationSystem registrationSystem = new StudentCourseRegistrationSystem();

        Course course1 = new Course("CSCI101", "Introduction to Computer Science", "Fundamentals of programming", 30, List.of("Mon, Wed 10:00 AM"));
        Course course2 = new Course("QM201", "Quanrum Mechanics I", "Fundamental Quantum Mechanical Concepts", 25, List.of("Tue, Thu 2:00 PM"));
        Course course3 = new Course("EMT101", "Electromagnetic Theory", "Electromagnetic Theory fundamentals", 20, List.of("Tue, Thu 10:00 AM"));

        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);
        registrationSystem.addCourse(course3);

        Student student1 = new Student("12345", "Alice");
        Student student2 = new Student("67890", "Bob");

        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Course Registration System Menu:");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Remove from Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    registrationSystem.displayAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter the course code to register: ");
                    String courseCodeToRegister = scanner.nextLine();
                    registrationSystem.registerStudentForCourse(studentID, courseCodeToRegister);
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    String studentIDToRemove = scanner.nextLine();
                    System.out.print("Enter the course code to remove: ");
                    String courseCodeToRemove = scanner.nextLine();
                    registrationSystem.removeStudentFromCourse(studentIDToRemove, courseCodeToRemove);
                    break;
                case 4:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<String> schedule;
    private List<String> registeredStudents;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public List<String> getRegisteredStudents() {
        return registeredStudents;
    }

    public boolean registerStudent(String studentName) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(studentName);
            return true;
        }
        return false;
    }

    public void removeStudent(String studentName) {
        registeredStudents.remove(studentName);
    }
}

class Student {
    private String studentID;
    private String name;
    private List<String> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}