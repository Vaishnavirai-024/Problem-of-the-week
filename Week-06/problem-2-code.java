import java.util.*;

public class MisereNim {

    // ------------------------------------------------------------
    // Approach 1: Brute Force Recursion (Naive Simulation)
    // ------------------------------------------------------------
    // Idea: Try all possible moves for the current player.
    // If at least one move leads to a losing state for the opponent,
    // then current state is winning.
    // Very slow (exponential) -> only for learning.
    public static boolean bruteForce(int[] heaps) {
        // Base case: If no stones left, last player lost -> current wins
        if (allZero(heaps)) {
            return true;
        }

        // Try removing stones from each non-empty heap
        for (int i = 0; i < heaps.length; i++) {
            for (int remove = 1; remove <= heaps[i]; remove++) {
                int[] newHeaps = Arrays.copyOf(heaps, heaps.length);
                newHeaps[i] -= remove;

                // If opponent loses from this state, current wins
                if (!bruteForce(newHeaps)) {
                    return true;
                }
            }
        }
        return false; // If all moves lead to opponent win
    }

    private static boolean allZero(int[] heaps) {
        for (int h : heaps) {
            if (h > 0) return false;
        }
        return true;
    }

    // ------------------------------------------------------------
    // Approach 2: Misère Nim Mathematical Solution (Optimal)
    // ------------------------------------------------------------
    // Theory:
    // - If all heaps are size 1 -> parity rule
    // - Else -> use XOR (nim-sum)
    public static boolean misereNim(int[] heaps) {
        // Check if all heaps are 1
        boolean allOnes = true;
        for (int h : heaps) {
            if (h != 1) {
                allOnes = false;
                break;
            }
        }

        if (allOnes) {
            // If total heaps count is even -> first player wins
            return heaps.length % 2 == 0;
        } else {
            // Normal Nim rule
            int xor = 0;
            for (int h : heaps) {
                xor ^= h;
            }
            return xor != 0;
        }
    }
