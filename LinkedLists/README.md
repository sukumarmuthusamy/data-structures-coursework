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

The Employee Management System is a menu driven program with the following options:

### 1. Add Employee
Prompts for:
- Employee ID  
- Name  
- Position  
- Salary  

Validations:
- Employee ID must be numeric and positive  
- Name and position must contain only alphabetic characters and spaces  
- Salary must be numeric and non negative  
- Inputs cannot be left empty  
- Employee ID must be unique in the list  

If any validation fails, a clear error message is shown and the user is re prompted.

### 2. Delete Employee
- Prompts for an Employee ID to delete.  
- Handles the following cases:
  - Deleting from an empty list  
  - Deleting the head node  
  - Deleting a middle or last node  
  - Attempting to delete a non existent ID  

For invalid or non numeric IDs, an error message is shown and the operation is safely cancelled.

### 3. Display Employees
- Traverses the linked list and prints all employee records in order.  
- If the list is empty, a user friendly message is displayed instead of printing nothing.

### 4. Exit
- Safely exits the program from the menu.  
- Prevents accidental exit by requiring the user to explicitly choose the exit option from the menu.

## Design Choices

1. **Centralised input handling**  
   Helper functions in `EmployeeManagementSystem` are used to validate and read input for menu choices, IDs, names, positions, and salary.  
   These helpers check for:
   - Empty input  
   - Special characters where not allowed  
   - Numbers in name and position  
   - Negative values for menu choice, employee ID, and salary  

2. **Custom linked list implementation**  
   A singly linked list (`EmployeeLinkedList`) is used to store `Employee` objects dynamically instead of using built in Java collections. This reinforces the core linked list concepts from the course.

3. **User friendly error messages**  
   All invalid inputs produce clear, specific messages so the user understands what went wrong and how to fix it, rather than generic errors.

4. **Edge case handling**  
   The program explicitly handles:
   - Deleting from an empty list  
   - Duplicate employee IDs  
   - Invalid or out of range menu choices  
   - Salary values that must always be positive  

5. **Encapsulation of employee data**  
   All fields in the `Employee` class are declared `private` and accessed only through methods. This ensures that employee records can be modified only through the `Employee` class, following good object oriented design.

