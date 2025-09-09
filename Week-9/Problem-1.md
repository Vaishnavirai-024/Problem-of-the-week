# 📘 First Missing Positive Integer – Problem of the Week

## ✅ Problem Statement
Stripe’s payment system deals with sequential identifiers where missing numbers may cause serious issues. Given an unsorted array of integers, your task is to find the smallest missing positive integer.

- The array may contain duplicates and negative numbers.
- You may modify the input array in-place.
- The solution should ideally run in **O(n)** time and use **O(1)** extra space.

### 🔢 Input Format
- First line: Integer N (size of the array).
- Second line: N space-separated integers (the array elements).

### ✅ Output Format
- Print the smallest positive integer that is missing from the array.

### 📜 Constraints
- \( 1 \leq N \leq 10^5 \)
- \( -10^9 \leq arr[i] \leq 10^9 \)

### 📚 Example

**Input:**
4
3 4 -1 1



**Output:**
2

---

## ✅ Approaches Explained

### 🟠 Approach 1 – Naive Solution (Using HashSet)

**Idea:**
- Store all positive integers in a set.
- Starting from `1`, check if it is present.
- The first number not present is the answer.

**Time Complexity:** O(n)  
**Space Complexity:** O(n) – uses extra space ❌

---

### 🟠 Approach 2 – Sorting Based Solution

**Idea:**
- Sort the array.
- Traverse and check the smallest missing positive integer.

**Time Complexity:** O(n log n)  
**Space Complexity:** O(1) or O(n), depending on sorting algorithm ❌

---

### ✅ Approach 3 – Optimal Solution (In-Place Index Placement)

**Idea:**
- For each element `x` between `1` and `n`, place it at index `x-1`.
- After rearranging, the first index where `nums[i] != i+1` is the missing positive integer.
- If all are correct, return `n + 1`.

**Time Complexity:** O(n) ✅  
**Space Complexity:** O(1) ✅

---

## ✅ Key Learnings

- Sorting and hashing are simple but may not meet constraints.
- In-place rearrangement helps solve problems efficiently without extra space.
- Always look for optimized solutions that fulfill time and space requirements.

---
