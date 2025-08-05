# 📘 Problem-2: Search in a Sorted List Without Multiplication, Division, or Bit-Shifts

## 🎯 Objective
Efficiently **search a target element** `x` in a **sorted list** `arr` in **O(log N)** time **without using**:
- Multiplication `(*)`
- Division `(/)`
- Bit-shift operators `(<<, >>)`

---

## ✅ Why Binary Search?
- Binary Search is ideal for **sorted arrays** and works in **O(log N)** time.
- It repeatedly divides the search space into half.
- But… the **usual mid calculation uses division**, which we **can’t use** here.

---

## 🚫 The Challenge

Normally, in binary search we do:
```java
mid = (low + high) / 2;
But since / (division) is not allowed, we can’t use this directly.
```

## ✅ Solution Strategy

We need to manually calculate `mid` using only **addition and subtraction**.

---

### ✳️ Custom Integer Division

We implement our own function:

```java
int divide(int a, int b)
```
Output: true
---
divide(5, 2) → 2  
divide(10, 3) → 3
We use this to compute:

mid = low + divide((high - low), 2);

Initialize:

ini
Copy
Edit
low = 0  
high = N - 1
Repeat until low <= high:

Compute mid:

java
Copy
Edit
mid = low + divide((high - low), 2);
Compare with target:

If arr[mid] == x → return true

If arr[mid] < x → move right → low = mid + 1

If arr[mid] > x → move left → high = mid - 1

If not found, return false.

✅ Example Walkthrough
Example 1:
Input:

ini
Copy
Edit
arr = [-5, -2, 0, 3, 7, 10, 15]  
x = 7
Step-by-step execution:

low = 0, high = 6

mid = 0 + divide(6 - 0, 2) = 3

arr[3] = 3 < 7 → move right

low = 4, high = 6

mid = 4 + divide(6 - 4, 2) = 5

arr[5] = 10 > 7 → move left

low = 4, high = 4

mid = 4 + divide(0, 2) = 4

arr[4] = 7 → found ✅


---

## ⏱️ Time Complexity

- The algorithm uses **Binary Search**, which divides the search space by half at each step.
- Even though we replace the division `/` with a custom `divide()` function, it only runs once per iteration to calculate `mid`.
- So, the number of comparisons still follows the **logarithmic pattern**.

### ✅ Final Time Complexity:
O(log N)


---

## 🧮 Space Complexity

- The algorithm does **not use any extra space** (no recursion, no additional arrays).
- Only a few variables (`low`, `high`, `mid`) are used.

### ✅ Final Space Complexity:
O(1)
