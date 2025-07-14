# Week 01 – Minimum in Rotated Sorted Array

## 🔍 Goal
Given an array that was **originally sorted in increasing order**, but then **rotated at some unknown point**.

The task is to **find the smallest (minimum) element** in this rotated array.

---

## 🧪 Sample Input
5
5 7 10 3 4


## 📤 Output
3


---

## 💡 Approach 1: Brute Force (Simple)

- Go through every element in the array.
- Keep track of the **smallest number** you’ve seen so far.
- Return it after checking all elements.

### ✅ Time: `O(n)`  
### ✅ Space: `O(1)`  

This method is simple and works for all cases, but it becomes **slow for very large arrays**.

---

## ⚡ Approach 2: Binary Search (Efficient)

This approach uses **binary search** to solve the problem in `O(log n)` time.

### 👉 Logic:
- The minimum element lies in the **unsorted part** of the rotated array.
- If the middle element is **greater** than the rightmost element, the minimum is on the **right side**.
- Otherwise, the minimum is on the **left side** (including mid).
- Keep narrowing the range until `low == high`. That index holds the minimum.

### ✅ Time: `O(log n)`  
### ✅ Space: `O(1)`  

This is the best and most efficient way to solve the problem.

---

## 🔁 Extra Test Cases

| Input                    | Output |
|--------------------------|--------|
| `6 7 8 1 2 3`            | `1`    |
| `2 3 4 1`                | `1`    |
| `1 2 3 4 5`              | `1`    |
| `4 5 1 2 3`              | `1`    |
| `99`                    | `99`   |

---

## ✅ Summary

| Approach    | Time Complexity | Space Complexity |
|-------------|------------------|------------------|
| Brute Force | O(n)             | O(1)             |
| Binary Search | O(log n)       | O(1)             |

---




