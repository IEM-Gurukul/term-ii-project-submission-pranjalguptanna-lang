// ============================================================
// Student.java
// Demonstrates: Abstraction, Encapsulation
// Purpose: Abstract base class for all student types.
//          - Private fields with public getters/setters (Encapsulation)
//          - Abstract calculateGrade() forces subclasses to define
//            their own grading logic (Abstraction)
//          - Marks validation using InvalidGradeException
// ============================================================

public abstract class Student {

    // Private fields — cannot be accessed directly from outside (Encapsulation)
    private String name;
    private String rollNumber;
    private double marks;

    // All-arguments constructor with marks validation
    public Student(String name, String rollNumber, double marks) throws InvalidGradeException {
        this.name = name;
        this.rollNumber = rollNumber;
        if (marks < 0 || marks > 100) {
            throw new InvalidGradeException(marks);
        }
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    // Setter for marks with validation
    public void setMarks(double marks) throws InvalidGradeException {
        if (marks < 0 || marks > 100) {
            throw new InvalidGradeException(marks);
        }
        this.marks = marks;
    }

    // Abstract method — subclasses must implement their own grading logic
    public abstract String calculateGrade();

    // Override toString for formatted student summary
    @Override
    public String toString() {
        return "Name: " + name + " | Roll Number: " + rollNumber + " | Marks: " + marks;
    }
}
