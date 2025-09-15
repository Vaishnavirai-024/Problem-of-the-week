import java.util.*;

public class LongestIncreasingSubsequence {

    // Approach 1: Recursive + Memoization (Top-Down DP)
    public int lengthOfLISRecursive(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return helper(nums, 0, -1, memo);
    }

    private int helper(int[] nums, int index, int prevIndex, int[][] memo) {
        if (index == nums.length)
            return 0;
        if (memo[index][prevIndex + 1] != -1)
            return memo[index][prevIndex + 1];

        int taken = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            taken = 1 + helper(nums, index + 1, index, memo);
        }
        int notTaken = helper(nums, index + 1, prevIndex, memo);

        memo[index][prevIndex + 1] = Math.max(taken, notTaken);
        return memo[index][prevIndex + 1];
    }

    // Approach 2: Bottom-Up DP (Classic DP)
    public int lengthOfLISBottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // Approach 3: Optimized with Binary Search (Patience Sorting)
    public int lengthOfLISBinarySearch(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(temp, num);
            if (index < 0)
                index = -(index + 1);
            if (index == temp.size())
                temp.add(num);
            else
                temp.set(index, num);
        }
        return temp.size();
    }

    // Main method with menu
    public static void main(String[] args) {
        LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Choose approach:");
        System.out.println("1. Recursive + Memoization (Top-Down DP)");
        System.out.println("2. Bottom-Up DP (Classic DP)");
        System.out.println("3. Optimized with Binary Search");

        int choice = sc.nextInt();
        int result = 0;
        switch (choice) {
            case 1:
                result = solver.lengthOfLISRecursive(nums);
                break;
            case 2:
                result = solver.lengthOfLISBottomUp(nums);
                break;
            case 3:
                result = solver.lengthOfLISBinarySearch(nums);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        System.out.println("Length of Longest Increasing Subsequence: " + result);
        sc.close();
    }
}
