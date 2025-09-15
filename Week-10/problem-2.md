# Problem of the Week – Bitwise AND of a Range

## Problem Statement
Given two integers `M` and `N`, compute the bitwise AND of all numbers between `M` and `N` inclusive:

result = M & (M+1) & (M+2) & ... & N



---

## Examples

### Example 1
**Input:**  
`M = 5`, `N = 7`

**Output:**  
`4`

**Explanation:**  
5 = 101
6 = 110
7 = 111
Result = 101 & 110 & 111 = 100 = 4



### Example 2
**Input:**  
`M = 0`, `N = 1`

**Output:**  
`0`

**Explanation:**  
0 = 000
1 = 001
Result = 000 & 001 = 000 = 0



---

## Approaches

### ✅ 1. Naive Approach
- Iterate from `M` to `N` and apply the `&` operation at each step.
- Simple but inefficient for large ranges.

**Time Complexity:** O(N - M)

---

### ✅ 2. Optimized Approach (Bitwise Trick)
- The final result is the common prefix of `M` and `N`.
- Right-shift `M` and `N` until they are equal.
- Shift the result back to the left by the number of shifts applied.

**Time Complexity:** O(log N)

---

## How to Use
- Enter two integers `M` and `N`.
- Choose either the naive or optimized approach.
- The program will output the bitwise AND result.

---
