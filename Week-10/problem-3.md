# Longest Increasing Subsequence (LIS)

## Problem Statement
Given an array of numbers, find the length of the Longest Increasing Subsequence (LIS). The subsequence does not need to be contiguous, but the order must be maintained.

---

## Example

**Input:**  
[0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]



**Output:**  
6



**Explanation:**  
One possible LIS is `[0, 2, 6, 9, 11, 15]` which has length 6.

---

## Approaches

### ✅ 1. Recursive + Memoization (Top-Down DP)
- For each element, try to include or exclude it.
- Memoize intermediate results using a 2D array.
- Time Complexity: O(n²)

---

### ✅ 2. Bottom-Up DP (Classic DP)
- Use an array `dp[i]` to store the LIS ending at index `i`.
- For each element, look back at previous elements to build `dp[i]`.
- Time Complexity: O(n²)

---

### ✅ 3. Optimized with Binary Search (Patience Sorting)
- Maintain a list that holds the smallest possible tail for subsequences of varying lengths.
- Use binary search to update the list efficiently.
- Time Complexity: O(n log n)

---

## How to Use
1. Input the size of the array.
2. Input the elements of the array.
3. Choose an approach (1, 2, or 3).
4. The program outputs the length of the LIS.

---
