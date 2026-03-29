[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
Student Grade Management System

---

## Problem Statement (max 150 words)
Students and academic administrators need a reliable system to manage student records and calculate grades efficiently. Manual grade calculation is error-prone and time-consuming. This project implements a console-based Student Grade Management System in Java that allows users to add undergraduate and postgraduate students, automatically calculate grades based on predefined grading scales, display all student records, and search for students by roll number. The system enforces strict input validation using custom exceptions to ensure data integrity, preventing invalid marks from being entered. It supports two distinct grading scales — a standard scale for undergraduates and a stricter scale for postgraduates — demonstrating real-world polymorphic behavior.

---

## Target User
Academic administrators, faculty members, and students who need a simple, reliable tool to manage student records and calculate grades based on different academic levels.

---

## Core Features

- Add Undergraduate and Postgraduate students with validated marks input
- Automatic grade calculation using level-specific grading scales (standard for UG, stricter for PG)
- Display all student records with grades and search by roll number (case-insensitive)

---

## OOP Concepts Used

- Abstraction: `Student` is an abstract class with abstract method `calculateGrade()` — defines a blueprint without implementation.
- Inheritance: `Undergraduate` and `Postgraduate` extend `Student`, reusing fields, constructors, and methods.
- Polymorphism: `calculateGrade()` and `toString()` behave differently in each subclass — Java picks the correct version at runtime.
- Exception Handling: Custom `InvalidGradeException` (checked exception) validates marks in constructor and setter. `InputMismatchException` handles non-numeric input.
- Collections: `ArrayList<Student>` in `GradeController` stores both student types in a single dynamic list.

---

## Proposed Architecture Description

```
InvalidGradeException.java     ← Custom checked exception for invalid marks
         ↓ (used by)
Student.java (abstract)        ← Base class with private fields, getters/setters, abstract calculateGrade()
       ↙        ↘
Undergraduate.java  Postgraduate.java   ← Concrete subclasses with different grading rules
       ↘        ↙
GradeController.java           ← Manages ArrayList<Student>, provides add/display/search
         ↑ (used by)
Main.java                      ← Entry point with interactive console menu (while + switch)
```

### File Structure
```
src/
├── InvalidGradeException.java   # Custom checked exception
├── Student.java                 # Abstract base class
├── Undergraduate.java           # Subclass (Inheritance + Polymorphism)
├── Postgraduate.java            # Subclass (Inheritance + Polymorphism)
├── GradeController.java         # Collections + business logic
└── Main.java                    # Entry point + console UI
```

---

## How to Run

1. Make sure Java (JDK) is installed on your system.
2. Open a terminal and navigate to the project root folder.
3. Compile all Java files:
   ```bash
   javac src/*.java
   ```
4. Run the program:
   ```bash
   java -cp src Main
   ```
5. Or compile and run in one command:
   ```bash
   javac src/*.java && java -cp src Main
   ```

---

## Git Discipline Notes
Minimum 10 meaningful commits required.
