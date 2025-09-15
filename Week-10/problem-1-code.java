import java.util.*;

public class KnightsSurvival {
    private static final int N = 8;
    private static final int[][] directions = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    // Approach 1: Dynamic Programming (Bottom-up)
    public double knightProbabilityDP(int r, int c, int k) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1.0;

        for (int move = 0; move < k; move++) {
            double[][] next = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dp[i][j] > 0) {
                        for (int[] dir : directions) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                                next[ni][nj] += dp[i][j] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = next;
        }

        double probability = 0.0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                probability += dp[i][j];
        return probability;
    }

    // Approach 2: Recursion + Memoization (Top-down)
    private Map<String, Double> memo = new HashMap<>();

    public double knightProbabilityMemo(int r, int c, int k) {
        memo.clear();
        return dfs(r, c, k);
    }

    private double dfs(int r, int c, int k) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
        if (k == 0) return 1.0;

        String key = r + "," + c + "," + k;
        if (memo.containsKey(key)) return memo.get(key);

        double prob = 0.0;
        for (int[] dir : directions) {
            int ni = r + dir[0];
            int nj = c + dir[1];
            prob += dfs(ni, nj, k - 1) / 8.0;
        }
        memo.put(key, prob);
        return prob;
    }

    // Approach 3: Matrix Exponentiation
    public double knightProbabilityMatrix(int r, int c, int k) {
        int size = N * N;
        double[][] transition = new double[size][size];
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int from = row * N + col;
                for (int[] dir : directions) {
                    int ni = row + dir[0];
                    int nj = col + dir[1];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                        int to = ni * N + nj;
                        transition[to][from] += 1.0 / 8.0;
                    }
                }
            }
        }

        double[][] powered = matrixPower(transition, k);

        int start = r * N + c;
        double prob = 0.0;
        for (int i = 0; i < size; i++) {
            prob += powered[i][start];
        }
        return prob;
    }

    private double[][] matrixPower(double[][] matrix, int power) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1.0;

        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, matrix);
            matrix = multiply(matrix, matrix);
            power >>= 1;
        }
        return result;
    }

    private double[][] multiply(double[][] a, double[][] b) {
        int size = a.length;
        double[][] res = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (a[i][k] != 0) {
                    for (int j = 0; j < size; j++) {
                        res[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return res;
    }

    // Main method with menu
    public static void main(String[] args) {
        KnightsSurvival solver = new KnightsSurvival();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter r, c, k:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        System.out.println("Choose approach:");
        System.out.println("1. Dynamic Programming (Bottom-up)");
        System.out.println("2. Recursion + Memoization (Top-down)");
        System.out.println("3. Matrix Exponentiation");
        int choice = sc.nextInt();

        double result = 0.0;
        switch (choice) {
            case 1:
                result = solver.knightProbabilityDP(r, c, k);
                break;
            case 2:
                result = solver.knightProbabilityMemo(r, c, k);
                break;
            case 3:
                result = solver.knightProbabilityMatrix(r, c, k);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }
        
        System.out.printf("Probability: %.6f\n", result);
        sc.close();
    }
}
