# 🧩 Problem 2 – Subarray Sum Equals K


You are given an array of integers `nums` and an integer `k`.  
Your task is to count the **total number of continuous subarrays** whose sum equals to `k`.

A subarray is a sequence of **contiguous elements**, and the same elements can be part of multiple valid subarrays.

---

## 🧪 Sample Input
nums = [1, 2, 3]
k = 3


### ✅ Output
2

---

## 💡 Brute Force Approach

### 🔹 Logic:
- Loop through each index `i` as the starting point of the subarray.
- Loop through each index `j` starting from `i`, adding elements and keeping track of the sum.
- If the sum equals `k`, increment the count.

### 🔹 Pseudocode:
for i from 0 to n-1:
sum = 0
for j from i to n-1:
sum += nums[j]
if sum == k:
count++


### 🔹 Time & Space:
- Time Complexity: `O(n^2)` (due to nested loop)
- Space Complexity: `O(1)`  

---

## ⚡ Optimized Approach – Prefix Sum + HashMap

### 🔹 Core Idea:
We use a **prefix sum** and a **HashMap** to count how often a specific prefix sum has occurred.  
The key observation is:  
> If `prefix_sum[j] - prefix_sum[i] = k`, then the subarray `i+1 to j` has sum `k`.

So, we keep track of the current `prefixSum` and for each step check if `(prefixSum - k)` already exists in the map. If yes, we add its frequency to our count.

### 🔹 Steps:
1. Initialize `sum = 0` and `map.put(0, 1)` to handle cases when a subarray from index 0 forms the target.
2. For each element in the array:
   - Add it to the running `sum`.
   - Check if `sum - k` is present in the map → it means a valid subarray exists.
   - Update the frequency of the current `sum` in the map.

### 🔹 Time & Space:
- Time Complexity: `O(n)`
- Space Complexity: `O(n)` (for HashMap)

---

## 🧠 Example Walkthrough

Let’s walk through `nums = [1, 1, 1], k = 2`

### Prefix Sums:
Index: 0 1 2
Value: 1 1 1
Sum: 1 2 3


We check at each step:
- Is `sum - k` found in map?
- If yes, it means we have found that many valid subarrays ending at current index.

For example:
- At index 1 → sum = 2 → sum - k = 0 → map has 1 → count = 1
- At index 2 → sum = 3 → sum - k = 1 → map has 1 → count = 2

---

## 📝 Final Notes

| Approach     | Time Complexity | Space Complexity |
|--------------|------------------|------------------|
| Brute Force  | O(n²)           | O(1)             | 
| Optimized    | O(n)            | O(n)             |





