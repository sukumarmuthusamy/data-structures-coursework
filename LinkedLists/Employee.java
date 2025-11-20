// Employee Class
public class Employee {
    private int employeeID;
    private String name;
    private String position;
    private double salary;

    // Constructor of the Employee class.  This will be called when we create a new Employee object.
    public Employee(int employeeID, String name, String position, double salary) {

        // Below pieces of code assigns the user entered values to the respective instance variables.
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() { // Getter method for employeeID
        return employeeID;
    }

    public String getName() { // Getter method for Name
        return name;
    }

    public String getPosition() { // Getter method for Position
        return position;
    }

    public double getSalary() { // Getter method for Salary
        return salary;
    }

    @Override // This method overrides the Object class.
    public String toString() {  // Overrides the toString() method.  This is called when we print an Employee object.
        return "Employee ID: " + employeeID + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}