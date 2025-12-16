import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class defines a single node in the BST
class TreeNode {
    int key;
    TreeNode left, right;

    // Constructor to initialize a new node with a key
    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;
    private final List<Integer> insertedOrder = new ArrayList<>();

    // To insert a key into the BST
    public void insert(int key) {
        root = insertRec(root, key); // To start inserting from the root
    }

    // Recursive method to handle the actual insertion logic
    private TreeNode insertRec(TreeNode node, int key) {
        if (node == null) {
            insertedOrder.add(key);  // To track the insertion order
            return new TreeNode(key);
        }

        // If the key already exists in the tree, we skip insertion
        if (key == node.key) {
            System.out.println("Duplicate key " + key + " not inserted.");
        }
        // If the key is smaller, go left
        else if (key < node.key) {
            node.left = insertRec(node.left, key);
        }
        // If the key is larger, go right
        else {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    // To search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);  // To start the search from the root
    }

    // Recursive function to search for the key in the BST
    private boolean searchRec(TreeNode node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? searchRec(node.left, key) : searchRec(node.right, key);
    }

    // To delete a key from the BST
    public void delete(int key) {
        // If the key isn't found in the tree, print a message and skip deletion
        if (!search(key)) {
            System.out.println("Key " + key + " not found. Deletion skipped.");
        } else {
            System.out.println("Deleting " + key + "...");
            root = deleteRec(root, key);  // To perform recursive deletion
            insertedOrder.remove(Integer.valueOf(key)); // Also to remove it from the insertion order list
        }
    }

    // Recursive function to delete a node from the BST
    private TreeNode deleteRec(TreeNode node, int key) {
        if (node == null) return null;  // Base case: if we reach a null node, to return null

        if (key < node.key) {   // If the key is smaller, continue searching in the left subtree
            node.left = deleteRec(node.left, key);
        }
        else if (key > node.key) {  // If the key is greater, continue searching in the right subtree
            node.right = deleteRec(node.right, key);
        }
        else {            // Found the node to delete
            if (node.left == null) return node.right; // Case 1: No left child -> replace node with its right child
            if (node.right == null) return node.left; // Case 2: No right child -> replace node with its left child

            // Case 3: Node has two children
            // Find the smallest value in the right subtree (inorder successor)
            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key);  // To delete the inorder successor from the right subtree
        }
        return node;
    }

    // Get the minimum value in the BST (This is used in deletion)
    private int minValue(TreeNode node) {
        // To keep going left until we reach the smallest value
        while (node.left != null) node = node.left;
        return node.key;
    }

    // To print the elements in the order they were inserted (not sorted)
    public void displayInsertedAligned() {
        System.out.printf("%-18s: ", "Inserted");
        for (int num : insertedOrder) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // To print the BST using inorder traversal
    public void displayInorderAligned() {
        System.out.printf("%-18s: ", "Inorder Traversal");
        inorderRec(root);
        System.out.println();
    }

    // Recursive helper for inorder traversal
    // This will visit nodes in ascending order (Left -> Root -> Right)
    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.key + " ");
            inorderRec(node.right);
        }
    }

    // To print the tree height
    public void displayHeightAligned(String label) {
        System.out.printf("%-18s: %d\n", label, height());
    }

    // To return the height of the BST
    public int height() {
        return heightRec(root);
    }

    // Recursive function to calculate height of a subtree
    private int heightRec(TreeNode node) {
        if (node == null) return 0;  // Base case: empty subtree has height 0
        return Math.max(heightRec(node.left), heightRec(node.right)) + 1;  // Height is 1 + max height of left or right subtree
    }

    // To return the number of successfully inserted unique elements
    public int size() {
        return insertedOrder.size();
    }

    // To check if the BST is empty
    public boolean isEmpty() {
        return insertedOrder.isEmpty();
    }
}

