# Week 01 – Minimum in Rotated Sorted Array

## 🧠 Problem Summary
Given a sorted array that is rotated at some pivot, find the **minimum element** in `O(log n)` time.  
No duplicate elements are present.

---

## 🧪 Sample Input
5
5 7 10 3 4


## 📤 Output
3


---

## 💡 Solutions Summary

### 🔹 1. Brute Force  
- Check every element and return the minimum.  
- 🕒 Time: `O(n)`  

---

### ⚡ 2. Optimal – Binary Search  

- Start with `low = 0` and `high = n - 1`
- Run a loop:  
   - Calculate `mid = (low + high) / 2`
   - If `arr[mid] > arr[high]`: the minimum is in the **right half** → update `low = mid + 1`
   - Else: the minimum is in the **left half** → update `high = mid`
- When `low == high`, that's the index of the minimum element.
---


## ✅ Final Note

| Approach       | Time      | Space | Link                                 |
|----------------|-----------|--------|--------------------------------------|
| Brute Force    | O(n)      | O(1)   | ✔️ `brute.java`                      |
| Binary Search  | O(log n)  | O(1)   | ✔️ `optimal.java`                    |
| Linear Check   | O(n)      | O(1)   | ✔️ `linearBinary.java` (if added)    |

