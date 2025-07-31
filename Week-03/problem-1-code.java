 //                                          Brute Force (Recursion Only)

import java.util.*;

public class EqualSumPartitionBruteForce {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, it can't be split evenly
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        return canFindSubset(nums, 0, target);
    }

    // Recursive function to check if subset with given sum exists
    private static boolean canFindSubset(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        // Choice: include or exclude the current number
        boolean include = canFindSubset(nums, index + 1, target - nums[index]);
        boolean exclude = canFindSubset(nums, index + 1, target);

        return include || exclude;
    }

    public static void main(String[] args) {
        int[] example1 = {15, 5, 20, 10, 35, 15, 10};
        int[] example2 = {15, 5, 20, 10, 35};

        System.out.println("Example 1: " + canPartition(example1)); // Output: true
        System.out.println("Example 2: " + canPartition(example2)); // Output: false
    }
}

// ......................................................................................................................

//                                                  DP with Memoization

import java.util.*;

public class EqualSumPartition {

    public static boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();

        if (total % 2 != 0) return false;

        int target = total / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return canPartitionHelper(nums, 0, target, memo);
    }

    private static boolean canPartitionHelper(int[] nums, int i, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        if (memo[i][target] != null) return memo[i][target];

        // include or exclude
        boolean include = canPartitionHelper(nums, i + 1, target - nums[i], memo);
        boolean exclude = canPartitionHelper(nums, i + 1, target, memo);

        memo[i][target] = include || exclude;
        return memo[i][target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{15, 5, 20, 10, 35, 15, 10})); // true
        System.out.println(canPartition(new int[]{15, 5, 20, 10, 35})); // false
    }
}

// ......................................................................................................................

//                                   DP with 1D Bottom-Up Tabulation (Optimized)

public class EqualSumPartitionBottomUp {

    public static boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{15, 5, 20, 10, 35, 15, 10})); // true
        System.out.println(canPartition(new int[]{15, 5, 20, 10, 35})); // false
    }
}
