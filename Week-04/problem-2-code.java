import java.util.*;

public class SearchProblem {

    // 👨‍🎓 This method divides 'a' by 'b' using repeated subtraction (no /, *, <<, >>)
    public static int intDivide(int a, int b) {
        int count = 0;
        while (a >= b) {
            a = a - b;
            count++;
        }
        return count;  // This is equivalent to a / b
    }

    //  Standard binary search, but we calculate mid manually without /
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Normally we do (low + high) / 2 → Not allowed
            int diff = high - low;
            int half = intDivide(diff, 2);   // simulate (high - low) / 2
            int mid = low + half;

            // Check if target is found at mid
            if (arr[mid] == target) {
                return true;
            }
            // If target is greater, ignore left half
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                high = mid - 1;
            }
        }

        return false;  // If not found
    }

    //  Main method to take user input and call binary search
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter number of elements (N): ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Taking input for array elements (sorted)
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Taking target value to search
        System.out.print("Enter the value to search: ");
        int x = sc.nextInt();

        // Calling our custom binary search function
        boolean result = binarySearch(arr, x);

        // Printing the result
        if (result) {
            System.out.println("true   Element found in the array.");
        } else {
            System.out.println("false  Element not found in the array.");
        }

    }
}
