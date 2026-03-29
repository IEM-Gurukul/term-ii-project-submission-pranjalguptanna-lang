# Student Grade Management System
## PCCCS495 – Term II Project Report

---

## 1. Introduction

The Student Grade Management System is a console-based Java application designed to manage student academic records. It allows users to add undergraduate and postgraduate students, automatically calculate grades based on predefined grading scales, display all student records, and search for specific students by roll number.

The project is built using core Object-Oriented Programming (OOP) principles including Abstraction, Encapsulation, Inheritance, Polymorphism, Exception Handling, and Java Collections.

---

## 2. Problem Statement

Manual grade calculation and student record management is error-prone and inefficient. Academic institutions need a structured system that:
- Stores student information securely
- Validates input data to prevent errors
- Calculates grades automatically based on academic level
- Allows quick searching and retrieval of student records

This project addresses these needs through a well-structured Java OOP application.

---

## 3. Objectives

1. Design an abstract class hierarchy to represent different types of students.
2. Implement custom exception handling for input validation.
3. Use Java Collections to manage dynamic lists of student records.
4. Demonstrate polymorphic behavior through different grading scales.
5. Build an interactive console-based user interface.

---

## 4. System Architecture

### 4.1 Class Hierarchy

```
InvalidGradeException (extends Exception)
         ↓ used by
Student (abstract class)
       ↙        ↘
Undergraduate    Postgraduate
       ↘        ↙
    GradeController (uses ArrayList<Student>)
         ↑ used by
       Main (entry point)
```

### 4.2 File Structure

| File | Purpose | OOP Concept |
|------|---------|-------------|
| `InvalidGradeException.java` | Custom checked exception for invalid marks (0-100) | Exception Handling |
| `Student.java` | Abstract base class with private fields, getters/setters, and abstract `calculateGrade()` | Abstraction, Encapsulation |
| `Undergraduate.java` | Concrete subclass with standard grading rules | Inheritance, Polymorphism |
| `Postgraduate.java` | Concrete subclass with stricter grading rules and specialization field | Inheritance, Polymorphism |
| `GradeController.java` | Controller class with `ArrayList<Student>` for managing student records | Collections |
| `Main.java` | Entry point with interactive console menu and input validation | Exception Handling |

---

## 5. Detailed Class Descriptions

### 5.1 InvalidGradeException.java

- **Extends:** `Exception` (checked exception)
- **Purpose:** Thrown when student marks are outside the valid range (0–100)
- **Constructors:**
  - `InvalidGradeException(String message)` — accepts a custom error message
  - `InvalidGradeException(double marks)` — auto-generates a descriptive message like `"Invalid marks: 105.0. Marks must be between 0 and 100."`

### 5.2 Student.java (Abstract)

- **Type:** Abstract class — cannot be instantiated directly
- **Private Fields:** `name` (String), `rollNumber` (String), `marks` (double)
- **Constructor:** Validates marks using `InvalidGradeException` before assignment
- **Getters/Setters:** Public access methods for all fields; `setMarks()` also validates
- **Abstract Method:** `calculateGrade()` — must be implemented by subclasses
- **toString():** Returns formatted string: `Name: ___ | Roll Number: ___ | Marks: ___`

### 5.3 Undergraduate.java

- **Extends:** `Student`
- **Constructor:** Calls `super(name, rollNumber, marks)` to reuse parent validation
- **calculateGrade():** Implements undergraduate grading scale:

| Marks Range | Grade |
|-------------|-------|
| 75 – 100 | A |
| 60 – 74 | B |
| 50 – 59 | C |
| 40 – 49 | D |
| Below 40 | F (Fail) |

- **toString():** Prepends `[Undergraduate]` to parent's output

### 5.4 Postgraduate.java

- **Extends:** `Student`
- **Extra Field:** `specialization` (String) with getter and setter
- **Constructor:** Calls `super(name, rollNumber, marks)`
- **calculateGrade():** Implements stricter postgraduate grading scale:

| Marks Range | Grade |
|-------------|-------|
| 80 – 100 | A+ |
| 70 – 79 | A |
| 60 – 69 | B |
| 50 – 59 | C |
| Below 50 | F (Fail) |

- **toString():** Prepends `[Postgraduate]` and appends specialization

### 5.5 GradeController.java

- **Fields:** `private ArrayList<Student> studentList`
- **Methods:**
  - `addStudent(Student s)` — adds student to list, prints confirmation
  - `displayAll()` — iterates and prints all students with grades; handles empty list
  - `searchByRoll(String rollNumber)` — case-insensitive search, returns `Student` or `null`

### 5.6 Main.java

- **Imports:** `java.util.Scanner`, `java.util.InputMismatchException`
- **Menu Options:**
  1. Add Undergraduate Student
  2. Add Postgraduate Student
  3. Display All Students
  4. Search by Roll Number
  5. Exit
- **Input Validation:**
  - `try-catch(InputMismatchException)` for non-numeric input
  - `try-catch(InvalidGradeException)` for out-of-range marks

