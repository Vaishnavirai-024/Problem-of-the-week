import java.util.*;

public class FirstMissingPositive {

    // Approach 1: Naive approach using HashSet (extra space used, O(n) time, O(n) space)
    public static int firstMissingPositiveNaive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

    // Approach 2: Sorting-based approach (O(n log n) time, O(1) or O(n) depending on sort)
    public static int firstMissingPositiveSorting(int[] nums) {
        Arrays.sort(nums); // O(n log n)
        int smallest = 1;
        for (int num : nums) {
            if (num == smallest) {
                smallest++;
            }
        }
        return smallest;
    }

    // Approach 3: Optimal approach – In-place Hashing / Index placement trick (O(n) time, O(1) space)
    public static int firstMissingPositiveOptimal(int[] nums) {
        int n = nums.length;

        // Place each number in its correct index (x -> index x-1)
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 && nums[i] <= n && 
                nums[nums[i] - 1] != nums[i]
            ) {
                // Swap nums[i] with nums[nums[i]-1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // After placement, the first index where nums[i] != i+1 is the answer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers are in correct position, answer is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        // You can choose which approach to use
        System.out.println("Naive Approach Output: " + firstMissingPositiveNaive(Arrays.copyOf(nums, nums.length)));
        System.out.println("Sorting Approach Output: " + firstMissingPositiveSorting(Arrays.copyOf(nums, nums.length)));
        System.out.println("Optimal Approach Output: " + firstMissingPositiveOptimal(nums));
        
        sc.close();
    }
}
