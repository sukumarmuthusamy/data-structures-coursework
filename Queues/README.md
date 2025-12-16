# Queues Assignment – Palindrome Checker

This assignment implements a menu-driven Palindrome Checker using Java's Queue and Stack data structures.  The program tests two types of palindromes:  **character-by-character** and **word-by-word**, demonstrating the practical application of queues in string processing and validation.

## Programs Included

- **testPalindrome.java** — Menu-driven main program that handles user input and orchestrates palindrome checking. 
- **characterPalindrome.java** — Checks if a string is a palindrome character by character using Queue (FIFO) and Stack (LIFO).
- **wordPalindrome.java** — Checks if a string is a palindrome word by word using Queue (FIFO) and Stack (LIFO).

## How to Run

Compile all files:
```bash
javac testPalindrome.java characterPalindrome.java wordPalindrome.java
```

Run the main program:
```bash
java testPalindrome
```

## Program Features

The Palindrome Checker is a menu-driven program with the following options:

```
-----MAIN MENU-----
1. Test character-by-character palindrome
2. Test word-by-word palindrome
3. Exit program

Enter option number: 
```

### 1. Character-by-Character Palindrome

Tests whether a string reads the same forwards and backwards at the character level, ignoring spaces and special characters.

**Features:**
- Input is read as one complete string
- Removes extra spaces and special characters when storing into Queue and Stack
- Preserves alphanumeric values (letters and numbers)
- Empty input or input with only special characters is considered **NOT a palindrome**
- Case-insensitive comparison

**Sample Runs:**
```
You selected:    Option 1
You entered:    Eva, can I see bees in a cave?
Judgment:        Palindrome

You selected:   Option 1
You entered:    12321
Judgment:       Palindrome

You selected:   Option 1
You entered:    Straw?  No.  too stupid a fad.  I put soot on warts.
Judgment:       Palindrome
```

### 2. Word-by-Word Palindrome

Tests whether the words in a string form a palindrome when compared in reverse order.

**Features:**
- Input is read as one complete string
- Removes special characters while preserving spaces for word separation
- Spaces are used to split input into individual words
- Word order is preserved during comparison
- Numeric values in words are allowed (e.g., "test12 user12 test12" is valid)
- Empty input or input with only special characters is considered **NOT a palindrome**
- Case-insensitive comparison

**Sample Runs:**
```
You selected:   Option 2
You entered:    You can cage a swallow, can't you, but you can't swallow a cage, can you
Judgment:       Palindrome

You selected:   Option 2
You entered:    test12 user12 test12
Judgment:       Palindrome

You selected:   Option 2
You entered:    Straw? No. too stupid a fad. I put soot on warts.
Judgment:       Not Palindrome
```

### 3. Exit Program

Safely exits the program with a goodbye message.

## Design Choices

### 1. **Robust Input Validation**

The program handles various invalid inputs for menu selection:
- **Empty input** — Detects when user presses Enter without typing anything
- **Invalid characters** — Handles letters, symbols, and special characters
- **Invalid choices** — Validates that menu selection is between 1 and 3
- **Trimming whitespace** — Automatically removes extra spaces from menu input

All invalid inputs produce clear, specific error messages: 
```
No input detected! Please enter a number between 1 and 3.
Invalid input! Please enter a number between 1 and 3.
Invalid option! Please enter a number between 1 and 3.
```

### 2. **Queue and Stack for Palindrome Detection**

Both palindrome checkers use the same algorithmic approach: 

**Queue (FIFO - First-In-First-Out):**
- Stores characters/words in **original order**
- Elements are retrieved from the front

**Stack (LIFO - Last-In-First-Out):**
- Stores characters/words in **reverse order**
- Elements are retrieved from the top

**Comparison Logic:**
```
While both Queue and Stack have elements:
    Remove element from Queue (first added)
    Pop element from Stack (last added)
    If they don't match → NOT a palindrome
If all match → Palindrome
```

This approach elegantly leverages the inherent properties of these data structures to perform the comparison without manually reversing strings.

### 3. **Input Cleaning and Preprocessing**

**Character-by-Character:**
```java
String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
```
- Removes **all** special characters and spaces
- Keeps only letters and numbers
- Converts to lowercase for case-insensitive comparison

