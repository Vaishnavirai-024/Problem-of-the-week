import java.util.Scanner;

public class SwapEvenOddBits {

    // Approach 1: Brute-force bit-by-bit swap
    public static int swapBitsBruteForce(int n) {
        int result = 0;
        
        for (int i = 0; i < 8; i += 2) {
            // Get the ith bit and (i+1)th bit
            int bitEven = (n >> i) & 1;
            int bitOdd = (n >> (i + 1)) & 1;

            // Swap the bits and set them in the result
            result |= (bitEven << (i + 1));
            result |= (bitOdd << i);
        }
        
        return result;
    }

    // Approach 2: Efficient bitmasking approach (one-liner)
    public static int swapBitsEfficient(int n) {
        return ((n & 0xAA) >> 1) | ((n & 0x55) << 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();

        // Outputs from both approaches
        System.out.println("Brute Force Output: " + swapBitsBruteForce(n));
        System.out.println("Efficient Output: " + swapBitsEfficient(n));

        sc.close();
    }
}
