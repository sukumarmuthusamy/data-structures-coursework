# Binary Search Tree Assignment

This assignment implements a Binary Search Tree (BST) in Java with comprehensive operations including insertion, deletion, searching, traversal, and height calculation.  The program features a two-phase approach:  initial tree setup with validation, followed by a full interactive menu for BST operations.

## Programs Included

- **BSTDemo.java** — Complete BST implementation containing: 
  - `TreeNode` class — Represents a single node in the BST
  - `BinarySearchTree` class — Core BST operations and tree management
  - `BSTDemo` class — Main program with two-phase menu system and input validation

## How to Run

Compile the file:
```bash
javac BSTDemo.java
```

Run the program:
```bash
java BSTDemo
```

## Program Features

### Phase 1: Initial Tree Setup (Restricted Menu)

The program begins with a restricted menu that only allows element insertion until a minimum of **10 valid and unique elements** are inserted. 

**Features:**
- Validates all inputs before insertion
- Prevents duplicate values
- Accepts negative integers as valid input
- Handles invalid inputs with clear error messages
- Automatically displays tree information after reaching 10 elements

**Initial Menu:**
```
Binary Search Tree - Initial Setup
1. Insert element
2. Exit program

Enter your choice:  
```

**Input Validation:**
- ❌ Empty input → Error message and re-prompt
- ❌ Special characters → Rejected with error message
- ❌ Alphabetical input → Rejected with error message
- ❌ Duplicate values → Blocked with error message
- ✅ Negative integers → Accepted as valid
- ✅ Leading/trailing spaces → Automatically trimmed

**After 10 Elements Inserted:**
```
Inserted:  50 30 70 20 40 60 80 10 25 75
Inorder Traversal: 10 20 25 30 40 50 60 70 75 80
Height of BST: 3
```

The program automatically transitions to **Phase 2** (Full Menu).

---

### Phase 2: Full Menu Operations

After the tree is initialized, the program displays a full operation menu with search, insert, delete, and exit options.

**Full Menu:**
```
Binary Search Tree Operations
1. Search for an element
2. Insert a new element
3. Delete an element
4. Exit program

Enter your choice: 
```

---

#### 1. Search for an Element

Searches for a specific key in the BST and returns whether it exists.

**Features:**
- Validates input before searching
- Prevents search on empty tree (Phase 1 only)
- Handles invalid inputs gracefully

**Input Validation:**
- ❌ Empty input → Error message
- ❌ Special characters → Rejected
- ❌ Alphabetical input → Rejected
- ✅ Negative integers → Accepted

**Sample Output:**
```
Enter your choice: 1
Enter the element to search:  40
Search 40: Found

Enter your choice: 1
Enter the element to search: 90
Search 90: Not Found
```

---

#### 2. Insert a New Element

Inserts additional elements into the BST after initial setup.

**Features:**
- Duplicate entries blocked with error message
- Maintains BST property (left < parent < right)
- Updates and displays tree after each insertion
- Same validation rules as Phase 1

**Sample Output:**
```
Enter your choice: 2
Enter the element to insert: 35
Inserted: 50 30 70 20 40 60 80 10 25 75 35
Inorder Traversal: 10 20 25 30 35 40 50 60 70 75 80
Height of BST: 4

Enter your choice: 2
Enter the element to insert: 40
Duplicate key 40 not inserted.
```

---

#### 3. Delete an Element

Deletes a specified key from the BST following proper BST deletion rules.

**Features:**
- Handles three deletion cases:
  1. **Node with no children** (leaf node)
  2. **Node with one child** (replace with child)
  3. **Node with two children** (replace with inorder successor)
- Validates key existence before deletion
- Updates and displays tree after deletion
- Handles non-existent keys gracefully

**Sample Output:**
```
Enter your choice: 3
Enter the element to delete: 50
Deleting 50... 
Inorder Traversal after deletion: 10 20 25 30 35 40 60 70 75 80
Height of BST after deletion: 3

Enter your choice: 3
Enter the element to delete: 99
Key 99 not found.  Deletion skipped.
```

---

#### 4. Exit Program

Safely exits the program with a goodbye message.

```
Exiting program.  Goodbye!
```

---

## Design Choices

### 1. **Two-Phase Menu System**

**Phase 1 - Initial Tree Setup:**
- Restricts operations to insertion only
- Ensures tree has minimum 10 elements before full operations
- Prevents search/delete on empty/small trees
- Provides clear guidance for initial setup

