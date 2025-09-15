import java.util.Scanner;

public class BitwiseAndOfRange {

    // Approach 1: Naive method
    public int rangeBitwiseAndNaive(int m, int n) {
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result &= i;
        }
        return result;
    }

    // Approach 2: Optimized method
    public int rangeBitwiseAndOptimized(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        BitwiseAndOfRange solver = new BitwiseAndOfRange();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter M and N:");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Choose approach:");
        System.out.println("1. Naive Approach");
        System.out.println("2. Optimized Approach");
        int choice = sc.nextInt();

        int result = 0;
        switch (choice) {
            case 1:
                result = solver.rangeBitwiseAndNaive(m, n);
                break;
            case 2:
                result = solver.rangeBitwiseAndOptimized(m, n);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        System.out.println("Bitwise AND result: " + result);
        sc.close();
    }
}
