import java.util.Scanner;
public class PrintReverseSukumar {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String repeat;

        do {
            System.out.print("Entered string: ");
            String input = scan.nextLine();

            System.out.print("Reversed string: ");
            printCharsReverse(input);
            System.out.println();

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

public static void printCharsReverse(String str){
        if (str == null || str.isEmpty()){
            return;
        }
        System.out.print(str.charAt(str.length() - 1));
        printCharsReverse(str.substring(0,str.length()-1));
}
}