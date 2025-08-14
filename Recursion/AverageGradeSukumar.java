import java.util.Scanner;
public class AverageGradeSukumar {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String repeat = "";

        do {
            System.out.print("Class size: ");
            int classSize = scan.nextInt();

            if (classSize <= 0){
                System.out.println("Class size should be greater than 0. Please try again.");
                continue;
            }

            int[] grades = new int[classSize];
            System.out.print("Enter grades (between 0 and 100): ");

            for (int i = 0; i < classSize; i++)
            {
                grades[i] = scan.nextInt();
                if (grades[i] < 0 || grades[i] > 100)
                {
                    System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                    i--; // Redo the current index
                }
            }

            double average = computeAverage(grades, classSize - 1);
            System.out.printf("Class average: %.2f\n", average);
            scan.nextLine();

            System.out.print("Try again(Y/N): ");
            repeat = scan.nextLine().trim().toUpperCase();

            if (repeat.equals("Y"))
            {
                System.out.println();
            }
        } while (repeat.equals("Y"));

        System.out.println("End of the Program.");
        scan.close();
    }
    public static double computeAverage(int[] grades, int index) {
        if (index == 0) {
            return grades[0];
        }
        return (grades[index] + index * computeAverage(grades, index - 1)) / (index + 1);
    }
}