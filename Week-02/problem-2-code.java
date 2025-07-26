//                              1. Brute Force Using Subset Sums (DFS or Bitmask)

import java.util.*;

public class BruteForceSubsetSum {
    static Set<Integer> sums = new HashSet<>();

    public static void findSubsets(int[] arr, int index, int currentSum) {
        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }
        // include
        findSubsets(arr, index + 1, currentSum + arr[index]);
        // exclude
        findSubsets(arr, index + 1, currentSum);
    }

    public static int getSmallestMissing(int[] arr) {
        findSubsets(arr, 0, 0);
        int smallest = 1;
        while (sums.contains(smallest)) {
            smallest++;
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10};
        System.out.println(getSmallestMissing(arr)); // Output: 7
    }
}

// ................................................................................................................................

//                                          2. DP-Based Subset Sum (Tabulation)

import java.util.*;

public class DpSubsetSum {
    public static int getSmallest(int[] arr) {
        int maxSum = Arrays.stream(arr).sum();
        boolean[] dp = new boolean[maxSum + 2];
        dp[0] = true;

        for (int coin : arr) {
            for (int j = maxSum; j >= coin; j--) {
                if (dp[j - coin]) {
                    dp[j] = true;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (!dp[i]) return i;
        }

        return maxSum + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10};
        System.out.println(getSmallest(arr)); // Output: 7
    }
}

// ................................................................................................................................

//                                   3. Greedy Approach (Efficient for Large Input)


public class GreedySubsetSum {
    public static int findSmallest(int[] coins) {
        long res = 1; // smallest sum not yet representable
        for (int coin : coins) {
            if (coin > res) break;
            res += coin;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10};
        System.out.println(findSmallest(arr)); // Output: 7
    }
}

// ................................................................................................................................


//                                          4. Follow-up Variation (Unsorted Input)
//  Extra Case:
// If the input array is not sorted, you must sort it first before applying greedy logic.


// Arrays.sort(arr); // Important if input is not sorted
