# Problem of the Week (Hard) – Remove the maximum number of edges
**Company:** Adobe  
**Topic:** Trees, DFS  

---

## 📌 Problem Statement
You are given a tree (undirected, connected graph with `N` nodes and `N-1` edges).  
The tree has an **even number of nodes**.  

Your task is to **remove the maximum number of edges** such that every resulting connected component (subtree) has an **even number of nodes**.

---

## 🎯 Example
**Input**
8
1 2
1 3
3 4
3 5
4 6
4 7
4 8

markdown
Copy code

**Output**
2

yaml
Copy code

**Explanation**
- Removing edge `(3,4)` → subtree `{4,6,7,8}` has 4 nodes (even).  
- Removing edge `(1,3)` → subtree `{3,5}` has 2 nodes (even).  
- Both removals are valid → maximum removable edges = **2**.

---

## ✅ Constraints
- 2 ≤ N ≤ 10^5  
- N is always even.  
- Tree is connected and has `N-1` edges.  

---

## 💡 Approaches

### Approach 1: DFS with Subtree Sizes (Efficient)
1. Perform DFS from root.  
2. Compute size of each subtree.  
3. If a subtree has even size → cut edge to parent.  
4. Count such edges.  

**Complexity**
- Time: **O(N)**  
- Space: **O(N)**  

---

### Approach 2: Brute Force (Not Recommended)
1. For each edge, remove it temporarily.  
2. Use DFS to compute component sizes.  
3. If both components have even sizes → count edge.  

**Complexity**
- Time: **O(N^2)** worst case  
- Space: **O(N)**  