**Phase 2 - Full Menu:**
- Unlocks all BST operations after initialization
- Allows flexible tree manipulation
- Maintains tree integrity throughout operations

This design ensures the BST has sufficient data before performing complex operations, making the demonstration more meaningful. 

---

### 2. **Comprehensive Input Validation**

All inputs are validated before processing: 

```java
String input = scan.nextLine().trim();  // Remove leading/trailing spaces

if (input.isEmpty()) {
    System.out.println("Input cannot be empty. Please enter a valid integer.");
    continue;
}

try {
    int value = Integer.parseInt(input);
    // Process valid integer
} catch (NumberFormatException e) {
    System.out.println("Invalid input!  Please enter a valid integer.");
}
```

**Validation checks:**
- Empty input detection
- Special character rejection
- Alphabetical input rejection
- Duplicate value prevention
- Whitespace trimming

---

### 3. **Duplicate Prevention**

Duplicates are detected during insertion and blocked with a clear message: 

```java
if (key == node.key) {
    System.out.println("Duplicate key " + key + " not inserted.");
}
```

This maintains BST uniqueness property and prevents tree corruption.

---

### 4. **Insertion Order Tracking**

The program maintains an `ArrayList<Integer>` to track insertion order: 

```java
private final List<Integer> insertedOrder = new ArrayList<>();

// During insertion: 
insertedOrder.add(key);

// During deletion:
insertedOrder.remove(Integer.valueOf(key));
```

**Benefits:**
- Shows elements in original insertion sequence
- Helps users track what was added/removed
- Distinguishes insertion order from sorted order (inorder traversal)

**Example:**
```
Inserted: 50 30 70 20 40 60 80 10 25 75
Inorder Traversal: 10 20 25 30 40 50 60 70 75 80
```

---

### 5. **Recursive BST Operations**

All core operations use recursion for elegant, efficient implementation:

**Recursive Insertion:**
```java
private TreeNode insertRec(TreeNode node, int key) {
    if (node == null) {
        return new TreeNode(key);  // Base case
    }
    if (key < node.key) {
        node.left = insertRec(node.left, key);   // Recur left
    } else if (key > node.key) {
        node.right = insertRec(node.right, key);  // Recur right
    }
    return node;
}
```

**Recursive Search:**
```java
private boolean searchRec(TreeNode node, int key) {
    if (node == null) return false;  // Base case:  not found
    if (key == node.key) return true;  // Base case: found
    return key < node.key ? searchRec(node.left, key) : searchRec(node.right, key);
}
```

**Recursive Deletion:**
```java
private TreeNode deleteRec(TreeNode node, int key) {
    if (node == null) return null;
    
    if (key < node.key) {
        node.left = deleteRec(node.left, key);
    } else if (key > node.key) {
        node.right = deleteRec(node.right, key);
    } else {
        // Node found - handle three cases
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        
        // Two children:  replace with inorder successor
        node.key = minValue(node.right);
        node.right = deleteRec(node.right, node.key);
    }
    return node;
}
```

---

### 6. **Proper BST Deletion Rules**

Deletion follows standard BST deletion protocol:

**Case 1: Leaf Node (No Children)**
```
Delete 10: 
     50              50
    /  \            /  \
   30   70   →     30   70
  /                 \
 10                 40
```

**Case 2: One Child**
```
Delete 30:
     50              50
    /  \            /  \
   30   70   →     40   70
    \
    40
```

**Case 3: Two Children**
```
Delete 50 (replace with inorder successor 60):
     50              60
    /  \            /  \
   30   70   →     30   70
       /  \             \
      60  80            80
```

---

### 7. **Inorder Traversal for Sorted Display**

Inorder traversal visits nodes in **left-root-right** order, producing sorted output:

```java
private void inorderRec(TreeNode node) {
    if (node != null) {
        inorderRec(node.left);    // Visit left subtree
        System.out.print(node.key + " ");  // Visit root
        inorderRec(node.right);   // Visit right subtree
    }
}
```

**Example:**
```
Tree structure:        Inorder output:
      50               10 20 25 30 40 50 60 70 75 80
     /  \
   30    70
   / \   / \
  20 40 60 80
  /\    \
10 25   75
```

---

### 8. **Height Calculation**

Height is calculated recursively as the longest path from root to leaf:

```java
public int height() {
    return heightRec(root);
}

private int heightRec(TreeNode node) {
    if (node == null) return 0;  // Empty tree has height 0
    return 1 + Math.max(heightRec(node.left), heightRec(node.right));
}
```

**Height definition:**
- Empty tree: height = 0
- Single node:  height = 1
- Height = 1 + max(left subtree height, right subtree height)

