// Legendre's 3-square theorem + DP approaches in Java
// Problem: Find the minimum number of perfect squares that sum up to a given number n

class Solution {
    // Legendre's 3-square theorem based solution
    public int numSquares(int n) {
        // Case 1: If n is already a perfect square, answer = 1
        int sqrtN = (int) Math.sqrt(n);
        if (sqrtN * sqrtN == n) {
            return 1;
        }

        // Case 2: Remove factors of 4 (Legendre’s theorem says this doesn’t affect result)
        while (n % 4 == 0) {
            n /= 4;
        }

        // Case 3: If number becomes of the form (8b + 7), then it needs 4 squares
        if (n % 8 == 7) {
            return 4;
        }

        // Case 4: Check if the number can be represented as the sum of 2 squares
        for (int i = 1; i * i <= n; i++) {
            int remainder = n - i * i;
            int sqrtRem = (int) Math.sqrt(remainder);
            if (sqrtRem * sqrtRem == remainder) {
                return 2; // Found two perfect squares
            }
        }

        // Case 5: Otherwise, it must be 3 (as per theorem)
        return 3;
    }

    // ------------------- Alternative Approaches -------------------

    // DP Tabulation approach (bottom-up)
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Worst case: i = 1+1+1... (i times)
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }
        return dp[n];
    }

    // Recursion + Memoization
    private int[] memo;

    private int solveMemo(int n) {
        if (n <= 3) return n;
        if (memo[n] != -1) return memo[n];

        int ans = n; // Worst case: n = 1+1+1... (n times)
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solveMemo(n - i * i));
        }

        memo[n] = ans;
        return ans;
    }

    public int numSquaresMemo(int n) {
        memo = new int[n + 1];
        java.util.Arrays.fill(memo, -1);
        return solveMemo(n);
    }

    // Pure Recursion (without memoization) – very slow
    private int solveRec(int n) {
        if (n <= 3) return n;

        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solveRec(n - i * i));
        }
        return ans;
    }

    public int numSquaresRec(int n) {
        return solveRec(n);
    }
}

