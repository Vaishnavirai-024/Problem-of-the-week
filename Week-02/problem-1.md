# Problem of the Week – Longest Common Subsequence of Three Strings

### 📘 Problem Description:
Given three strings, we are supposed to find the length of the longest subsequence that is common in all three. This type of problem is super useful in real life — like checking versions of files or even DNA sequences.

### 🧠 What is a Subsequence?
A subsequence is a sequence that appears in the same relative order but not necessarily contiguously.  
Example: `"ace"` is a subsequence of `"abcde"`.

---


### 🧪 Sample Input:
epidemiologist
refrigeration
supercalifragilisticexpialodocious

### ✅ Output:
5

---

## 💡 Approaches:

### 1. Brute Force:
- Try every possibility using recursion.
- Very slow for big strings.
- Only for understanding the base logic.

### 2. Memoization (Top-Down DP):
- Same recursive idea, but we use a 3D array to store results.
- Much faster.
- Good for explaining optimization.

### 3. Tabulation (Bottom-Up DP):
- We build the solution iteratively.
- Preferred for interviews and real-life performance.

---

## 🛠️ Time and Space Complexity

| Approach      | Time       | Space      |
|---------------|------------|------------|
| Brute Force   | O(2^n * 2^m * 2^o) | O(1) |
| Memoization   | O(n * m * o)       | O(n * m * o) |
| Tabulation    | O(n * m * o)       | O(n * m * o) |

---



