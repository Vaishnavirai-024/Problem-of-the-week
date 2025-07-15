//                                             Brute Force Solution 
// Time Complexity: O(n * k * k)
// Space Complexity: O(1)

import java.util.*;

public class rubySecondHouse {

    // Function to find minimum cost using brute force
    public static int findMinCost(int[][] costs, int n, int k) {
        int Total = Integer.MAX_VALUE;

        // Try all colors for the first house
        for (int Color1 = 0; Color1 < k; Color1++) {
            int totalCost = costs[0][Color1];
            int prevColor = Color1;

            // Greedily choose the lowest cost color for each next house (not same as previous)
            for (int i = 1; i < n; i++) {
                int minCost = Integer.MAX_VALUE;
                int chosenColor = -1;

                for (int j = 0; j < k; j++) {
                    if (j != prevColor && costs[i][j] < minCost) {
                        minCost = costs[i][j];
                        chosenColor = j;
                    }
                }

                totalCost += minCost;
                prevColor = chosenColor;
            }

            Total = Math.min(minTotalCost, totalCost);
        }

        return Total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of houses and colors
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Input: painting costs
        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        // Output: minimum cost
        System.out.println(findMinCost(costs, n, k));
    }
}

// ..........................................................................................................................

//                                                     DP Solution 


// Time Complexity: O(n * k * k), Space Complexity: O(n * k)

import java.util.*;

public class rubySecondHouse_optimal {
    public static int minPaintCost(int[][] costs, int n, int k) {
        // Edge case
        if (n == 0 || k == 0) return 0;

        // Create a DP table to store minimum cost
        int[][] dp = new int[n][k];

        // Base case: cost to paint first house with each color
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int p = 0; p < k; p++) {
                    if (p != j) {
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i - 1][p]);
                    }
                }
            }
        }

        // Find the minimum in the last row
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[n - 1][j]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of houses and colors
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Input: painting costs
        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        // Output: minimum total cost
        System.out.println(minPaintCost(costs, n, k));
    }
}

