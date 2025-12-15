import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class characterPalindrome {
    public static boolean isPalindrome(String input) {

        // To remove all non-alphabetic and non-numeric characters, and converts to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // To check if cleaned input is empty
        if (cleanedInput.isEmpty()) {
            return false;  // Empty input should NOT be considered a palindrome
        }

        // To convert cleaned string into a character array
        char[] charArray = cleanedInput.toCharArray();

        // Initializing Queue (FIFO) and Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // To add characters to Queue and Stack
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            queue.add(ch);  // Adds the character to the queue (FIFO - First-In-First-Out)
            stack.push(ch); // Adds the character to the stack (LIFO - Last-In-First-Out)
        }

        // To compare elements from Queue and Stack
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false; // If any mismatch is found, it's NOT a palindrome
            }
        }
        return true;  // If all characters match, the input is a palindrome
    }
}