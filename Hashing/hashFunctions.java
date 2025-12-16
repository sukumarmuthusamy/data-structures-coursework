import java.util.Scanner;

public class hashFunctions {

    // Static array of 50 predefined keys (hardcoded as per assignment instructions)
    static int[] keys = {
            1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523
    };

    // Hash table: 50 rows, 2 columns.
    // [0] to store the key and [1] to store the number of probes for that key
    static int[][] Table = new int[50][2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // To read the user input for MENU options
        int choice = 0;  // Variable to store the user's MENU choice

        do {
            System.out.println("\n----------------------MAIN MENU----------------------");
            System.out.println("1 – Run HF1 (Division method with Linear Probing)");
            System.out.println("2 – Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3 – Run HF3 (Division method with Double Hashing)");
            System.out.println("4 – Run HF4 (Student Designed HF)");
            System.out.println("5 – Exit Program\n");
            System.out.print("Enter option number: ");

            // To handle input with empty or invalid input checks
            String input = scan.nextLine();  // To read the whole line as a String

            // To check if the input is not empty and is a valid integer
            if (input.trim().isEmpty()) {
                System.out.println("Error: You must enter a valid option number.");
                continue;  // skip to the next iteration if the input is empty
            }

            try {
                choice = Integer.parseInt(input);  // To parse the input to an integer

                // To ensure the user choice is within a valid range
                if (choice < 1 || choice > 5) {
                    System.out.println("Error: Invalid option. Please enter a number between 1 and 5.");
                    continue;  // skip to the next iteration if the option is out of range
                }

                // Switch case logics
                switch (choice) {
                    case 1:
                        clearTable();
                        HF1();
                        printTable("HF1");
                        break;
                    case 2:
                        clearTable();
                        HF2();
                        printTable("HF2");
                        break;
                    case 3:
                        clearTable();
                        HF3();
                        printTable("HF3");
                        break;
                    case 4:
                        clearTable();
                        HF4();
                        printTable("HF4");
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Error: Invalid option.");
                }

            } catch (NumberFormatException e) {
                // To handle non-numeric input
                System.out.println("Error: Please enter a number between 1 and 5.");
            }

        } while (choice != 5);  // The loop will continue until option 5 (Exit)
    }

    // To clear the hash table before each HF run
    static void clearTable() {
        for (int i = 0; i < 50; i++) {
            Table[i][0] = -1;  // -1 means empty slot
            Table[i][1] = 0;   // Reset the probe count to 0
        }
    }

