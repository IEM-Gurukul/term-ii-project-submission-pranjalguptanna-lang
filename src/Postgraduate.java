public class Postgraduate extends Student {

    // Extra private field for postgraduate specialization
    private String specialization;

    // Constructor that calls the parent Student constructor
    public Postgraduate(String name, String rollNumber, double marks) throws InvalidGradeException {
        super(name, rollNumber, marks);
    }

    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Implementing abstract method with postgraduate grading rules (stricter)
    @Override
    public String calculateGrade() {
        double marks = getMarks();

        if (marks >= 80) {
            return "A+";
        } else if (marks >= 70) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F (Fail)";
        }
    }

    // Override toString to prepend [Postgraduate] and include specialization
    @Override
    public String toString() {
        return "[Postgraduate] " + super.toString() + " | Specialization: " + specialization;
    }
}
