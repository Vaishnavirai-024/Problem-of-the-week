# Prime Numbers with Multiple Occurrences

## Problem Statement
We are given an integer array **A**.  
We need to find all **prime numbers** that occur **more than once** in the array and store them in a new array **B**.

- If no prime repeats, print `-1`.
- Maintain the order of their **first appearance** in the original array.

---

## Input Format
- First line: Integer `N` (size of array A)
- Second line: `N` space-separated integers

## Output Format
- Print array B containing repeating primes in order
- If no such prime exists, print `-1`

---

## Example 1
### Input
10
2 3 5 7 11 3 2 15 17 5

shell
Copy
Edit
### Output
2 3 5

yaml
Copy
Edit
### Explanation
- Primes in the array: 2, 3, 5, 7, 11, 17  
- Repeated primes: 2, 3, 5  
- So B = [2, 3, 5]

---

## Example 2
### Input
6
4 6 8 9 10 12

shell
Copy
Edit
### Output
-1

yaml
Copy
Edit
### Explanation
- No prime numbers in the array, so answer = `-1`

---

## Constraints
- `1 ≤ N ≤ 10^5`
- `-10^6 ≤ A[i] ≤ 10^6`
- Prime numbers considered only if **> 1**

---

## 🔎 Approaches

### ✅ Approach 1: Brute Force
1. For each number, check if it is prime using trial division.
2. Store frequency in a `LinkedHashMap` (to preserve order).
3. Collect primes that appear more than once.

**Time Complexity:**  
- Prime check for each number: `O(√n)`  
- For N numbers: `O(N√max(A[i]))`  
- Works but may be slow for large inputs.

---

### ✅ Approach 2: Optimized (Sieve of Eratosthenes)
1. Precompute primes up to `10^6` using Sieve (O(N log log N)).
2. Traverse array and count frequency of only prime numbers.
3. Collect primes that occur more than once.

**Time Complexity:**  
- Sieve precomputation: `O(max log log max)`  
- Checking + counting: `O(N)`  
- Much faster for large inputs.

---