**Word-by-Word:**
```java
String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
String[] words = cleanedInput.split("\\s+");
```
- Removes special characters but **preserves spaces**
- Splits input into words using whitespace
- Maintains word boundaries for accurate word-order comparison

### 4. **Edge Case Handling**

The program explicitly handles: 

**Empty Input:**
- Empty strings return `false` (NOT a palindrome)
- Input with only special characters that becomes empty after cleaning returns `false`

**Single Character/Word:**
- Single characters are valid palindromes (e.g., "a")
- Single words are valid palindromes (e.g., "hello")

**Numeric Values:**
- Numbers are treated as valid characters (e.g., "12321" → Palindrome)
- Words with numbers are valid (e.g., "test12 user12 test12" → Palindrome)

**Mixed Case:**
- All comparisons are case-insensitive
- "RaceCar" and "racecar" are both palindromes

**Special Characters and Punctuation:**
- Ignored in character-by-character mode
- Ignored in word-by-word mode (but spaces preserved for word separation)

### 5. **Clean Output Formatting**

The program uses formatted output with consistent column alignment:
```java
System.out.printf("%-15s %s\n", "You selected:", "Option 1");
System.out.printf("%-15s ", "You entered:");
System.out.printf("%-15s %s", "Judgment:", isPalindrome ? "Palindrome" : "Not Palindrome");
```

This ensures output is readable and professionally formatted: 
```
You selected:   Option 1
You entered:    Eva, can I see bees in a cave? 
Judgment:       Palindrome
```

### 6. **Separation of Concerns**

Each class has a single, well-defined responsibility: 
- **testPalindrome.java** — User interface, menu handling, input validation
- **characterPalindrome.java** — Character-level palindrome logic
- **wordPalindrome.java** — Word-level palindrome logic

This modular design makes the code: 
- Easy to test and debug
- Simple to extend with new palindrome types
- Clear and maintainable

### 7. **Use of Java's Built-in Collections**

The program uses Java's standard `Queue` (LinkedList) and `Stack` implementations:
```java
Queue<Character> queue = new LinkedList<>();
Stack<Character> stack = new Stack<>();
```

This demonstrates: 
- Understanding of Java Collections Framework
- Proper use of generics (`<Character>`, `<String>`)
- Knowledge of when to use built-in structures vs.  custom implementations

## Algorithm Complexity

**Time Complexity:** O(n)
- Where n is the number of characters/words
- Single pass to add elements to Queue and Stack
- Single pass to compare elements

**Space Complexity:** O(n)
- Queue stores n elements
- Stack stores n elements
- Total space:  2n → O(n)

## Sample Program Execution

```
-----MAIN MENU-----
1. Test character-by-character palindrome
2. Test word-by-word palindrome
3. Exit program

Enter option number:  1

You selected:   Option 1
You entered:    Eva, can I see bees in a cave? 
Judgment:       Palindrome


-----MAIN MENU-----
1. Test character-by-character palindrome
2. Test word-by-word palindrome
3. Exit program

Enter option number: 2

You selected:   Option 2
You entered:    You can cage a swallow, can't you, but you can't swallow a cage, can you
Judgment:       Palindrome


-----MAIN MENU-----
1. Test character-by-character palindrome
2. Test word-by-word palindrome
3. Exit program

Enter option number: 1

You selected:   Option 1
You entered:    Straw? No. too stupid a fad. I put soot on warts.
Judgment:       Palindrome


-----MAIN MENU-----
1. Test character-by-character palindrome
2. Test word-by-word palindrome
3. Exit program

Enter option number: 2

You selected:   Option 2
You entered:    Straw? No. too stupid a fad. I put soot on warts.
Judgment:       Not Palindrome


-----MAIN MENU-----
1. Test character-by-character palindrome
2. Test word-by-word palindrome
3. Exit program

Enter option number: 3
Exiting the program... Goodbye! 
```

## Key Learning Outcomes

This assignment demonstrates: 
1. ✅ **Queue and Stack operations** — Understanding FIFO vs.  LIFO behavior
2. ✅ **String manipulation** — Regex patterns, cleaning, and splitting
3. ✅ **Input validation** — Comprehensive error handling for user input
4. ✅ **Algorithm design** — Leveraging data structure properties for elegant solutions
5. ✅ **Code organization** — Separation of concerns and modular design
6. ✅ **Edge case handling** — Robust handling of empty, special, and numeric inputs
