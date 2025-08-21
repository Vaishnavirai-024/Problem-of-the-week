# Perfect Squares Problem (Legendre’s 3-Square Theorem + DP)

## Problem Statement
Given a number `n`, find the **minimum number of perfect square numbers** (like `1, 4, 9, 16...`) that sum up to `n`.

### Example
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4

yaml
Copy
Edit

---

## Approaches Used

### 1. **Legendre’s 3-Square Theorem (Mathematical Approach)**
- If `n` is a perfect square → Answer = 1  
- If after dividing out factors of `4`, `n % 8 == 7` → Answer = 4  
- If `n` can be written as the sum of 2 squares → Answer = 2  
- Otherwise → Answer = 3  

✅ This approach is **O(sqrt(n))** and very fast.

---

### 2. **Dynamic Programming (DP - Tabulation)**
- Build a DP array where `dp[i]` = minimum number of squares for `i`.
- Formula:  
dp[i] = min(1 + dp[i - jj]) for all jj <= i

yaml
Copy
Edit
- Time: `O(n * sqrt(n))`  
- Space: `O(n)`

---

### 3. **Recursion + Memoization**
- Solve recursively by trying all squares.
- Store already computed results in an array (`memo`).
- Time: ~`O(n * sqrt(n))` with memoization.

---

### 4. **Pure Recursion (Slow)**
- Try all possibilities without memoization.
- Very inefficient for large `n`.

---

## Which Approach to Use?
- Use **Legendre’s theorem** for fastest results.  
- Use **DP** if you want to learn bottom-up problem solving.  
- Use **Recursion + Memoization** for practicing top-down DP.

---

## Example Runs
n = 13 → Output = 2 (9 + 4)
n = 27 → Output = 3 (9 + 9 + 9)
n = 28 → Output = 4 (4 + 4 + 4 + 16)
