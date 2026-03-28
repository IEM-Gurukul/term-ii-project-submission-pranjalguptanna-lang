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
