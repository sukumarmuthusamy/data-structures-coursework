# Data Structures Coursework

A comprehensive collection of Data Structures and Algorithms implementations in Java, developed as part of CS 3305 coursework.  This repository showcases fundamental concepts through well-documented assignments with detailed problem statements, solutions, and performance analysis.

## 📚 Repository Structure

This repository is organized by topic, with each folder containing complete implementations, comprehensive documentation, and usage instructions.

### Assignments

1. **[Recursion](./Recursion)** — Recursive problem-solving techniques
   - String reversal (character-by-character using recursion)
   - Class average calculation using recursive methods
   - Input validation with retry functionality
   - Demonstrates base cases and recursive calls

2. **[LinkedLists](./LinkedLists)** — Employee Management System
   - Singly linked list implementation
   - CRUD operations (Create, Read, Update, Delete)
   - Search and display functionality
   - Menu-driven interface

3. **[Stacks](./Stacks)** — Stack data structure applications
   - Array-based stack implementation
   - Stack manipulation functions (topToBottom, bottomToTop, flipStack, searchStack)
   - Balanced parentheses checker using custom stack
   - Expression validation with brackets, braces, and parentheses

4. **[Queues](./Queues)** — Palindrome Checker
   - Queue implementation using LinkedList
   - Character-by-character palindrome detection
   - Word-by-word palindrome detection
   - Uses Queue (FIFO) and Stack (LIFO) for comparison

5. **[Sorting](./Sorting)** — Advanced Sorting Algorithms
   - **Bucket Sort** — Distribution-based sorting with negative number support
   - **Merge Sort** — Divide-and-conquer recursive sorting
   - Performance comparison and complexity analysis

6. **[BinarySearchTree](./BinarySearchTree)** — BST Operations
   - Node insertion with duplicate prevention
   - Tree search functionality
   - Node deletion (3 cases: leaf, one child, two children)
   - Inorder traversal for sorted output
   - Height calculation
   - Two-phase menu system (initialization + full operations)

7. **[Hashing](./Hashing)** — Hash Functions and Collision Resolution
   - **HF1:** Division method with Linear Probing (214 probes)
   - **HF2:** Division method with Quadratic Probing (112 probes)
   - **HF3:** Division method with Double Hashing (103 probes)
   - **HF4:** Custom Mid-Square Method with Quadratic Probing (75 probes)
   - Performance analysis and comparison

---

## 🚀 Quick Start

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command-line terminal or IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running an Assignment

1. Navigate to the assignment folder:
   ```bash
   cd AssignmentFolder
   ```

2. Compile the Java file:
   ```bash
   javac FileName.java
   ```

3. Run the program:
   ```bash
   java FileName
   ```

**Example:**
```bash
cd BinarySearchTree
javac BSTDemo.java
java BSTDemo
```

**For multi-file assignments (e.g., Queues):**
```bash
cd Queues
javac testPalindrome.java characterPalindrome.java wordPalindrome.java
java testPalindrome
```

---

## 📖 Documentation

Each assignment folder contains:
- ✅ **README.md** — Comprehensive documentation including:
  - Problem statement and requirements
  - Design choices and implementation details
  - Algorithm complexity analysis
  - Sample program execution
  - Key learning outcomes
- ✅ **Source code** — Well-commented Java implementations
- ✅ **Input validation** — Robust error handling

---

## 🎯 Key Features

### Code Quality
- **Comprehensive Input Validation** — Handles empty input, invalid characters, and edge cases
- **Detailed Comments** — Clear explanations of logic and design decisions
- **Consistent Style** — Follows Java naming conventions and best practices
- **Error Handling** — Try-catch blocks and validation checks throughout

### Learning Focus
- **Algorithm Analysis** — Time and space complexity for each implementation
- **Design Patterns** — Demonstrates proper use of data structures
- **Performance Comparison** — Benchmarking different approaches (e.g., sorting algorithms, hash functions)
- **Real-World Applications** — Practical use cases for each data structure

---

## 📊 Complexity Analysis Summary

| Data Structure | Search | Insert | Delete | Space |
|---------------|--------|--------|--------|-------|
| **Linked List** | O(n) | O(1) | O(n) | O(n) |
| **Stack** | O(n) | O(1) | O(1) | O(n) |
| **Queue** | O(n) | O(1) | O(1) | O(n) |
| **BST (avg)** | O(log n) | O(log n) | O(log n) | O(n) |
| **Hash Table (avg)** | O(1) | O(1) | O(1) | O(n) |

| Algorithm | Best Case | Average Case | Worst Case | Space |
|-----------|-----------|--------------|------------|-------|
| **Bucket Sort** | O(n+k) | O(n+k) | O(n²) | O(n+k) |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) |

---

## 🛠️ Technologies Used

- **Language:** Java
- **Concepts:** Data Structures, Algorithms, Object-Oriented Programming, Recursion
- **Tools:** Command-line compilation and execution

---

## 📝 Course Information

- **Course:** CS 3305 - Data Structures
- **Instructor:** Umama Tasnim
- **Term:** Spring 2025
- **Section:** 01

---

## 👤 Author

**Sukumar Muthusamy**
- GitHub: [@sukumarmuthusamy](https://github.com/sukumarmuthusamy)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Course instructor and teaching assistants for guidance and feedback
- Data Structures and Algorithms textbook references
- Java documentation and community resources

---

## 📌 Assignment Highlights

### Recursion
- Implements string reversal and average calculation using pure recursion
- Demonstrates proper base cases and recursive problem decomposition
- Interactive retry functionality for multiple test cases

### LinkedLists
- Full employee management system with search and CRUD operations
- Demonstrates singly linked list node manipulation
- Menu-driven interface with comprehensive validation

### Stacks
- Custom stack implementation using arrays
- Balanced parentheses checker for expression validation
- Stack manipulation functions demonstrating LIFO behavior

### Queues
- Palindrome detection using Queue (FIFO) and Stack (LIFO)
- Handles both character-level and word-level palindromes
- Clean input preprocessing with special character handling

### Sorting
- Comparison of distribution-based vs divide-and-conquer sorting
- Bucket Sort handles negative numbers with dynamic bucket creation
- Merge Sort demonstrates efficient recursive sorting with O(n log n) guarantee

### BinarySearchTree
- Complete BST implementation with all standard operations
- Two-phase design ensures minimum data before full operations
- Proper deletion handling for all three cases (0, 1, or 2 children)

### Hashing
- Four different hash functions with performance comparison
- Demonstrates primary clustering, secondary clustering, and their solutions
- Custom HF4 achieves best performance (75 probes) using Mid-Square Method

---

## 📂 Repository Statistics

- **Total Assignments:** 7
- **Total Java Files:** 15+
- **Lines of Code:** 2000+
- **Documentation:** Comprehensive READMEs for all assignments

---

*Last Updated: December 16, 2025*