**Example:**
```
      50           Height = 3
     /  \
   30    70        Level 1
   / \   / \
  20 40 60 80      Level 2
  /\    \
10 25   75         Level 3
```

---

### 9. **Negative Integer Support**

The BST accepts negative integers as valid keys:

```java
int value = Integer.parseInt(input);  // Accepts negative values
```

**Example:**
```
Insert:  -10, -5, 0, 5, 10
Inorder Traversal: -10 -5 0 5 10
```

This demonstrates proper BST ordering with negative values.

---

### 10. **Edge Case Handling**

The program handles various edge cases:

**Empty Tree Operations (Phase 1):**
- Prevents search/delete before tree initialization
- Displays appropriate error messages

**Non-Existent Key Deletion:**
```
Key 99 not found. Deletion skipped.
```

**Duplicate Insertion:**
```
Duplicate key 40 not inserted. 
```

**Empty Input:**
```
Input cannot be empty. Please enter a valid integer. 
```

**Invalid Characters:**
```
Invalid input! Please enter a valid integer.
```

---

## Algorithm Complexity Analysis

### Time Complexity

| Operation | Average Case | Worst Case |
|-----------|-------------|------------|
| **Search** | O(log n) | O(n) |
| **Insert** | O(log n) | O(n) |
| **Delete** | O(log n) | O(n) |
| **Inorder Traversal** | O(n) | O(n) |
| **Height Calculation** | O(n) | O(n) |

- **Average case:** Balanced tree (O(log n) for search/insert/delete)
- **Worst case:** Skewed tree (degenerates to linked list, O(n))

### Space Complexity

- **Tree storage:** O(n) — One node per element
- **Recursion stack:** O(h) — Where h = height of tree
- **Insertion order list:** O(n) — Tracks all inserted elements

---

## Sample Program Execution

### Phase 1: Initial Setup

```
Binary Search Tree - Initial Setup
1. Insert element
2. Exit program

Enter your choice: 1
Enter the element to insert: 50

Enter your choice: 1
Enter the element to insert: 30

Enter your choice: 1
Enter the element to insert: 70

Enter your choice: 1
Enter the element to insert: 20

Enter your choice: 1
Enter the element to insert: 40

Enter your choice: 1
Enter the element to insert: 60

Enter your choice: 1
Enter the element to insert: 80

Enter your choice: 1
Enter the element to insert: 10

Enter your choice: 1
Enter the element to insert: 25

Enter your choice: 1
Enter the element to insert: 75

Inserted: 50 30 70 20 40 60 80 10 25 75
Inorder Traversal: 10 20 25 30 40 50 60 70 75 80
Height of BST:  3
```

---

### Phase 2: Full Operations

```
Binary Search Tree Operations
1. Search for an element
2. Insert a new element
3. Delete an element
4. Exit program

Enter your choice: 1
Enter the element to search: 40
Search 40: Found

Enter your choice: 1
Enter the element to search: 90
Search 90: Not Found

Enter your choice: 3
Enter the element to delete: 50
Deleting 50... 
Inorder Traversal after deletion: 10 20 25 30 40 60 70 75 80
Height of BST after deletion:  3

Enter your choice: 4
Exiting program. Goodbye! 
```

---

## Key Learning Outcomes

This assignment demonstrates:

1. ✅ **Binary Search Tree Structure** — Understanding parent-child relationships and BST property
2. ✅ **Recursive Tree Operations** — Implementing insertion, search, deletion, traversal, and height recursively
3. ✅ **BST Deletion Cases** — Handling leaf nodes, single-child nodes, and two-child nodes
4. ✅ **Tree Traversals** — Implementing inorder traversal for sorted output
5. ✅ **Height Calculation** — Computing tree height recursively
6. ✅ **Input Validation** — Comprehensive error handling for user input
7. ✅ **Edge Case Management** — Handling duplicates, empty trees, and non-existent keys
8. ✅ **Two-Phase Design** — Progressive user experience from setup to full operations
9. ✅ **Code Organization** — Separation of TreeNode, BST logic, and demo/UI code

---

## Additional Notes

- **Single file submission:** All classes (TreeNode, BinarySearchTree, BSTDemo) are contained in BSTDemo.java
- **Proper documentation:** Code includes clear comments explaining logic and purpose
- **BST property maintained:** Left subtree < parent < right subtree throughout all operations
- **Inorder successor method:** Used for two-child deletion case
- **User-friendly messages:** Clear feedback for all operations and error conditions