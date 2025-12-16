import java.util.Arrays;
import java.util.Scanner;

public class mergeSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = 0;

        // Step 1: To ask user for the array size with input validation
        while (true) {
            System.out.print("Enter the number of elements in the array (1 - 1000): ");
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid number.");
                continue;
            }

            try {
                long longSize = Long.parseLong(input); // To allow detection of too-large numbers safely

                if (longSize > Integer.MAX_VALUE) {   // To prevent integer overflow by checking before casting to int
                    System.out.println("Number too large. Please enter a smaller number (max " + Integer.MAX_VALUE + ").");
                    continue;
                }

                size = (int) longSize;
                if (size < 1 || size > 1000) {
                    System.out.println("Array size must be between 1 and 1000.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        // Step 2: To read array elements with validation
        int[] arr = new int[size];
        System.out.println("Enter " + size + " integer values (between 1 and 10000):");

        for (int i = 0; i < size; ) {
            System.out.print("Element " + (i + 1) + ": ");
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter an integer between 1 and 10000.");
                continue;
            }

            try {
                int value = Integer.parseInt(input); // This parses string to int. Leading zeros like '001' are treated as valid integers
                if (value < 1 || value > 10000) {
                    System.out.println("Value must be between 1 and 10000.");
                    continue;
                }
                arr[i] = value;
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer between 1 and 10000.");
            }
        }

        // Step 3: To print the original unsorted array
        System.out.printf("%-30s %s%n", "Original Unsorted Array:", Arrays.toString(arr));

        // Step 4: To perform Merge Sorting
        mergeSort(arr, 0, arr.length - 1);

        // Step 5: To print the sorted array
        System.out.printf("%-30s %s%n", "Sorted Array using Merge Sort:", Arrays.toString(arr));
    }

    // Recursive Merge Sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);        // To sort the left half
            mergeSort(arr, mid + 1, right);   // To sort the right half
            merge(arr, left, mid, right);     // To merge the sorted halves
        }
    }

    // To merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // To copy the data to temporary arrays
        for (int i = 0; i < size1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < size2; j++)
            rightArray[j] = arr[mid + 1 + j];

        // To merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // To copy the remaining elements
        while (i < size1) arr[k++] = leftArray[i++];
        while (j < size2) arr[k++] = rightArray[j++];
    }
}