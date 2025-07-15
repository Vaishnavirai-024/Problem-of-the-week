//                                                   Brute Force Approach 
// Time Complexity: O(n^2)
// Space Complexity: O(1)

import java.util.*;

public class subarraySumEqualsK {

    public static int countSub(int[] nums, int k) {
        int count = 0;

        // Try all subarrays starting from index i
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            // Add elements from i to j and check if sum == k
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++; // Valid subarray found
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target value k
        int k = sc.nextInt();

        // Print the number of subarrays with sum = k
        System.out.println(countSub(nums, k));
    }
}

// ...............................................................................................................................


//                                               Optimized Approach 

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class subarraySumEqualsK {

    public static int countSub(int[] nums, int k) {
        // Map to store prefix sum frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // For the case when subarray starts from index 0

        int sum = 0;    // Current prefix sum
        int count = 0;  // Total subarrays found

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Update prefix sum

            // Check if there's a prefix sum that would make (sum - k)
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // Add the number of such occurrences
            }

            // Store/update the frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input elements of array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input the target sum k
        int k = sc.nextInt();

        // Print the number of subarrays with sum equal to k
        System.out.println(countSub(nums, k));
    }
}

