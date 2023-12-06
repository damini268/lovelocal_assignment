import java.util.Scanner;

public class CountDigitOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        // Count the total number of digit 1
        int count = countDigitOne(n);

        // Display the result
        System.out.println("Total number of digit 1 appearing in integers up to " + n + ": " + count);

        // Close the scanner
        scanner.close();
    }

    private static int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += countOnesInNumber(i);
        }
        return count;
    }

    private static int countOnesInNumber(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 1) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
