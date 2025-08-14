# Recursion Assignments

Small Java programs demonstrating recursion concepts from the Data Structures coursework.

## Programs
- **PrintReverseSukumar.java** — Recursively prints a string in reverse (one character per call).
- **AverageGradeSukumar.java** — Reads N grades and computes the class average using recursion.

## How to Run

**PrintReverseSukumar.java**
```bash
javac PrintReverseSukumar.java
java PrintReverseSukumar
```

**AverageGradeSukumar.java**
```bash
javac AverageGradeSukumar.java
java AverageGradeSukumar
```

## Program Details

### 1. PrintReverseSukumar.java
**Goal:** Prompt for a string and print it in reverse using the recursive method `printCharsReverse(String str)`.  
**Key idea:** Each recursive call prints exactly one character.

**Sample Run:**
```
Entered string: Hello world
Reversed string: dlrow olleH
Try again(Y/N): Y

Entered string: Data Structures and Algorithms
Reversed string: smhtiroglA dna serutcurtS ataD
Try again(Y/N): N

End of the Program.
```

### 2. AverageGradeSukumar.java
**Goal:** Read the class size (integer), then read that many grades (0–100) into an array. Use the recursive method `computeAverage(...)` to calculate and return the class average as a double.  
**Key idea:** The recursion works by summing the grades one at a time and dividing by the total number of grades once the base case is reached.

**Sample Runs:**
```
Class size: 3
Entered grades: 100 100 100
Class average: 100.00

Class size: 7
Entered grades: 50 75 80 80 40 35 85
Class average: 63.57
```
