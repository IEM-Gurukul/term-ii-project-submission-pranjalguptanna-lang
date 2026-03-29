// ============================================================
// InvalidGradeException.java
// Demonstrates: Exception Handling (Custom Checked Exception)
// Purpose: Thrown when student marks are outside valid range (0-100).
//          Extends Exception to make it a checked exception,
//          forcing callers to handle it with try-catch or throws.
// ============================================================

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
