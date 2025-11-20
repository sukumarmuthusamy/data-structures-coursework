import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class testStack {

    // Function to display stack contents from top to bottom
    public static void topToBottom(Stack<Integer> stack) {
        System.out.print("Stack content: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");  // To print each element followed by a space
        }
        System.out.println();
        System.out.print("Function output: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");  // To print each element followed by a space
        }
        System.out.println();
    }

    // Function to display stack contents from bottom to top
    public static void bottomToTop(Stack<Double> stack) {
        System.out.print("Stack content: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");   // To print each element followed by a space
        }
        System.out.println();
        System.out.print("Function output: ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");  // To print each element followed by a space
        }
        System.out.println();
    }

    // Function to flip the stack contents
    public static Stack<String> flipStack(Stack<String> stack) {
        Stack<String> flippedStack = new Stack<>();   // To create a new empty stack
        // To pop the elements from the original stack and push them onto the new stack
        while (!stack.isEmpty()) {
            flippedStack.push(stack.pop());   // This reverses the order of elements
        }
        return flippedStack;    // To return the flipped stack
    }

    // Function to search for a target in the stack
    public static boolean searchStack(Stack<Integer> stack, int target) {
        return stack.contains(target);
    }

    // Helper function to get integer input from the user
    // Ensures input is valid and not empty
    private static List<Integer> getIntInput(Scanner scan) {
        List<Integer> integers = new ArrayList<>();
        while (true) {
            try {
                System.out.print("Enter integers to push onto the stack (space-separated): ");
                String inputLine = scan.nextLine();  // To read the entire line of input
                if (inputLine.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please enter integers.");
                }
                String[] input = inputLine.split(" ");  // To split the input string by spaces
                for (String s : input) {
                    integers.add(Integer.parseInt(s));
                }
                break;   // To exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter only integers.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // To handle empty input
            }
        }
        return integers; // To return the list of integers
    }

    // Helper function to get double input from the user
    // Ensures input is valid and not empty. This is similar to the helper function for getting integer inputs. So comments are skipped for similar lines of code.
    private static List<Double> getDoubleInput(Scanner scan) {
        List<Double> doubles = new ArrayList<>();
        while (true) {
            try {
                System.out.print("Enter doubles to push onto the stack (space-separated): ");
                String inputLine = scan.nextLine();
                if (inputLine.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please enter doubles.");
                }
                String[] input = inputLine.split(" ");
                for (String s : input) {
                    doubles.add(Double.parseDouble(s));
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter only doubles.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return doubles;
    }

    // Helper function to get string input from the user
    // Ensures input is valid, not empty, and contains no numeric values. This is similar to the helper function for getting integer inputs. So comments are skipped for similar lines.
    private static List<String> getStringInput(Scanner scan) {
        List<String> strings = new ArrayList<>();
        while (true) {
            try {
                System.out.print("Enter strings to push onto the stack (space-separated): ");
                String inputLine = scan.nextLine();
                if (inputLine.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please enter strings.");
                }
                String[] input = inputLine.split(" ");
                for (String s : input) {
                    if (s.matches("\\d+(\\.\\d+)?")) {
                        throw new IllegalArgumentException("Invalid input. Strings cannot contain numbers.");
                    }
                    strings.add(s);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1; // Variable to store the user's menu choice

        do {
            try {
                // Display the main menu
                System.out.println("\n-----MAIN MENU-----");
                System.out.println("1. Test function topToBottom with integer stack");
                System.out.println("2. Test function bottomToTop with double stack");
                System.out.println("3. Test function flipStack with string stack");
                System.out.println("4. Test function searchStack with integer stack");
                System.out.println("5. Exit program");
                System.out.print("Enter your choice: ");

                // To read and validate the user's input
                String input = scan.nextLine().trim(); // To trim spaces around input
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Choice cannot be empty. Please enter a valid option.");
                }

                choice = Integer.parseInt(input); // To convert input to integer

                // To perform actions based on the user's choice
                switch (choice) {
                    case 1:
                        // Test topToBottom with integer stack
                        List<Integer> intInput = getIntInput(scan);
                        Stack<Integer> intStack = new Stack<>();
                        intStack.addAll(intInput);
                        topToBottom(intStack);
                        break;

                    case 2:
                        // Test bottomToTop with double stack
                        List<Double> doubleInput = getDoubleInput(scan);
                        Stack<Double> doubleStack = new Stack<>();
                        doubleStack.addAll(doubleInput);
                        bottomToTop(doubleStack);
                        break;

                    case 3:
                        // Test flipStack with string stack
                        List<String> stringInput = getStringInput(scan);
                        Stack<String> stringStack = new Stack<>();
                        stringStack.addAll(stringInput);
                        System.out.print("Stack content before calling flipStack: ");
                        for (int i = stringStack.size() - 1; i >= 0; i--) {
                            System.out.print(stringStack.get(i) + " ");
                        }
                        System.out.println();
                        stringStack = flipStack(stringStack);
                        System.out.print("Stack content after calling flipStack: ");
                        for (int i = stringStack.size() - 1; i >= 0; i--) {
                            System.out.print(stringStack.get(i) + " ");
                        }
                        System.out.println();
                        break;

                    case 4:
                        // Test searchStack with integer stack
                        List<Integer> searchInput = getIntInput(scan);
                        Stack<Integer> searchStack = new Stack<>();
                        searchStack.addAll(searchInput);
                        System.out.print("Stack content: ");
                        for (int i = searchStack.size() - 1; i >= 0; i--) {
                            System.out.print(searchStack.get(i) + " ");
                        }
                        System.out.println();
                        System.out.print("Enter target value to search for: ");
                        int target = scan.nextInt();
                        scan.nextLine(); // Consume newline
                        System.out.println("Function output: " + searchStack(searchStack, target));
                        break;

                    case 5:
                        // Exit the program
                        System.out.println("Exiting program...Goodbye !!");
                        break;

                    default:
                        // Handle invalid menu choice
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }

            } catch (NumberFormatException e) {
                // Handle non-numeric input
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            } catch (IllegalArgumentException e) {
                // Handle empty or invalid input
                System.out.println(e.getMessage());
            }

            System.out.println();
        } while (choice != 5); // Loop until the user chooses to exit

        scan.close(); // Close the scanner
    }
}