    // To sum all probes from the second column
    // This sum provides a measure of the overall efficiency of the hash function.
    static int sumProbes() {
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            sum += Table[i][1];   // To add the probe count for each key to the sum
        }
        return sum;
    }

    // To display table and probe sum
    static void printTable(String hfName) {
        System.out.println("\nHash table resulted from " + hfName + ":");

        // Column headers
        System.out.printf("%-7s %-8s %-6s\n", "Index", "Key", "Probes");
        System.out.println("----------------------------");

        // To iterate through the hash table and print each entry
        for (int i = 0; i < 50; i++) {
            if (Table[i][0] != -1) {
                System.out.printf("%-7d %-8d %-6d\n", i, Table[i][0], Table[i][1]);
            }
        }

        System.out.println("----------------------------");
        System.out.println("Sum of probe values = " + sumProbes() + " probes.\n");
    }

    // HF1: Division method for hashing with Linear Probing for collision resolution.
    static void HF1() {
        for (int key : keys) {
            int index = key % 50;  // To calculate the initial hash index using the division method (key % tableSize)
            int probes = 0;

            // Linear Probing: Keep searching for an empty slot by incrementing the index until an empty slot is found
            while (Table[index][0] != -1) {
                index = (index + 1) % 50;
                probes++;
            }

            Table[index][0] = key;  // To store the key in the found empty slot
            Table[index][1] = probes;  // To store the number of probes it took to find the slot
        }
    }

    // HF2: Division method for hashing with Quadratic Probing for collision resolution.
    static void HF2() {
        for (int key : keys) {
            int baseIndex = key % 50; // To calculate the initial hash index using the division method (key % tableSize)
            int index = baseIndex;    // To initialize the current index to the base index
            int j = 1;
            int probes = 0;

            // Quadratic Probing: Search for an empty slot using a quadratic probing sequence
            while (Table[index][0] != -1) {
                index = (baseIndex + j * j) % 50;
                j++;
                probes++;
            }

            Table[index][0] = key;   // To store the key in the found empty slot
            Table[index][1] = probes;  // To store the number of probes it took to find the slot
        }
    }

    // HF3: Division method for hashing with Double Hashing for collision resolution.
    static void HF3() {
        for (int key : keys) {
            int h1 = key % 50;  // To calculate the initial hash index (h1) using the division method (key % tableSize)
            int h2 = 30 - (key % 25);  // To calculate the secondary hash value (h2) using the provided formula
            int index = h1;
            int probes = 0;
            boolean stored = false;   // Flag to indicate if the key has been successfully stored

            // Double Hashing: Resolve collisions using a secondary hash function to calculate the probe increment
            for (int j = 0; j < 50; j++) {  // Probe up to 50 times to avoid infinite loops (as per assignment instructions)
                index = (h1 + j * h2) % 50;  // To calculate the next index using the double hashing formula: (h1 + j * h2) % tableSize
                if (Table[index][0] == -1) {
                    Table[index][0] = key;
                    Table[index][1] = probes;
                    stored = true;
                    break;    // To exit the loop since the key has been stored
                }
                probes++;
            }

            // If the key could not be stored after 50 probes, print the following error message
            if (!stored) {
                System.out.println("Unable to hash key " + key + " to the table");
            }
        }
    }

    // HF4: Custom Hash Function (Enhanced Version)
    // This function implements a custom hash function that combines the Mid-Square Method (3-digit) for initial hashing
    // with Quadratic Probing for collision resolution. The goal is to achieve a good distribution of keys
    // within the hash table and minimize the number of probes required for successful insertion.

    static void HF4() {
        for (int key : keys) {
            long square = (long) key * key;    // To calculate the square of the key (using long to avoid potential integer overflow)
            String squareStr = String.valueOf(square);  // To convert the square to a string for digit extraction

            // Mid-Square Method: Extract digits from the middle of the square to generate the initial hash value
            int hashVal;
            int len = squareStr.length();    // To get the length of the squared value (as a string)
            if (len >= 5) {    // If the square has 5 or more digits, extract 3 digits from the middle
                int mid = len / 2;   // To calculate the middle index

                try {
                    hashVal = Integer.parseInt(squareStr.substring(mid - 1, mid + 2));  // To extract 3 digits around the middle
                } catch (Exception e) {
                    hashVal = key % 50; // If any error occurs during extraction (e.g., NumberFormatException), fallback to division method
                }
            } else {
                hashVal = key % 50; // If the square has less than 5 digits, use the division method as a fallback
            }

            int baseIndex = hashVal % 50;
            int index = baseIndex;
            int j = 1;
            int probes = 0;
            boolean placed = false;   // Flag to indicate if the key has been successfully placed in the table

            // Quadratic Probing: Resolve collisions by probing quadratically for an empty slot
            for (int attempt = 0; attempt < 50; attempt++) {  // Probe up to 50 times to avoid infinite loops
                if (Table[index][0] == -1) {  // If the current slot is empty
                    Table[index][0] = key;    // To store the key in the slot
                    Table[index][1] = probes;
                    placed = true;            // To set the placed flag to true
                    break;                   // Exit the loop since the key has been placed
                }
                index = (baseIndex + j * j) % 50;  // To calculate the next index using the quadratic probing formula
                j++;
                probes++;
            }

            // If the key could not be placed after 50 attempts, print the following error message
            if (!placed) {
                System.out.println("Unable to hash key " + key + " using HF4");
            }
        }
    }
}