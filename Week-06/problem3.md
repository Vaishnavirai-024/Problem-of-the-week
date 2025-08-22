# 🌳 Maximum Path Sum in a Binary Tree  

## 📌 Problem Statement  
We are given a **binary tree**, where each node contains an integer value.  
We need to **find the maximum path sum between any two nodes** in the tree.  

### ✅ Rules
- The path must contain **at least one node**.  
- The path does **not need to pass through the root**.  
- A path is a sequence of connected nodes, and **a node can appear only once**.  

**Company Asked:** Google 🚀  

---

## 📥 Input Format  
A binary tree where each node contains an integer value.  

## 📤 Output Format  
An integer → the **maximum path sum**.  

---

## 🧩 Example  

**Example Tree:**  
diff
Copy
Edit
-10
/  \
9 20
/
15 7

makefile
Copy
Edit

**Output:**  
42

markdown
Copy
Edit

**Explanation:**  
The best path is `15 → 20 → 7` with a sum of **42**.  

---

## 🔑 Approach (Step by Step)  

This is a **DFS + Post-order Traversal problem**.  
We want to calculate the best path sum **at each node** and update a **global maximum**.  

1. **Recursive Traversal**  
   - Go left and right using DFS.  
   - If a path is **negative**, ignore it (take `0`).  

2. **At each node**  
   - Compute:  
     - `left` = best path from left subtree.  
     - `right` = best path from right subtree.  
   - `currentPath = node.val + left + right`  
   - Update **global maximum** if `currentPath` is better.  

3. **Return upward**  
   - When going up the recursion, we can only choose **one side**:  
     ```java
     return node.val + Math.max(left, right);
     ```  

---

## 🧮 Complexity Analysis  

- **Time Complexity:** `O(N)` → We visit each node once.  
- **Space Complexity:** `O(H)` → Recursion stack, where `H` = height of tree.  

---

## 📝 Dry Run (Example Tree)  

diff
Copy
Edit
-10
/  \
9 20
/
15 7

markdown
Copy
Edit

1. Start DFS at root `-10`.  
2. Left = `9` → best path = `9`.  
3. Right = `20`:  
   - Left = `15`, Right = `7`.  
   - At `15` → return `15`.  
   - At `7` → return `7`.  
   - At `20` → `20 + 15 + 7 = 42`. Update global max = `42`.  
   - Return `20 + max(15, 7) = 35`.  
4. At `-10`:  
   - `-10 + 9 + 35 = 34`. Global max still = `42`.  

✅ Final Answer = **42**.  

---

## 🚀 Approaches Compared  

### ❌ Brute Force (Naive DFS)  
- Try all paths manually.  
- Time: Exponential (too slow).  

### ✅ Optimized DFS + Global Tracking  
- Smart recursion + global variable.  
- Time: `O(N)`, Space: `O(H)`.  
- Efficient and elegant.  
