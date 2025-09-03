# Majority Element Problem (MongoDB)

### Problem
Given an array of `n` integers, find the **majority element** (the one appearing more than ⌊n/2⌋ times).  
It is guaranteed that such an element exists.

### Example
Input:
7
1 2 1 1 3 4 0

Output:
1



---

## Approaches Implemented (Java)

### 1. Boyer–Moore Voting Algorithm
- Keep a candidate and a counter.
- Increase count when the same element, decrease otherwise.
- Final candidate is the majority.
- **Time:** O(n), **Space:** O(1)

### 2. HashMap Counting
- Count frequency using a `HashMap`.
- Return the element whose count > n/2.
- **Time:** O(n), **Space:** O(n)

### 3. Sorting
- Sort the array, return middle element (`nums[n/2]`).
- Majority element must occupy the middle.
- **Time:** O(n log n), **Space:** O(1)

### 4. Divide & Conquer
- Recursively split the array.
- Find majority in left and right.
- If same, return; else count which occurs more.
- **Time:** O(n log n), **Space:** O(log n) (recursion)

### 5. Bit Manipulation
- For each bit (0–31), count how many numbers have it set.
- If count > n/2, set that bit in result.
- Works for negative numbers too.
- **Time:** O(32n), **Space:** O(1)

---

