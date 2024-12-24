import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BracketsGenerator {
    private int pair;   // Number of pairs of brackets

    // Getter
    public int getPair() {
        return pair;
    }

    // Constructor without parameters
    public BracketsGenerator() {
        readDataFromKeyboard();
    }

    // Method for entering data from the keyboard
    private void readDataFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            System.out.print("Enter pair number: ");

            try {
                num = Integer.parseInt(scanner.nextLine());
                // Checking the validity of input data
                if (num < 0) {
                    System.out.println("Please try again! Number of pairs cannot be negative.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Number must be a positive!" + e.getMessage());
            }
        }
        pair = num;
    }

    // Method to start generating list of expressions
    public List<String> generateBracketsList() {
        List<String> result = new ArrayList<>();
        generateExpression(result, "", pair, pair);
        return result;
    }

    // Recursive method for generating expressions
    private void generateExpression(List<String> result, String string, int start, int end) {
        // Checking for negative values
        if (start < 0 || end < start) {
            return;
        }

        // If nothing more to add
        if (start == 0 && end == 0) {
            result.add(string);
        }

        // Add an opening bracket '(' if they exist
        if (start > 0) {
            generateExpression(result, string + '(', start - 1, end);
        }

        // Add a closing bracket ')' if they exist
        if (end > start) {
            generateExpression(result, string + ')', start, end - 1);
        }
    }
}
