# Student Performance Analyzer

A console-based Java application for managing and analyzing student academic performance. The application allows users to add multiple students, store their marks, calculate performance metrics, search and rank students, perform subject-wise analysis, and persist student records using a CSV file.

## 📌 Project Overview

The **Student Performance Analyzer** is designed to demonstrate core Java programming concepts through a practical application.

Instead of analyzing only a single student's marks, the application maintains records for multiple students using Java's `ArrayList` and provides several analysis features.

Student records are also stored in a CSV file, allowing the data to persist even after the program is closed.

The project follows a modular structure where different classes are responsible for different parts of the application, such as student data, analysis, validation, student management, and file handling.

---

## ✨ Features

### 1. Add Student

Allows the user to add a new student by entering:

* Student name
* Marks for 5 subjects

The application validates the entered marks before storing the student.

Marks must be between **0 and 100**.

Duplicate student names are also detected and rejected.

---

### 2. View Students

Displays the stored student records along with their performance information:

* Student name
* Total marks
* Average marks
* Percentage
* Highest marks
* Lowest marks
* Grade

---

### 3. Search Student

Allows the user to search for a student by name.

The search is case-insensitive, so names such as:

```text
Rahul
rahul
RAHUL
```

are treated as the same name.

---

### 4. Find Topper

Analyzes all stored students and identifies the student with the highest total performance.

The topper's:

* Name
* Total marks
* Percentage

are displayed.

---

### 5. Class Average

Calculates the average percentage of all students currently stored in the system.

This provides an overall view of the class performance.

---

### 6. Student Rankings

Students are sorted according to their performance percentage and displayed in ranking order.

Example:

```text
----- Student Rankings -----

1. Rahul - 92.0%
2. Ankit - 87.0%
3. Rohan - 76.0%
```

Java's `Comparator` is used to perform the sorting.

---

### 7. Subject Analysis

Calculates the average marks obtained by the class in each subject.

Example:

```text
----- Subject Analysis -----

Subject 1 Average: 78.5
Subject 2 Average: 82.0
Subject 3 Average: 74.5
Subject 4 Average: 85.0
Subject 5 Average: 79.5
```

This can help identify subjects in which the class performs relatively better or worse.

---

### 8. Input Validation

The application handles invalid mark inputs using exception handling.

Examples of invalid input:

```text
-10
105
abc
```

Instead of terminating the program, the application asks the user to enter a valid value.

---

### 9. CSV Data Persistence

Student records are stored in:

```text
students.csv
```

When a student is added, their information is written to the CSV file.

When the application starts, previously saved records are loaded back into the program.

This means student data is not lost when the program is closed.

---

### 10. Invalid CSV Handling

The application also checks for empty or malformed CSV records while loading data.

Invalid records are skipped instead of causing the entire program to terminate.

---

## 🛠️ Technologies Used

* **Java**
* **Java Collections Framework**
* **ArrayList**
* **Comparator**
* **Exception Handling**
* **File I/O**
* **CSV**
* **Object-Oriented Programming**

### Java APIs Used

Some of the important Java classes used in the project include:

```text
java.util.Scanner
java.util.ArrayList
java.util.Comparator
java.util.InputMismatchException
java.io.FileWriter
java.io.FileReader
java.io.BufferedReader
java.io.IOException
```

---

## 📂 Project Structure

```text
Student Performance Analyzer/
│
├── Main.java
├── Student.java
├── StudentManager.java
├── PerformanceAnalyzer.java
├── InputValidator.java
├── FileManager.java
└── students.csv
```

### Main.java

The entry point of the application.

Responsibilities:

* Display the main menu
* Accept user input
* Control program flow
* Call appropriate methods from other classes

---

### Student.java

Represents a student object.

It stores:

* Student name
* Marks for the five subjects

The class acts as the data model for the application.

---

### StudentManager.java

Responsible for managing multiple student objects.

It uses an `ArrayList<Student>` to store the students.

Responsibilities include:

* Adding students
* Viewing students
* Searching students
* Finding the topper
* Calculating class average
* Ranking students
* Subject analysis
* Checking for duplicate students

---

### PerformanceAnalyzer.java

Contains the academic calculation logic.

Responsibilities include:

* Calculating total marks
* Calculating average marks
* Calculating percentage
* Finding highest marks
* Finding lowest marks
* Calculating grades

Keeping these calculations in a separate class makes the application more modular and easier to maintain.

---

### InputValidator.java

Handles validation of student marks.

It uses exception handling to prevent invalid input from crashing the application.

It ensures that marks:

* Are valid numbers
* Are between 0 and 100

---

### FileManager.java

Responsible for file operations.

It handles:

* Saving student records to `students.csv`
* Loading student records when the program starts
* Handling file-related exceptions
* Skipping malformed CSV records

---

### students.csv

Stores student information permanently.

A typical record contains:

```text
Name,Subject1,Subject2,Subject3,Subject4,Subject5,Percentage,Grade
```

For example:

```text
Rahul,85,90,78,88,92,86.6,A
```

---

## 🔄 Application Flow

The general application flow is:

```text
Start Program
      ↓
Create StudentManager
      ↓
Load existing students from CSV
      ↓
Display Main Menu
      ↓
User selects an operation
      ↓
┌──────────────────────────────┐
│ 1. Add Student               │
│ 2. View Students             │
│ 3. Search Student            │
│ 4. Find Topper               │
│ 5. Class Average             │
│ 6. Student Rankings          │
│ 7. Subject Analysis          │
│ 8. Exit                      │
└──────────────────────────────┘
      ↓
Perform selected operation
      ↓
Return to Menu
      ↓
Exit
```

---

## 📊 Grading System

The application currently uses the following grading criteria:

| Percentage | Grade |
| ---------: | :---: |
|     90–100 |   A   |
|      80–89 |   B   |
|      70–79 |   C   |
|      60–69 |   D   |
|   Below 60 |   F   |

---

## 💾 Data Persistence

The application uses two layers for student storage:

### In-memory storage

During program execution, students are stored in:

```java
ArrayList<Student>
```

This provides convenient access to student objects while the program is running.

### Permanent storage

Student records are also stored in:

```text
students.csv
```

When the program is restarted:

```text
students.csv
      ↓
FileManager.loadStudents()
      ↓
Student objects
      ↓
StudentManager
      ↓
Application
```

Therefore, previously entered student records can be recovered after restarting the application.

---

## ⚠️ Input Validation

The program uses exception handling to deal with invalid numerical input.

For example, if the user enters:

```text
Subject 1: abc
```

the application catches the input mismatch and asks the user to enter a valid number.

Similarly, marks outside the allowed range are rejected:

```text
Subject 1: 120

Marks must be between 0 and 100.
```

---

## 🧠 Core Java Concepts Demonstrated

This project demonstrates several important Java concepts:

### Object-Oriented Programming

The application uses separate classes to represent different responsibilities.

```text
Student
StudentManager
PerformanceAnalyzer
FileManager
InputValidator
```

This demonstrates modular programming and separation of responsibilities.

### Arrays

Each student's five subject marks are stored in an integer array:

```java
int[] marks;
```

### ArrayList

Multiple students are stored dynamically using:

```java
ArrayList<Student>
```

Unlike a fixed-size array, an `ArrayList` can grow as students are added.

### Methods

The project uses methods to divide functionality into smaller reusable operations.

Examples:

```java
calculateTotal()
calculateAverage()
calculatePercentage()
findHighest()
findLowest()
calculateGrade()
```

### Exception Handling

The project uses `try-catch` blocks to handle invalid input and file-related errors.

### File I/O

Java file handling is used to save and retrieve student information.

### Sorting

`Comparator<Student>` is used to sort students according to their performance.

### String Operations

Student searching uses case-insensitive string comparison:

```java
equalsIgnoreCase()
```

---

## ▶️ How to Run

### Prerequisites

Install the Java Development Kit (JDK).

Verify the installation:

```bash
java -version
```

and:

```bash
javac -version
```

---

### Clone the Repository

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
```

Navigate into the project directory:

```bash
cd "Student Performance Analyzer"
```

---

### Compile the Program

Compile all Java files:

```bash
javac *.java
```

---

### Run the Program

```bash
java Main
```

The application will display the main menu.

---

## 🖥️ Example Usage

```text
===== Student Performance Analyzer =====

1. Add Student
2. View Students
3. Search Student
4. Find Topper
5. Class Average
6. Student Rankings
7. Subject Analysis
8. Exit

Enter your choice: 1

Enter student name: Rahul

Enter marks for 5 subjects:
Subject 1: 85
Subject 2: 90
Subject 3: 78
Subject 4: 88
Subject 5: 92

Student added successfully.
```

The student record is then stored in memory and saved to `students.csv`.

---

## 🎯 Project Objectives

The main objectives of this project are:

* To apply Java programming concepts to a practical problem
* To understand object-oriented program structure
* To work with arrays and collections
* To implement input validation
* To use exception handling
* To implement file input/output
* To understand CSV-based data persistence
* To implement searching and sorting
* To practice modular and maintainable code

---

## 🚀 Possible Future Improvements

The current version provides the core functionality required for a student performance management system.

Possible future improvements include:

* Add unique student IDs
* Allow a variable number of subjects
* Add student record editing and deletion
* Improve CSV parsing for names containing commas
* Add subject names instead of generic subject numbers
* Export detailed performance reports
* Add graphical user interface (GUI)
* Add database support using MySQL or SQLite
* Add unit testing
* Add authentication for different users

These features are not required for the current version but could be implemented as future extensions.

---

## 📚 Learning Outcomes

Through this project, the following concepts were practically implemented:

* Java syntax and control flow
* Classes and objects
* Constructors
* Arrays
* ArrayList
* Methods
* String manipulation
* Exception handling
* File handling
* CSV data storage
* Collections and sorting
* Modular program design

The project demonstrates how individual Java concepts can be combined to build a complete console-based application.

---

## 👨‍💻 Author

**Abhinav Patil**

CSE (AI/ML)

---

## 📄 License

This project is intended for educational and academic purposes.