public class BSTDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        boolean treeInitialized = false;

        while (true) {
            // Phase 1 MENU (before minimum 10 insertions)
            // This menu is shown before the user inserts the first 10 elements
            if (!treeInitialized) {
                System.out.println("\n-------- MENU --------");
                System.out.println("1. Insert at least 10 elements");
                System.out.println("2. Search an element");
                System.out.println("3. Delete an element");
                System.out.println("4. Exit the program");

                int choice = getValidatedInteger(scan, "Enter your choice (1-4): ", 1, 4);

                switch (choice) {
                    // To start collecting 10 unique elements from the user
                    case 1:
                        int count = bst.size();
                        while (count < 10) {
                            System.out.print("Enter element " + (count + 1) + ": ");
                            String input = scan.nextLine().trim();

                            if (input.isEmpty()) {
                                System.out.println("Input cannot be empty. Please enter a number.");
                                continue;
                            }

                            try {
                                int num = Integer.parseInt(input);
                                int before = bst.size();
                                bst.insert(num);
                                if (bst.size() > before) count++;  // To only count unique insertions
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter an integer number.");
                            }
                        }

                        // To display inserted results after 10 insertions
                        bst.displayInsertedAligned();
                        bst.displayInorderAligned();
                        bst.displayHeightAligned("Height of BST");
                        treeInitialized = true; // switch to phase 2 MENU
                        break;

                    // To prevent user from searching or deleting before insertion
                    case 2:
                    case 3:
                        System.out.println("No elements in the tree. Please select option 1 to add elements first.");
                        break;

                    case 4:
                        System.out.println("Exiting program.");
                        scan.close();
                        return;
                }
            }

            // Phase 2 MENU. This menu appears once the BST is initialized with at least 10 elements.
            else {
                System.out.println("\n-------- MENU --------");
                System.out.println("1. Search an element");
                System.out.println("2. Insert one more element");
                System.out.println("3. Delete an element");
                System.out.println("4. Exit the program");

                int choice = getValidatedInteger(scan, "Enter your choice (1-4): ", 1, 4);

                switch (choice) {
                    // To search for an element in the BST
                    case 1:
                        int searchKey = getValidatedInteger(scan, "Enter element to search: ", null, null);
                        boolean found = bst.search(searchKey);
                        System.out.println("Search " + searchKey + ": " + (found ? "Found" : "Not Found"));
                        break;

                    // To insert one more element and display updated BST
                    case 2:
                        while (true) {
                            int insertKey = getValidatedInteger(scan, "Enter element to insert: ", null, null);
                            int before = bst.size();
                            bst.insert(insertKey);

                            // Only break the loop if the element was not a duplicate
                            if (bst.size() > before) {
                                bst.displayInsertedAligned();
                                bst.displayInorderAligned();
                                bst.displayHeightAligned("Height of BST");
                                break;
                            }
                            // If it's a duplicate, user stays in the loop and is re-prompted
                        }
                        break;

                    // To delete an element and display updated BST
                    case 3:
                        int deleteKey = getValidatedInteger(scan, "Enter element to delete: ", null, null);
                        bst.delete(deleteKey);
                        bst.displayInorderAligned();
                        bst.displayHeightAligned("Height of BST after deletion");
                        break;

                    case 4:
                        System.out.println("Exiting program.");
                        scan.close();
                        return;
                }
            }
        }
    }

    // Utility method to get a valid integer input with optional range checks
    private static int getValidatedInteger(Scanner scanner, String prompt, Integer min, Integer max) {

        // We use this flag to decide whether the prompt is part of a MENU. If yes, we will show a more specific error message.
        boolean isMenu = prompt.toLowerCase().contains("choice");

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            try {
                int value = Integer.parseInt(input);
                if (min != null && value < min || max != null && value > max) {
                    if (isMenu) {
                        System.out.println("Invalid input. Please enter a valid integer number between " + min + " and " + max + ".");
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                if (isMenu) {
                    System.out.println("Invalid input. Please enter a valid integer number between " + min + " and " + max + ".");
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
        }
    }
}