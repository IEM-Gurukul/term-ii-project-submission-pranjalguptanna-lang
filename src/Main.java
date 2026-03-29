// ============================================================
// Main.java
// Demonstrates: Exception Handling, Collections (via controller)
// Purpose: Entry point of the Student Grade Management System.
//          - Provides an interactive console menu (while loop + switch)
//          - Handles user input validation with try-catch
//          - Uses GradeController to manage student operations
//          - Catches InputMismatchException for non-numeric input
//          - Catches InvalidGradeException for out-of-range marks
// ============================================================

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
                        // Add Undergraduate Student
                        try {
                            System.out.print("Enter name: ");
                            String ugName = scanner.nextLine();
                            System.out.print("Enter roll number: ");
                            String ugRoll = scanner.nextLine();
                            System.out.print("Enter marks (0-100): ");
                            double ugMarks = scanner.nextDouble();
                            scanner.nextLine(); // consume newline

                            Undergraduate ug = new Undergraduate(ugName, ugRoll, ugMarks);
                            controller.addStudent(ug);
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Marks must be a number.");
                            scanner.nextLine(); // clear invalid input
                        } catch (InvalidGradeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        // Add Postgraduate Student
                        try {
                            System.out.print("Enter name: ");
                            String pgName = scanner.nextLine();
                            System.out.print("Enter roll number: ");
                            String pgRoll = scanner.nextLine();
                            System.out.print("Enter marks (0-100): ");
                            double pgMarks = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            System.out.print("Enter specialization: ");
                            String pgSpec = scanner.nextLine();

                            Postgraduate pg = new Postgraduate(pgName, pgRoll, pgMarks);
                            pg.setSpecialization(pgSpec);
                            controller.addStudent(pg);
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Marks must be a number.");
                            scanner.nextLine(); // clear invalid input
                        } catch (InvalidGradeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        // Display All Students
                        System.out.println("----------------------------------------");
                        controller.displayAll();
                        System.out.println("----------------------------------------");
                        break;
                    case 4:
                        // Search by Roll Number
                        System.out.print("Enter roll number to search: ");
                        String searchRoll = scanner.nextLine();
                        Student result = controller.searchByRoll(searchRoll);
                        if (result != null) {
                            System.out.println(result.toString());
                            System.out.println("Grade: " + result.calculateGrade());
                        } else {
                            System.out.println("No student found with roll number: " + searchRoll);
                        }
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
