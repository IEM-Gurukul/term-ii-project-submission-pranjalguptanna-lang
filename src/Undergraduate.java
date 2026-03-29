// ============================================================
// Undergraduate.java
// Demonstrates: Inheritance, Polymorphism
// Purpose: Concrete subclass of Student for undergraduate students.
//          - Inherits all fields and methods from Student (Inheritance)
//          - Implements calculateGrade() with undergraduate-specific
//            grading thresholds (Polymorphism)
// Grading: A (75+), B (60-74), C (50-59), D (40-49), F (below 40)
// ============================================================

public class Undergraduate extends Student {

    // Constructor that calls the parent Student constructor
    public Undergraduate(String name, String rollNumber, double marks) throws InvalidGradeException {
        super(name, rollNumber, marks);
    }

    // Implementing abstract method with undergraduate grading rules
    @Override
    public String calculateGrade() {
        double marks = getMarks();

        if (marks >= 75) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F (Fail)";
        }
    }

    // Override toString to prepend [Undergraduate] to parent's output
    @Override
    public String toString() {
        return "[Undergraduate] " + super.toString();
    }
}
