#  Problem of the Week – Week 03

---

##  Problem Statement (in my own words)

Imagine you have a set of coins with different denominations — all positive numbers and already sorted in increasing order. Your job is to **find the smallest amount of money that you cannot form** by adding any subset of those coins.

For example, if you have coins `[1, 2, 3, 10]`, you can form amounts like 1, 2, 3, 4, 5, 6, but you can’t form 7 — so the answer is 7.

---

##  Input Format

- A single line of space-separated positive integers (sorted)

**Example Input:**
1 2 3 10

---

##  Output Format

- A single integer representing the smallest positive number that cannot be formed from any subset of the array.

**Example Output:**
7

---

##  Test Case Explanation

### For input:
1 2 3 10


All possible subset sums:
- 1, 2, 3, 1+2=3, 1+3=4, 2+3=5, 1+2+3=6

So we can form: `1, 2, 3, 4, 5, 6`  
But we **cannot form 7**, even with the big coin (10).  
So the output is `7`.

---

##  My First Idea (Brute Force / Subset Sums)

At first, I thought:
> Why not just try all combinations (subsets) and find their sums?

That would mean generating all possible subsets and checking which sums are missing. But this is way too slow because:
- For `N` coins, total subsets = `2^N`
- If `N = 20`, then subsets = 1 million
- If `N = 100000`, it’s **impossible**

So this idea is **too slow and not practical**. 

---

##  The Greedy Trick (Actual Working Approach)

I realized a better idea after thinking a bit more...

Let’s say I can already form **all sums up to some number**, say `res = 1` (start with 1, because that’s the smallest positive number we care about).

### Greedy logic:

- For each coin `x` in the array:
  - If `x > res`, then we **can’t** make `res`. So that’s the answer.
  - If `x <= res`, then we can increase our range of formable sums by doing `res += x`.

### Example Walkthrough:

Input: `1 2 3 10`

Start with `res = 1`

| Coin | Condition     | Action         | New res |
|------|---------------|----------------|---------|
| 1    | 1 <= 1 (ok)   | res = 1+1      | 2       |
| 2    | 2 <= 2 (ok)   | res = 2+2      | 4       |
| 3    | 3 <= 4 (ok)   | res = 4+3      | 7       |
| 10   | 10 > 7 (fail) | Stop here      | 7       |

So, the answer is `7`.

### ✅ Why does this work?

If we can form every value from `1` to `res-1`, and the next coin is bigger than `res`, then there’s no way to form `res`. So `res` becomes the smallest missing number.

---

## 🔠 Java Code (Greedy Solution)

```java
public class GreedySubsetSum {
    public static int findSmallest(int[] coins) {
        long res = 1; // start from 1, the smallest positive integer
        for (int coin : coins) {
            if (coin > res) break;
            res += coin;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10};
        System.out.println(findSmallest(arr)); // Output: 7
    }
}

