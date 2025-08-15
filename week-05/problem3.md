# problem 3: GCD of N Numbers

## Problem
Given `n` integers, find the greatest common divisor (GCD) — the largest number that divides all integers without leaving a remainder.

---

## Example 1
**Input**
3
42 56 14

markdown
Copy
Edit
**Output**
14

yaml
Copy
Edit

**Explanation**
- Factors of 42 → {1, 2, 3, 6, 7, 14, 21, 42}  
- Factors of 56 → {1, 2, 4, 7, 8, 14, 28, 56}  
- Factors of 14 → {1, 2, 7, 14}  
- Greatest common factor = **14**

---

## Approach 1: Brute Force
### Steps:
1. Find the smallest number in the array.
2. Check all numbers from that smallest down to 1.
3. The first number that divides all is the GCD.

**Time Complexity:** O(min(arr) × n) → slow for large inputs  
**Space Complexity:** O(1)

---

## Approach 2: Euclidean Algorithm (Efficient)
### Steps:
1. Find GCD of first two numbers.
2. Use that result with the next number: `gcd(result, arr[i])`
3. Continue until all numbers are processed.

**Time Complexity:** O(n log M), where M is largest number.  
**Space Complexity:** O(1)  
**Why efficient?** The Euclidean algorithm reduces problem size quickly using modulo.

---

## Complexity Comparison
| Approach  | Time Complexity | Space Complexity | Suitable for Large Input? |
|-----------|----------------|------------------|---------------------------|
| BruteForce| O(min × n)     | O(1)             | ❌                        |
| Euclidean | O(n log M)     | O(1)             | ✅                        |

---
