import java.util.*;

public class PrimeRepeats {

    // Utility function: check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) return false;        // primes > 1 only
        if (n == 2) return true;         // 2 is prime
        if (n % 2 == 0) return false;    // even numbers > 2 are not prime
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Approach 1: Brute Force with Map (Check prime every time)
    static List<Integer> findRepeatingPrimesBrute(int[] arr) {
        Map<Integer, Integer> freq = new LinkedHashMap<>(); // preserves order
        for (int num : arr) {
            if (isPrime(num)) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }

    // Approach 2: Optimized using Sieve of Eratosthenes for prime precomputation
    static List<Integer> findRepeatingPrimesSieve(int[] arr) {
        int MAX = 1_000_000;
        boolean[] prime = new boolean[MAX + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        // Sieve precomputation
        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Count frequencies only for primes
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int num : arr) {
            if (num > 1 && prime[num]) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Choose approach: Brute or Optimized
        List<Integer> result = findRepeatingPrimesSieve(arr);

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
        sc.close();
    }
}
