import java.util.Scanner;

public class LastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Calculate the length of the last word
        int lastWordLength = lengthOfLastWord(input);

        // Display the result
        System.out.println("Length of the last word: " + lastWordLength);

        // Close the scanner
        scanner.close();
    }

    private static int lengthOfLastWord(String s) {
        // Trim the input to remove leading and trailing spaces
        s = s.trim();

        // Find the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(' ');

        // If no space is found, return the length of the entire string
        if (lastSpaceIndex == -1) {
            return s.length();
        }

        // Return the length of the last word
        return s.length() - lastSpaceIndex - 1;
    }
}
