// Approach1_BruteForce.java
import java.util.*;

public class Approach1_BruteForce {

    public static int gcdOfArray(int[] arr) {
        int minVal = Arrays.stream(arr).min().getAsInt();

        // Check from minVal down to 1
        for (int divisor = minVal; divisor >= 1; divisor--) {
            boolean isGCD = true;
            for (int num : arr) {
                if (num % divisor != 0) {
                    isGCD = false;
                    break;
                }
            }
            if (isGCD) return divisor; // first match will be the largest
        }
        return 1; // If nothing else, 1 is always a divisor
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(gcdOfArray(arr));
        sc.close();
    }
}


// ......................................................................................................................

// Approach2_Euclidean.java
import java.util.*;

public class Approach2_Euclidean {

    // Function to find GCD of two numbers using Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to find GCD of an array
    public static int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) return 1; // No need to check further
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(gcdOfArray(arr));
        sc.close();
    }
}
