import java.util.*;

public class MajorityElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Find elements that appear more than ⌊ n/3 ⌋ times
        List<Integer> result = findMajorityElements(nums);

        // Display the result
        System.out.println("Elements appearing more than ⌊ n/3 ⌋ times: " + result);

        // Close the scanner
        scanner.close();
    }

    private static List<Integer> findMajorityElements(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        // Find candidates for majority elements using Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Reset counts for candidates
        count1 = 0;
        count2 = 0;

        // Count occurrences of candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Check if candidates appear more than ⌊ n/3 ⌋ times
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}
