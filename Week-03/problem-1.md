
# 📦 Week 03: Equal Sum Partition

---

## 📘 Problem Statement

You are given an array of **non-negative integers**, and you need to check if it's possible to split this array into **two subsets** such that the **sum of both subsets is equal**.

- The array can contain **duplicate values**.
- You're only required to return `true` or `false`, **not the actual subsets**.

---

## 📥 Input Format

- An array of integers `arr[]` (0 ≤ element ≤ 10⁴)
- Length: up to 100 elements

## 📤 Output Format

- Return `true` if it's possible to divide the array into **two subsets with equal sum**
- Return `false` otherwise

---

## 🧠 Understanding the Problem

Let’s say your array is:
[1, 5, 11, 5]


- The total sum is `1 + 5 + 11 + 5 = 22`.
- If we divide 22 by 2, we get `11`.
- So now the real question becomes:
  
  > “Can we find **a subset** of the array whose sum is exactly `11`?”

If YES → the remaining elements will automatically sum to 11 (because total is 22).

This is called the **Subset Sum Problem**, a classic dynamic programming problem.

---

## ❌ When to Return False Immediately?

Before doing anything fancy, check the **total sum** of the array:

- If it's an **odd number**, like 85, you can't divide it into two equal parts.  
  So just return `false`.

---

## 🧪 Examples

### ✅ Example 1:
Input: [15, 5, 20, 10, 35, 15, 10]
Total sum = 110 → Even → Target = 55

Subset A: [15, 5, 10, 15, 10] → sum = 55
Subset B: [20, 35] → sum = 55
Output: true


### ❌ Example 2:
Input: [15, 5, 20, 10, 35]
Total sum = 85 → Odd → Not divisible
Output: false


---

## 🔍 Goal of the Problem

After checking that total sum is even, the main goal becomes:

> **"Can we find a subset of elements that adds up to half of the total sum?"**

If yes, return `true`.

---

## 🧠 Core Logic Behind All Approaches

We want to answer:  
**Can I pick some elements such that their total is equal to target = totalSum / 2?**

This is the **Subset Sum Problem**.

---



### 🔸 Approach 1: Brute Force Recursion (Try All Combinations)

**How it works:**
- We start from index 0.
- At each element, we have two choices:
  1. Include the element in our subset
  2. Skip it

We recursively try all paths until:
- We either reach the target sum → return `true`
- Or we run out of elements → return `false`

**Base cases:**
- If target becomes `0` → Success
- If index is beyond array or target < 0 → Failure

**Time Complexity:** `O(2^n)` → Very slow for large input  
**Space Complexity:** `O(n)` (due to recursion stack)


---

### 🔸 Approach 2: Recursion + Memoization (Top-Down DP)

**What's new here:**
We store results of subproblems in a 2D table `memo[i][sum]`, where:
- `i` = index in array
- `sum` = current target

If we’ve already solved a subproblem with this index and sum, we don’t redo it.

**Why it’s better:**
- No repeated calculations
- Converts exponential recursion into `O(n * sum)`

**Time Complexity:** `O(n * sum)`  
**Space Complexity:** `O(n * sum)` for memo table


---

### 🔸 Approach 3: Bottom-Up Dynamic Programming (Tabulation)

**This is the most optimized version.**

We use a **1D boolean array `dp[0…target]`**, where:
- `dp[i]` tells us if a subset with sum `i` is possible

**Steps:**
1. Initialize `dp[0] = true` (subset with sum 0 is always possible)
2. For each number in the array:
   - Update the `dp` array in reverse (to avoid using updated values again)
   - For each sum from `target` to `num`, set:
     ```java
     dp[sum] = dp[sum] || dp[sum - num];
     ```

3. At the end, if `dp[target]` is `true`, return true

**Time Complexity:** `O(n * sum)`  
**Space Complexity:** `O(sum)` (space optimized)


---

