import java.util.*;

// Main class to test different approaches
public class MajorityElement {

    // ---------- Approach 1: Boyer-Moore Voting (O(n), O(1)) ----------
    public static int majorityElementBoyerMoore(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate; // Problem guarantees existence
    }

    // ---------- Approach 2: HashMap Counting (O(n), O(n)) ----------
    public static int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1; // never reached since majority exists
    }

    // ---------- Approach 3: Sorting (O(n log n), O(1)) ----------
    public static int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // ---------- Approach 4: Divide & Conquer (O(n log n)) ----------
    public static int majorityElementDivideConquer(int[] nums) {
        return majorityRec(nums, 0, nums.length - 1);
    }

    private static int majorityRec(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftMajor = majorityRec(nums, left, mid);
        int rightMajor = majorityRec(nums, mid + 1, right);

        if (leftMajor == rightMajor) return leftMajor;

        int leftCount = countInRange(nums, leftMajor, left, right);
        int rightCount = countInRange(nums, rightMajor, left, right);

        return leftCount > rightCount ? leftMajor : rightMajor;
    }

    private static int countInRange(int[] nums, int target, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }

    // ---------- Approach 5: Bit Manipulation (O(32*n), O(1)) ----------
    public static int majorityElementBitManipulation(int[] nums) {
        int n = nums.length, result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) bitCount++;
            }
            if (bitCount > n / 2) {
                result |= (1 << i);
            }
        }
        return result;
    }

    // ---------- Driver Code ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Boyer-Moore: " + majorityElementBoyerMoore(arr.clone()));
        System.out.println("HashMap: " + majorityElementHashMap(arr.clone()));
        System.out.println("Sorting: " + majorityElementSorting(arr.clone()));
        System.out.println("Divide & Conquer: " + majorityElementDivideConquer(arr.clone()));
        System.out.println("Bit Manipulation: " + majorityElementBitManipulation(arr.clone()));
    }
}
