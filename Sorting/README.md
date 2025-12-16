# Sorting Assignment – Advanced Sorting Algorithms

This assignment implements two advanced sorting algorithms in Java:   **Bucket Sort** and **Merge Sort**. Both programs demonstrate efficient sorting techniques with comprehensive input validation and user-friendly interfaces, reinforcing understanding of divide-and-conquer and distribution-based sorting strategies.

## Programs Included

- **bucketSorting.java** — Implements the Bucket Sort algorithm to sort an array of integers (including negative numbers) in ascending order.  
- **mergeSorting.java** — Implements the Merge Sort algorithm using recursion to sort an array of integers in ascending order. 

## How to Run

### Bucket Sort

Compile the file:
```bash
javac bucketSorting.java
```

Run the program:
```bash
java bucketSorting
```

### Merge Sort

Compile the file:
```bash
javac mergeSorting.java
```

Run the program:
```bash
java mergeSorting
```

## Program Features

### Part 1: Bucket Sort

Implements the Bucket Sort algorithm to efficiently sort integers by distributing them into buckets based on their value ranges. 

**Features:**
- Accepts any array size greater than 0
- Handles both positive and negative integers
- Dynamic bucket creation based on value range
- Sorts individual buckets using Java's built-in sort
- Prints original unsorted array and sorted array with meaningful labels

**Algorithm Overview:**
1. Find the minimum and maximum values in the array
2. Create buckets based on the range of values
3. Distribute elements into appropriate buckets
4. Sort each bucket individually
5. Merge sorted buckets back into the original array

**Input Constraints:**
- Array size: Must be greater than 0 (no upper limit)
- Element values: Any integer (positive, negative, or zero)

**Sample Run:**
```
Enter the number of elements in the array:  6
Enter 6 integer values (can be negative):
Element 1: 120
Element 2: 11
Element 3: 1345
Element 4: 50
Element 5: 6
Element 6: -25

Original Unsorted Array:         [120, 11, 1345, 50, 6, -25]
Sorted Array using Bucket Sort:   [-25, 6, 11, 50, 120, 1345]
```

---

### Part 2: Merge Sort

Implements the classic Merge Sort algorithm using recursion and a separate merge function to efficiently combine sorted subarrays.

**Features:**
- User input for array size and elements
- Recursive divide-and-conquer approach
- Efficient merging of sorted subarrays
- Enforces strict assignment constraints
- Prints original unsorted array and sorted array with meaningful labels

**Algorithm Overview:**
1. **Divide:** Recursively split the array into two halves until single elements remain
2. **Conquer:** Each single element is considered sorted
3. **Merge:** Combine two sorted subarrays into one sorted array

**Input Constraints:**
- Array size: Between 1 and 1000 (strictly enforced)
- Element values: Between 1 and 10000 (strictly enforced)

**Sample Run:**
```
Enter the number of elements in the array (1 - 1000): 5
Enter 5 integer values (between 1 and 10000):
Element 1: 120
Element 2: 11
Element 3: 1345
Element 4: 50
Element 5: 6

Original Unsorted Array:        [120, 11, 1345, 50, 6]
Sorted Array using Merge Sort:   [6, 11, 50, 120, 1345]
```

---

## Design Choices

### 1. **Comprehensive Input Validation**

Both programs implement robust input validation to handle various error scenarios:  

**Empty Input Validation:**
```java
if (input.isEmpty()) {
    System.out.println("Input cannot be empty.  Please enter a valid number.");
    continue;
}
```

**Invalid Characters (Letters or Symbols):**
```java
try {
    int value = Integer.parseInt(input);
    // Process valid integer
} catch (NumberFormatException e) {
    System.out.println("Invalid input!  Please enter a valid integer.");
}
```

**Integer Overflow Prevention:**
```java
long longSize = Long.parseLong(input);
if (longSize > Integer.MAX_VALUE) {
    System.out.println("Number too large.  Please enter a smaller number.");
    continue;
}
```

This ensures the program gracefully handles inputs that exceed Java's `int` range (> 2,147,483,647).

### 2. **Trimmed Input for Whitespace Handling**

Both programs read input as trimmed strings to remove leading/trailing spaces:  
```java
String input = scan.nextLine().trim();
```

This prevents issues caused by accidental whitespace and improves user experience.

### 3. **Element-by-Element Input Collection**

Elements are collected one at a time with individual validation:
```java
for (int i = 0; i < size; ) {
    System.out.print("Element " + (i + 1) + ": ");
    String input = scan.nextLine().trim();
    // Validation logic
    arr[i] = Integer.parseInt(input);
    i++;  // Only increment on successful input
}
```

This approach: 
- Helps users track their progress (e.g., "Element 1:", "Element 2:")
- Re-prompts for invalid input without losing previous valid entries
- Provides clear feedback for each input attempt

### 4. **Bucket Sort:   Negative Number Support**

The bucket index calculation supports negative numbers:
```java
int bucketIndex = (num - min) / 10;
```

By subtracting the minimum value, all numbers are shifted to a non-negative range, ensuring correct bucket placement regardless of sign.  A fixed bucket width of 10 is used to balance bucket count and sorting efficiency.

**Example:**
- Array: `[-25, 6, 11, 50, 120, 1345]`
- Min: `-25`, Max: `1345`
- Bucket for `-25`: `(-25 - (-25)) / 10 = 0`
- Bucket for `1345`: `(1345 - (-25)) / 10 = 137`

### 5. **Merge Sort: Constraint Enforcement**

Merge Sort enforces assignment constraints strictly:  

