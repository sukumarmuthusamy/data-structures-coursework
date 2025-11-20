import java.util.Scanner;

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeLinkedList employeeList = new EmployeeLinkedList(); // Creating an instance of EmployeeLinkedList to store employee records
        Scanner scan = new Scanner(System.in);

        while (true) { // Program will run until the user chooses to exit
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add a new Employee");
            System.out.println("2. Delete an existing Employee");
            System.out.println("3. Display all Employees");
            System.out.println("4. Exit");

            int choice = getValidInt(scan, "Enter your choice: "); // Calls the method to handle input validation

            switch (choice) { // To execute different blocks of code based on the choice.

                // If the user chooses option 1 (Adding an Employee)
                case 1:
                    // To get and validate the Employee ID
                    int id;
                    do {
                        id = getValidInt(scan, "Enter Employee ID (numbers only): "); // To get input as integer
                        if (id <= 0) { // To validate no negative or zero values
                            System.out.println("Error: Employee ID must be a positive number. Please enter again.");
                        } else if (!employeeList.isEmployeeIDUnique(id)) { // To validate ID is unique. This goes to EmployeeLinkedList class.
                            System.out.println("Error: Employee ID must be unique. Please enter a different ID.");
                        }
                    } while (id <= 0 || !employeeList.isEmployeeIDUnique(id)); // To repeat the loop until valid ID is provided

                    // To get and validate the Employee Name. This will be calling the helper function.
                    String name = getValidNameOrPosition(scan, "Enter Name (letters only): ", "Error: Name should not contain numbers or special characters.");

                    // To get and validate the Employee Position. This will be calling the helper function.
                    String position = getValidNameOrPosition(scan, "Enter Position (letters only): ", "Error: Position should not contain numbers or special characters.");

                    // To get and validate the Employee Salary. This will be calling the helper function.
                    double salary = getValidDouble(scan, "Enter Salary (positive number): ");

                    // Creates a new Employee object using the collected data and adds it to the employee list.
                    employeeList.addEmployee(new Employee(id, name, position, salary));
                    break;

                // If the user chooses option 2 (Deleting an existing Employee)
                case 2:
                    int deleteID = getValidInt(scan, "Enter Employee ID to delete: ");
                    employeeList.deleteEmployee(deleteID); // To call the deleteEmployee method from the EmployeeLinkedList Class to remove the employee.
                    break;

                // If the user chooses option 3 (Displaying all Employee)
                case 3:
                    employeeList.displayEmployees(); // To call the displayEmployees method from the EmployeeLinkedList Class to display the employee information.
                    break;

                // If the user chooses option 4 (Exit)
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scan.close();
                    return;

                // If the user entered an invalid choice other than 1 to 4.
                default:
                    System.out.println("Error: Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    // Helper functions for getting valid input

    // This will validate the user choice for Menu and Employee ID for valid inputs
    private static int getValidInt(Scanner scan, String prompt) {
        while (true) { // Loop until a valid integer is entered
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {  // To check if the input is empty
                System.out.println("Error: Input cannot be empty. Please enter a valid number.");
                continue; // Retry
            }
            try {  // Try block to handle exceptions
                return Integer.parseInt(input);
            } catch (
                    NumberFormatException e) { // To catch the InputMismatchException if the user enters a non-integer value.
                System.out.println("Error: Invalid input. Please enter a valid integer which contains only numbers.");
            }
        }
    }

    // This will validate the Employee Salary for valid inputs
    private static double getValidDouble(Scanner scan, String prompt) {
        while (true) { // Loop until a valid double is entered
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {  // To check if the input is empty
                System.out.println("Error: Input cannot be empty. Please enter a valid number.");
                continue; // Retry
            }
            try { // Try block to handle exceptions
                double value = Double.parseDouble(input);
                if (value <= 0) { // Condition to check if the salary entered is a positive number
                    System.out.println("Error: Salary must be a positive number.");
                    continue;
                }
                return value;
            } catch (
                    NumberFormatException e) { // To catch the InputMismatchException if the user enters a non number value.
                System.out.println("Error: Invalid input. Please enter a valid number.");
            }
        }
    }

    // This will validate the Employee Name and Position for valid inputs
    private static String getValidNameOrPosition(Scanner scan, String prompt, String errorMessage) {
        while (true) {  // Loop until a valid string is entered
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {  // To check if the input is empty
                System.out.println("Error: Input cannot be empty. Please enter a valid string.");
            }
            // To check if the input contains numbers or invalid special characters.
            // The first condition (.*\\d.*) ensures the input does not include digits (0-9).
            // The second condition (.*[^a-zA-Z ].*) ensures only letters and spaces are allowed.
            else if (input.matches(".*\\d.*") || input.matches(".*[^a-zA-Z ].*")) {
                System.out.println(errorMessage);
            } else {
                return input;
            }
        }
    }
}