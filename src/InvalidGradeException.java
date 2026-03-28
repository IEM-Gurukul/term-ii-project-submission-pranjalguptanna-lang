public class InvalidGradeException extends Exception {

    // Constructor that accepts a custom error message
    public InvalidGradeException(String message) {
        super(message);
    }

    // Constructor that accepts invalid marks and builds a descriptive message
    public InvalidGradeException(double marks) {
        super("Invalid marks: " + marks + ". Marks must be between 0 and 100.");
    }
}
