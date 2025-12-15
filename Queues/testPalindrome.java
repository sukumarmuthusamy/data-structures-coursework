import java.util.Scanner;
public class testPalindrome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // To read the user input
        int choice;

        while (true) {    // Infinite loop to keep showing the menu until the user chooses to exit
            System.out.println("\n");
            System.out.println("-----MAIN MENU-----");
            System.out.println("1. Test character-by-character palindrome");
            System.out.println("2. Test word-by-word palindrome");
            System.out.println("3. Exit program");
            System.out.print("\nEnter option number: ");

            String userChoice = scan.nextLine().trim();  // This is to read full input and remove leading/trailing spaces

            // To handle case when user presses Enter without typing anything
            if (userChoice.isEmpty()) {
                System.out.print("No input detected! Please enter a number between 1 and 3.");
                continue;  //  Skip rest of loop and will show the menu again
            }

            if (userChoice.matches("\\d+")) {  // To check if the input is a valid number
                choice = Integer.parseInt(userChoice);  // To convert string input to integer

                // Character-by-character palindrome check
                if (choice == 1) {
                    System.out.printf("%-15s %s\n", "You selected:", "Option 1");
                    System.out.printf("%-15s ", "You entered:");
                    String input = scan.nextLine();
                    boolean isPalindrome = characterPalindrome.isPalindrome(input); // Calling function to check palindrome

                    // To display the palindrome result
                    System.out.printf("%-15s %s", "Judgment:", isPalindrome ? "Palindrome" : "Not Palindrome");
                }

                // Word-by-word palindrome check
                else if (choice == 2) {
                    System.out.printf("%-15s %s\n", "You selected:", "Option 2");
                    System.out.printf("%-15s ", "You entered:");
                    String input = scan.nextLine();
                    boolean isPalindrome = wordPalindrome.isPalindrome(input);  // Calling function to check palindrome

                    // To display the palindrome result
                    System.out.printf("%-15s %s", "Judgment:", isPalindrome ? "Palindrome" : "Not Palindrome");

                }

                // Exit condition
                else if (choice == 3) {
                    System.out.println("Exiting the program... Goodbye!");
                    break;  // To exit the loop and end the program
                }

                // To handle out-of-range numbers (valid numbers but not 1-3)
                else {
                    System.out.print("Invalid option! Please enter a number between 1 and 3.");
                }
            }

            // To handle non-numeric inputs (like letters, symbols, etc.)
            else {
                System.out.print("Invalid input! Please enter a number between 1 and 3.");
            }
        }
        scan.close();
    }
}