import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeController controller = new GradeController();

        while (true) {
            // Display the menu
            System.out.println("========================================");
            System.out.println("   STUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("  1. Add Undergraduate Student");
            System.out.println("  2. Add Postgraduate Student");
            System.out.println("  3. Display All Students");
            System.out.println("  4. Search by Roll Number");
            System.out.println("  5. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline

                switch (choice) {
                    case 1:
                        System.out.println("Feature coming in next task...");
                        break;
                    case 2:
                        System.out.println("Feature coming in next task...");
                        break;
                    case 3:
                        System.out.println("Feature coming in next task...");
                        break;
                    case 4:
                        System.out.println("Feature coming in next task...");
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number (1-5).");
                scanner.nextLine(); // clear the invalid input from scanner
            }

            System.out.println(); // blank line before next menu display
        }
    }
}
