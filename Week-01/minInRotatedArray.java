//                                           Brute Force Solution

// 🔹 Time Complexity: O(n)
// 🔹 Space Complexity: O(1)
// 🔸 Logic: Traverse the entire array and keep track of the minimum value found.

import java.util.Scanner;

public class minInRotatedArray_brute {

    // Function to find the minimum element in the array
    public static int findMin(int[] arr) {
        int min = arr[0]; // Assume the first element is the minimum

        // Check every element and update min if a smaller value is found
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min; // Return the minimum element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for the size of the array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Take input for the elements of the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print the minimum element found
        System.out.println(findMin(arr));
    }
}
// ............................................................................................................................

//                                         Optimal Solution using Binary Search


// 🔹 Time Complexity: O(log n)
// 🔹 Space Complexity: O(1)
// 🔸 Logic:
//    - If mid > right, the minimum lies in the right half
//    - Otherwise, the minimum is in the left half (including mid)

import java.util.Scanner;

public class minInRotatedArray_optimal {

    // Function to find the minimum using binary search
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Binary search loop
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the last element,
            // the minimum lies in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Otherwise, the minimum is in the left half
                high = mid;
            }
        }

        // When low == high, we've found the minimum element
        return arr[low];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Output the minimum element
        System.out.println(findMin(arr));
    }
}
