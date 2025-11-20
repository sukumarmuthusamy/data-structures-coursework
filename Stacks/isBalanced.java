import java.util.Scanner;

class Stack {
    private char[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack(int size) {
        stackArray = new char[size];
        capacity = size;
        top = -1;
    }

    // To push an element onto the stack
    public void push(char item) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack overflow");
        }
        stackArray[++top] = item;
    }

    // To pop an element from the stack
    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stackArray[top--];
    }

    // To peek the top element of the stack
    public char peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stackArray[top];
    }

    // To check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

public class isBalanced {

    // Function to check if brackets in the expression are balanced
    public static boolean isBalanced(String expression) {
        Stack stack = new Stack(expression.length());

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Helper function to check matching pairs of brackets
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    // To convert boolean to "True" or "False" with capital first letter
    public static String capitalizedBoolean(boolean value) {
        return value ? "True" : "False";
    }

    // Function to get user input with validation (no empty input)
    public static String getUserInput(Scanner scan, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scan.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please enter a valid input.");
            }
        }
    }

    public static void main(String[] args) {
        // Test cases from the assignment
        System.out.println("Test cases from Assignment:");
        System.out.println("print(isBalanced(\"(())\")) # " + capitalizedBoolean(isBalanced("(())")));      // True
        System.out.println("print(isBalanced(\"{{[]}}\")) # " + capitalizedBoolean(isBalanced("{{[]}}")));  // True
        System.out.println("print(isBalanced(\"()[]{}\")) # " + capitalizedBoolean(isBalanced("()[]{}")));  // True
        System.out.println("print(isBalanced(\"({[})\")) # " + capitalizedBoolean(isBalanced("({[})")));    // False

        // Additional edge cases
        System.out.println("\nAdditional edge cases:");
        // 1. Empty String
        System.out.println("1.Empty String:");
        System.out.println("print(isBalanced(\"\")) # " + capitalizedBoolean(isBalanced("")));              // True

        // 2. Extra Opening Brackets
        System.out.println("\n2.Extra Opening Brackets:");
        System.out.println("print(isBalanced(\"(((\")) # " + capitalizedBoolean(isBalanced("(((")));        // False

        // 3. Extra Closing Brackets
        System.out.println("\n3.Extra Closing Brackets:");
        System.out.println("print(isBalanced(\")]]\")) # " + capitalizedBoolean(isBalanced("))]")));        // False

        // 4. Nested Balanced Brackets
        System.out.println("\n4.Nested Balanced Brackets:");
        System.out.println("print(isBalanced(\"{[()]}\")) # " + capitalizedBoolean(isBalanced("{[()]}")));  // True

        // 5. Mismatched Brackets
        System.out.println("\n5.Mismatched Brackets:");
        System.out.println("print(isBalanced(\"([)]\")) # " + capitalizedBoolean(isBalanced("([)]")));      // False

        // 6. Sequential Balanced Brackets
        System.out.println("\n6.Sequential Balanced Brackets:");
        System.out.println("print(isBalanced(\"()[]{}\")) # " + capitalizedBoolean(isBalanced("()[]{}")));  // True

        // 7. Single Opening or Closing Bracket
        System.out.println("\n7.Single Opening or Closing Bracket:");
        System.out.println("print(isBalanced(\"(\")) # " + capitalizedBoolean(isBalanced("(")));            // False
        System.out.println("print(isBalanced(\")\")) # " + capitalizedBoolean(isBalanced(")")));            // False

        // 8. Non-bracket Characters
        System.out.println("\n8.Non-bracket Characters:");
        System.out.println("print(isBalanced(\"a(b)c[d]{e}\")) # " + capitalizedBoolean(isBalanced("a(b)c[d]{e}"))); // True

        // 9. Incorrect Order of Brackets
        System.out.println("\n9.Incorrect Order of Brackets:");
        System.out.println("print(isBalanced(\")(\")) # " + capitalizedBoolean(isBalanced(")(")));          // False

        // User Input Section
        Scanner scan = new Scanner(System.in);
        String userChoice = getUserInput(scan, "\nDo you want to enter your own expression to check? (Y/N): ").toLowerCase();

        if (userChoice.equals("y") || userChoice.equals("yes")) {
            String userExpression = getUserInput(scan, "Enter an expression with brackets: ");
            System.out.println("Result: " + capitalizedBoolean(isBalanced(userExpression)));
        } else if (!userChoice.equals("n") && !userChoice.equals("no")) {
            System.out.println("Invalid input! Exiting program.");
        }
        System.out.println("Program ended. Thank you!");
        scan.close();
    }
}