---

## 6. OOP Concepts Demonstrated

### 6.1 Abstraction
- `Student` is declared as `abstract` — it defines the structure but cannot be instantiated.
- `calculateGrade()` is an abstract method — it has no body in `Student` but forces all subclasses to provide their own implementation.

### 6.2 Encapsulation
- All fields in `Student` (`name`, `rollNumber`, `marks`) are `private`.
- Access is only through public **getters** and **setters**.
- `setMarks()` includes validation logic — external code cannot set invalid values.
- `specialization` in `Postgraduate` is also `private` with getter/setter.

### 6.3 Inheritance
- `Undergraduate extends Student` — inherits all fields, methods, and validation.
- `Postgraduate extends Student` — same inheritance, plus adds its own `specialization` field.
- Constructors use `super()` to call the parent's constructor.

### 6.4 Polymorphism
- `calculateGrade()` has different implementations in `Undergraduate` (standard) and `Postgraduate` (stricter).
- When calling `student.calculateGrade()` on an `ArrayList<Student>`, Java automatically picks the correct version based on the actual object type at runtime.
- `toString()` is also overridden differently in each subclass.

### 6.5 Exception Handling
- `InvalidGradeException` extends `Exception` (checked exception).
- Thrown in `Student` constructor and `setMarks()` when marks < 0 or > 100.
- Caught in `Main.java` with `try-catch` blocks.
- `InputMismatchException` caught when user enters text instead of numbers.

### 6.6 Collections
- `ArrayList<Student>` in `GradeController` stores all student records.
- Supports dynamic sizing — no fixed limit on number of students.
- Holds both `Undergraduate` and `Postgraduate` objects (polymorphic list).

---

## 7. Sample Output

### Adding Students
```
========================================
   STUDENT GRADE MANAGEMENT SYSTEM
========================================
  1. Add Undergraduate Student
  2. Add Postgraduate Student
  3. Display All Students
  4. Search by Roll Number
  5. Exit
----------------------------------------
Enter your choice: 1
Enter name: Pranjal Gupta
Enter roll number: UG001
Enter marks (0-100): 85
Student added: Pranjal Gupta (UG001)
```

### Display All Students
```
Enter your choice: 3
----------------------------------------
[Undergraduate] Name: Pranjal Gupta | Roll Number: UG001 | Marks: 85.0
Grade: A

[Postgraduate] Name: Neha Verma | Roll Number: PG001 | Marks: 92.0 | Specialization: Artificial Intelligence
Grade: A+
----------------------------------------
```

### Search by Roll Number
```
Enter your choice: 4
Enter roll number to search: pg001
[Postgraduate] Name: Neha Verma | Roll Number: PG001 | Marks: 92.0 | Specialization: Artificial Intelligence
Grade: A+
```

### Error Handling — Invalid Marks
```
Enter your choice: 1
Enter name: Test
Enter roll number: T001
Enter marks (0-100): 105
Error: Invalid marks: 105.0. Marks must be between 0 and 100.
```

### Error Handling — Non-Numeric Input
```
Enter your choice: 1
Enter name: Test
Enter roll number: T002
Enter marks (0-100): hello
Error: Marks must be a number.
```

---

## 8. Testing & Edge Cases

| Test Case | Input | Expected Result | Status |
|-----------|-------|-----------------|--------|
| Valid boundary (lower) | Marks = 0 | Student added, Grade: F (Fail) | ✅ Pass |
| Valid boundary (upper) | Marks = 100 | Student added, Grade: A | ✅ Pass |
| Invalid (below range) | Marks = -1 | InvalidGradeException thrown | ✅ Pass |
| Invalid (above range) | Marks = 101 | InvalidGradeException thrown | ✅ Pass |
| Non-numeric input | Marks = "hello" | InputMismatchException caught | ✅ Pass |
| Search existing roll | Roll = "UG001" | Student details displayed | ✅ Pass |
| Search case-insensitive | Roll = "ug001" | Same student found | ✅ Pass |
| Search non-existent | Roll = "XYZ999" | "No student found" message | ✅ Pass |
| Display empty list | Option 3 (no students) | "No students found." | ✅ Pass |
| Exit | Option 5 | "Goodbye!" — clean exit | ✅ Pass |

---

## 9. How to Run

### Prerequisites
- Java Development Kit (JDK) installed

### Steps
1. Open a terminal and navigate to the project root folder.
2. Compile all Java files:
   ```bash
   javac src/*.java
   ```
3. Run the program:
   ```bash
   java -cp src Main
   ```

---

## 10. Conclusion

The Student Grade Management System successfully demonstrates all core OOP concepts required for the Term II project. The application is robust, handles all edge cases gracefully, and provides a clean, interactive user experience through the console. The use of abstraction, inheritance, polymorphism, encapsulation, exception handling, and collections ensures the codebase is well-structured, maintainable, and extensible for future enhancements.

---