**Array Size Validation:**
```java
if (size < 1 || size > 1000) {
    System.out.println("Array size must be between 1 and 1000.");
}
```

**Element Value Validation:**
```java
if (value < 1 || value > 10000) {
    System.out.println("Value must be between 1 and 10000.");
    continue;
}
```

These checks ensure the program adheres to the specified assignment constraints (1 ≤ size ≤ 1000, 1 ≤ elements ≤ 10000).

### 6. **Recursion in Merge Sort**

Merge Sort is implemented using proper recursion with clear base and recursive cases:

**Recursive Function:**
```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {  // Base case: single element is already sorted
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);        // Recursively sort left half
        mergeSort(arr, mid + 1, right);   // Recursively sort right half
        merge(arr, left, mid, right);     // Merge sorted halves
    }
}
```

**Merge Function:**
```java
public static void merge(int[] arr, int left, int mid, int right) {
    // Create temporary arrays for left and right subarrays
    // Copy data to temporary arrays
    // Merge temporary arrays back into original array
    // Copy remaining elements from both subarrays
}
```

This demonstrates proper divide-and-conquer implementation with efficient subarray merging.

### 7. **Formatted Output**

Both programs use `printf` for aligned, readable output:  
```java
System.out.printf("%-32s %s%n", "Original Unsorted Array:", Arrays.toString(arr));
System.out.printf("%-32s %s%n", "Sorted Array using Bucket Sort:", Arrays.toString(arr));
```

Output example:
```
Original Unsorted Array:        [120, 11, 1345, 50, 6]
Sorted Array using Merge Sort:  [6, 11, 50, 120, 1345]
```

The `%-32s` format specifier ensures left-aligned labels with consistent spacing.  

### 8. **Edge Case Handling**

**Bucket Sort:**
- Empty array check: `if (arr.length <= 0) return;`
- Single element arrays (already sorted)
- Arrays with all identical elements
- Arrays with large negative numbers

**Merge Sort:**
- Single element arrays (base case:   `if (left < right)`)
- Arrays already sorted
- Arrays sorted in reverse order
- Boundary handling in merge function

---

## Algorithm Complexity Analysis

### Bucket Sort

**Time Complexity:**
- Best Case: **O(n + k)** — When elements are uniformly distributed across buckets
- Average Case: **O(n + k)** — With reasonably distributed data
- Worst Case: **O(n²)** — When all elements fall into a single bucket

Where:
- `n` = number of elements
- `k` = number of buckets

**Space Complexity:** **O(n + k)** — For storing elements in buckets

**When to Use:**
- Data is uniformly distributed
- Range of values is known in advance
- Fast sorting needed for specific value ranges

---

### Merge Sort

**Time Complexity:**
- Best Case: **O(n log n)**
- Average Case: **O(n log n)**
- Worst Case: **O(n log n)**

**Space Complexity:** **O(n)** — For temporary arrays during merging

**When to Use:**
- Guaranteed O(n log n) performance needed
- Stable sorting is required
- Large datasets requiring predictable O(n log n) performance
- Linked list sorting

---

## Comparison:   Bucket Sort vs.   Merge Sort

| Feature | Bucket Sort | Merge Sort |
|---------|-------------|------------|
| **Approach** | Distribution-based | Divide-and-conquer |
| **Time (Average)** | O(n + k) | O(n log n) |
| **Space** | O(n + k) | O(n) |
| **Stability** | Yes (if bucket sort is stable) | Yes |
| **Use Case** | Uniformly distributed data | General-purpose sorting |
| **Recursion** | No | Yes |
| **Constraints** | Flexible array size | Strict (1-1000, 1-10000) |

---

## Sample Program Executions

### Bucket Sort Example

```
Enter the number of elements in the array:   8
Enter 8 integer values (can be negative):
Element 1: 45
Element 2: -12
Element 3: 89
Element 4: 0
Element 5: -5
Element 6: 23
Element 7: 67
Element 8: 34

Original Unsorted Array:        [45, -12, 89, 0, -5, 23, 67, 34]
Sorted Array using Bucket Sort:  [-12, -5, 0, 23, 34, 45, 67, 89]
```

### Merge Sort Example

```
Enter the number of elements in the array (1 - 1000): 6
Enter 6 integer values (between 1 and 10000):
Element 1: 9876
Element 2: 234
Element 3: 8765
Element 4: 1234
Element 5: 456
Element 6: 7890

Original Unsorted Array:        [9876, 234, 8765, 1234, 456, 7890]
Sorted Array using Merge Sort:   [234, 456, 1234, 7890, 8765, 9876]
```

---

## Key Learning Outcomes

This assignment demonstrates:

1. ✅ **Distribution-based Sorting** — Understanding bucket allocation strategies
2. ✅ **Divide-and-Conquer Algorithms** — Recursive problem decomposition
3. ✅ **Array Manipulation** — Efficient subarray handling and merging
4. ✅ **Input Validation** — Comprehensive error handling with try-catch blocks
5. ✅ **Algorithm Analysis** — Understanding time/space complexity tradeoffs
6. ✅ **Recursion Mastery** — Implementing and debugging recursive functions
7. ✅ **Edge Case Handling** — Robust handling of empty arrays, negative numbers, and boundary conditions
8. ✅ **Code Documentation** — Clear comments explaining algorithm logic

---

## Additional Notes

- Both programs handle **leading zeros** in numeric input correctly (e.g., "001" is treated as 1)
- **Integer overflow** is prevented by checking against `Integer.MAX_VALUE`
- **User-friendly prompts** guide the user through input requirements
- **Formatted output** ensures readability with aligned labels
- Programs are well-documented with inline comments explaining each step