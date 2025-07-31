# 🌲 Problem 02 – Count Unival Subtrees

---

## 📌 Problem Description

You're given the **root of a binary tree**, and your task is to **count how many subtrees** in that tree are **unival**.

> A **unival subtree** (short for **universal value subtree**) is a subtree where **all nodes have the same value**.  
Even a **single node** is considered a unival subtree because it doesn't conflict with any other node.

---

## 📥 Input Format

- The root node of a binary tree.
- Each node contains:
  - An integer value
  - A left child (nullable)
  - A right child (nullable)


---

## 📤 Output Format

- A single integer → the number of **unival subtrees** in the tree.

---

## ✅ Constraints

- Number of nodes ≤ 1000
- Node values can be **positive or negative integers**
- The binary tree is not necessarily balanced

---

## 📚 Example

Given the tree:


        0
       / \
      1   0
         / \
        1   0
       / \
      1   1




### 🟢 Output:
5



### ✅ Explanation:

The unival subtrees are:

1. Leaf node `1` (leftmost)
2. Leaf node `1` (right of previous 1)
3. Leaf node `0` (bottom right)
4. Subtree with root `1` and two children `1, 1`
5. Subtree rooted at that same `1` node

---

## 💡 What is a Unival Subtree?

A subtree is **unival** if:
- Both left and right subtrees (if they exist) are also unival
- If the left/right child exists, its value must match the current node
- Single nodes are always unival

---

## 🧪 Approach 1: Brute Force (Top-Down)

### 🔧 How It Works:
- For each node, check if the **entire subtree** rooted at that node is unival
- Use a helper function `isUnival(node)` to check all values under it
- Recurse on left and right

### 📈 Time Complexity:
- Worst case: `O(N^2)`  
(For each node, we might traverse its whole subtree again)


---

## ⚡ Approach 2: Optimized (Post-order Traversal)

### 🔧 How It Works:
- Use **post-order traversal** (left → right → root)
- For each node:
  - Check if both left and right are unival
  - Check if current value matches children (if they exist)
- If yes → count it

### ✅ Time Complexity:
- `O(N)` – Each node is visited once

### ✅ Space Complexity:
- `O(H)` – Tree height (recursion stack)


