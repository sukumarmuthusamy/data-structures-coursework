# Linked List Assignment – Employee Management System

This assignment implements a menu-driven Employee Management System using singly linked lists in Java.  
The program allows users to add, delete, and display employee records with full input validation and edge-case handling.

## Programs Included

- **Employee.java** — Defines the Employee object with ID, name, position, and salary.
- **EmployeeLinkedList.java** — Custom singly linked list with insertion, deletion, and traversal logic.
- **EmployeeManagementSystem.java** — Menu-driven main program that handles all user input and validation.

## How to Run

Compile all files:
```bash
javac Employee.java EmployeeLinkedList.java EmployeeManagementSystem.java
```

Run the main program:
```bash
java EmployeeManagementSystem
```

## Program Features

### 1. Add Employee
Prompts for:
- Employee ID  
- Name  
- Position  
- Salary  

Validations include:
- Empty inputs  
- Numeric-only names  
- Special characters in name or position  
- Duplicate employee IDs  
- Negative salary or ID values  

### 2. Delete Employee
- Deletes an employee using their ID.  
- Handles deleting from an empty list, deleting the head node, and invalid IDs safely.

### 3. Display Employees
- Traverses and prints all employee records in the linked list in insertion order.

## Design Choices
- Input validation implemented using helper functions.  
- Encapsulation enforced by keeping Employee fields private.  
- Duplicate ID checks maintain data consistency.  
- Salary is always validated to be a positive number.

## Challenges Faced
- Validating names and positions to prevent numeric or special-character input.  
- Ensuring deletion logic works correctly for head, middle, and non-existent nodes.  
- Scanner buffer issues that required code adjustments.  
- Handling invalid menu options cleanly.

## Possible Improvements
- Display employees in a well-formatted tabular layout.  
- Add a confirmation prompt before deletions.  
- Reduce repetitive validation logic.  
- Improve traversal efficiency for larger lists.
