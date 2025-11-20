// EmployeeLinkedList Class
public class EmployeeLinkedList {
    // Node Class
    private static class Node {
        Employee data; // This stores the employee details
        Node next; // Points to the next node in the list

        // Constructor for Node
        Node(Employee data) {
            this.data = data; // Initialize the Node with Employee data
        }
    }

    private Node head; // This points to the first node in the linked list

    // Method to check if an employee ID is unique or not
    public boolean isEmployeeIDUnique(int employeeID) {
        Node current = head; // Starting at the head of the linked list
        while (current != null) { // Traversing through the list
            if (current.data.getEmployeeID() == employeeID) { // Compare with the existing IDs
                return false; // Duplicate ID is found, so return false.
            }
            current = current.next; // Moving to the next node
        }
        return true; // If the ID is unique, return true.
    }

    // Adding a new employee to the linked list
    public void addEmployee(Employee emp) {
        if (head == null) { // Condition to check if the list is empty
            head = new Node(emp); // To set the first node as the head
            System.out.println("Employee added successfully (Employee ID: " + emp.getEmployeeID() + ", Name: " + emp.getName() + ", Position: " + emp.getPosition() + ", Salary: " + emp.getSalary() + ").");
            return;
        }

        Node current = head;
        // Traversing the list to reach the last node
        while (current.next != null) { // Loop until the last node
            current = current.next;
        }

        // Adding the new employee as a new node
        current.next = new Node(emp);
        System.out.println("Employee added successfully (Employee ID: " + emp.getEmployeeID() + ", Name: " + emp.getName() + ", Position: " + emp.getPosition() + ", Salary: " + emp.getSalary() + ").");
    }

    // Deleting an employee by their ID
    public void deleteEmployee(int employeeID) {
        if (head == null) { // Condition to check if the list is empty
            System.out.println("Error: No employees to delete.");
            return;
        }

        if (head.data.getEmployeeID() == employeeID) { // Condition to check if the employee is present in the first node
            System.out.println("Employee deleted successfully (Employee ID: " + head.data.getEmployeeID() + ", Name: " + head.data.getName() + ", Position: " + head.data.getPosition() + ", Salary: " + head.data.getSalary() + ").");
            head = head.next; // Since the head is deleted, moving the head to the next node
            return;
        }

        Node current = head;
        // Traversing the list to find the node before the target node
        while (current.next != null && current.next.data.getEmployeeID() != employeeID) {
            current = current.next;
        }

        if (current.next == null) { // Condition to check if the employee ID is not present in the list
            System.out.println("Error: Employee ID not found.");
        } else { // If the employee ID is found
            System.out.println("Employee deleted successfully (Employee ID: " + current.next.data.getEmployeeID() + ", Name: " + current.next.data.getName() + ", Position: " + current.next.data.getPosition() + ", Salary: " + current.next.data.getSalary() + ").");
            current.next = current.next.next; // Removing the target node from the list
        }
    }

    // Displaying all employees in the list
    public void displayEmployees() {
        if (head == null) { // Consition to check if the list is empty
            System.out.println("No employees to display.");
            return;
        }

        Node current = head;
        // Traversing and printing each employee's details
        while (current != null) {
            System.out.println(current.data); // Method to call the Employee's toString() method
            current = current.next;
        }
    }
}
