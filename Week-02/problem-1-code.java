//                                       1. Brute Force (Recursion Only)

public class LCSBruteForce {
    public static int lcs(String A, String B, String C, int i, int j, int k) {
        if (i == 0 || j == 0 || k == 0) return 0;

        if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)) {
            return 1 + lcs(A, B, C, i - 1, j - 1, k - 1);
        } else {
            return Math.max(Math.max(
                    lcs(A, B, C, i - 1, j, k),
                    lcs(A, B, C, i, j - 1, k)),
                    lcs(A, B, C, i, j, k - 1)
            );
        }
    }

    public static void main(String[] args) {
        String A = "epidemiologist";
        String B = "refrigeration";
        String C = "supercalifragilisticexpialodocious";
        System.out.println("LCS Length: " + lcs(A, B, C, A.length(), B.length(), C.length()));
    }
}
// .................................................................................................................................

//                                                2. Memoization (Top Down DP)

public class LCSMemoization {
    static int[][][] dp;

    public static int lcs(String A, String B, String C, int i, int j, int k) {
        if (i == 0 || j == 0 || k == 0) return 0;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)) {
            return dp[i][j][k] = 1 + lcs(A, B, C, i - 1, j - 1, k - 1);
        } else {
            return dp[i][j][k] = Math.max(Math.max(
                    lcs(A, B, C, i - 1, j, k),
                    lcs(A, B, C, i, j - 1, k)),
                    lcs(A, B, C, i, j, k - 1)
            );
        }
    }

    public static void main(String[] args) {
        String A = "epidemiologist";
        String B = "refrigeration";
        String C = "supercalifragilisticexpialodocious";
        int n = A.length(), m = B.length(), o = C.length();
        dp = new int[n + 1][m + 1][o + 1];

        for (int[][] row2D : dp)
            for (int[] row : row2D)
                java.util.Arrays.fill(row, -1);

        System.out.println("LCS Length: " + lcs(A, B, C, n, m, o));
    }
}

// ................................................................................................................................

//                                                  3. Bottom-Up DP (Tabulation)

public class LCSTabulation {
    public static int lcs(String A, String B, String C) {
        int n = A.length(), m = B.length(), o = C.length();
        int[][][] dp = new int[n + 1][m + 1][o + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= o; k++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) && A.charAt(i - 1) == C.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                        Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        return dp[n][m][o];
    }

    public static void main(String[] args) {
        String A = "epidemiologist";
        String B = "refrigeration";
        String C = "supercalifragilisticexpialodocious";

        System.out.println("LCS Length: " + lcs(A, B, C));
    }
}

