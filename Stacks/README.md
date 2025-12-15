# Stacks Assignments

Java programs demonstrating stack concepts as part of the Data Structures coursework.  
This assignment consists of two parts: stack manipulation functions and a stack-based balanced-parentheses checker.

## Programs
- **testStack.java** — Implements four stack-related functions (topToBottom, bottomToTop, flipStack, searchStack) and provides a menu-driven tester.  
- **isBalanced.java** — Implements a custom stack using an array and checks whether parentheses/brackets/braces are balanced in a given expression.

---

## How to Run

**testStack.java**
```bash
javac testStack.java
java testStack
```

**isBalanced.java**
```bash
javac isBalanced.java
java isBalanced
```

---

## Program Details

### Part 1: testStack.java  
Implements four functions to practice stack operations using Java's built-in `Stack` class.

#### 1. topToBottom(Stack<Integer> stack)  
Displays the stack contents from top → bottom **without modifying** the stack.

#### 2. bottomToTop(Stack<Double> stack)  
Displays the stack contents from bottom → top **without modifying** the stack.

#### 3. flipStack(Stack<String> stack)  
Reverses the stack so that the bottom element becomes the new top and vice versa.

Example:  
Before: `Ed Tom Bob Amy` (top → bottom)  
After: `Amy Bob Tom Ed`  

#### 4. searchStack(Stack<Integer> stack, int target)  
Returns `true` if the target value exists anywhere in the stack; otherwise returns `false`, without changing the stack.

#### Menu-Driven Testing  
The program provides a simple menu:

```
-----MAIN MENU-----
1. Test function topToBottom with integer stack
2. Test function bottomToTop with double stack
3. Test function flipStack with string stack
4. Test function searchStack with integer stack
5. Exit program
```

The menu re-displays after each operation until Exit is chosen.

---

### Part 2: isBalanced.java  
Implements a **custom stack** using an array (`char[] stackArray`) and uses it to check for balanced parentheses/brackets/braces.

#### isBalanced(expression)  
Returns:
- **True** if expression contains properly balanced symbols  
- **False** otherwise  

Tested with cases such as:
```
(())       → True
{{[]}}     → True
()[]{}     → True
({[})      → False
```

The program also prompts the user:
```
Do you want to enter your own expression to check? (Y/N):
```
Accepts variations like `y`, `Y`, `Yes`, `YES`.  
Invalid or empty inputs are re-prompted.

---

## Design Choices

### Part 1 (testStack.java)  
- Input validation for all menu options and data entries.  
- Empty inputs are rejected and re-prompted.  
- Integer stack inputs do not accept doubles or strings.  
- Double stack inputs do not accept invalid formats.  
- String inputs do not accept numeric values.  
- Extra spaces in menu choices are trimmed.  
- Clear error messages for invalid menu choices.

### Part 2 (isBalanced.java)  
- Implemented a custom stack using a character array (`stackArray`).  
- Added built-in and extended test cases directly in the `main` method.  
- Included multiple additional edge cases (9 total).  
- Created a helper function to format Boolean outputs as `True` or `False` to match assignment style.  
- Added optional user input after the automated test cases.  
- User prompts validate empty input and invalid responses before continuing.

---
