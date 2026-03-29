// ============================================================
// GradeController.java
// Demonstrates: Collections (ArrayList)
// Purpose: Controller class that manages the student records.
//          - Uses ArrayList<Student> to store all students
//          - Provides methods to add, display, and search students
//          - Leverages polymorphism — same list holds both
//            Undergraduate and Postgraduate objects
// ============================================================

import java.util.ArrayList;

public class GradeController {

    // Private ArrayList to store all students (Collections)
    private ArrayList<Student> studentList;

    // Constructor — initializes the empty list
    public GradeController() {
        studentList = new ArrayList<Student>();
    }

    // Adds a student to the list and prints confirmation
    public void addStudent(Student s) {
        studentList.add(s);
        System.out.println("Student added: " + s.getName() + " (" + s.getRollNumber() + ")");
    }

    // Displays all students with their grades
    public void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : studentList) {
            System.out.println(student.toString());
            System.out.println("Grade: " + student.calculateGrade());
            System.out.println();
        }
    }

    // Searches for a student by roll number (case-insensitive)
    public Student searchByRoll(String rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return student;
            }
        }
        return null;
    }
}
