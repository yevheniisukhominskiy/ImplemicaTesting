import java.math.BigInteger;

public class EntryPoint {
    public static void main(String[] args) {
        int num = 100;

        // Calculate factorial
        BigInteger factorialResult = factorial(num);
        // Output the sum of numbers
        System.out.println("Sum of digits in factorial of " + num + " is " + sumOfDigits(factorialResult));
    }

    // Method to calculate factorial
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));    // Multiply by the current number
        }
        return result;
    }

    // Method for calculating the sum of the digits of a number
    public static int sumOfDigits(BigInteger num) {
        // Convert factorial to string
        String string = num.toString();
        int sum = 0;

        // Loop through each character of the string and add up the numbers
        for (int i = 0; i < string.length(); i++) {
            // Convert the symbol to a number and add to the sum
            sum += Character.getNumericValue(string.charAt(i));
        }
        return sum;
    }
}
