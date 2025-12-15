import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class wordPalindrome {
    public static boolean isPalindrome(String input) {

        // To remove all non-alphabetic and non-numeric characters except spaces, then converts to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

        // To split the cleaned input into words using whitespace as the separator
        String[] words = cleanedInput.split("\\s+");

        // To check if there are no valid words left after cleaning
        if (words.length == 0 || (words.length == 1 && words[0].isEmpty())) {
            return false;  // If no valid words remain, it should NOT be a palindrome
        }

        // Initializing Queue (FIFO) and Stack (LIFO)
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        // To add words to Queue and Stack
        for (int i = 0; i < words.length; i++) {
            queue.add(words[i]);  // Stores words in original order (FIFO)
            stack.push(words[i]); // Stores words in reverse order (LIFO)
        }

        // To compare words from Queue and Stack
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;  // If any mismatch is found, it's NOT a palindrome
            }
        }
        return true;  // If all words match, the input is a palindrome
    }
}
