import java.util.*;

public class bucketSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = 0;

        // Step 1: To ask user for the array size with input validation
        while (true) {
            System.out.print("Enter the number of elements in the array: ");
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid number.");
                continue;
            }

            try {
                long longSize = Long.parseLong(input); // To allow detection of too-large numbers safely

                if (longSize > Integer.MAX_VALUE) {  // To prevent integer overflow by checking before casting to int
                    System.out.println("Number is too large. Please enter a smaller number (max " + Integer.MAX_VALUE + ").");
                    continue;
                }

                size = (int) longSize;

                if (size > 0) {
                    break;
                } else {
                    System.out.println("Array size must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        // Step 2: To read array elements with full validation
        int[] arr = new int[size];
        System.out.println("Enter " + size + " integer values (can be negative):");
        for (int i = 0; i < size; ) {
            System.out.print("Element " + (i + 1) + ": ");
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter an integer.");
                continue;
            }

            try {
                arr[i] = Integer.parseInt(input); // This parses string to int. Leading zeros like '001' are treated as valid integers
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        // Step 3: To print the original unsorted array
        System.out.printf("%-32s %s%n", "Original Unsorted Array:", Arrays.toString(arr));

        // Step 4: To perform Bucket Sorting
        bucketSort(arr);

        // Step 5: To print the sorted array
        System.out.printf("%-32s %s%n", "Sorted Array using Bucket Sort:", Arrays.toString(arr));
    }

    // Bucket Sort Algorithm implementation
    public static void bucketSort(int[] arr) {
        if (arr.length <= 0) return;

        // To find max and min values
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // To create buckets based on value range
        int bucketCount = (max - min) / 10 + 1;  // To dynamically choose bucket count based on spread of values
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // To distribute the numbers into buckets
        for (int num : arr) {
            int bucketIndex = (num - min) / 10;  // To ensure correct bucket placement even for negative numbers
            buckets.get(bucketIndex).add(num);
        }

        // To sort each bucket and merge
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);  // built-in Java sort for individual buckets
            for (int num : bucket) {
                arr[index++] = num;  // To flatten sorted buckets into original array
            }
        }
    }
}