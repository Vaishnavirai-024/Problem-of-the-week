# 👥 Problem-3: Count Friend Groups 

## 📘 Problem Statement

Imagine a classroom with `N` students (IDs from `0` to `N-1`).  
Some students are friends with each other — and friendship is **mutual**.  
We are given these relationships as an **adjacency list**.

Our goal is to count how many **friend groups** exist.  
A **friend group** is a set of students who are all directly or indirectly connected.

---

## 🔢 Input Format

- `N`: Total number of students
- `friendship`: A map/dictionary where:
  - Key = student ID
  - Value = list of friends (student IDs)

## 🎯 Output Format

- Return the number of friend groups (connected components)

---

## 💡 Example 1

### Input:
```java
N = 7
friendship = {
  0: [1, 2],
  1: [0, 5],
  2: [0],
  3: [6],
  4: [],
  5: [1],
  6: [3]
}
```

Output:
3


---

## 🧠 Solution Approaches (From Brute Force to Optimal)

---

### 🔴 Approach 1: Brute Force using Adjacency Matrix + DFS

📌 **What it does:**
- Convert the friendship list into an `N x N` adjacency matrix.
- For every unvisited student, run DFS to mark all directly and indirectly connected friends.

🧪 **How it works:**
- Create a matrix `matrix[i][j] = 1` if student `i` is friends with `j`.
- For each unvisited student, run DFS.
- Each DFS traversal means one complete group has been found.

✅ **Pros:**
- Easy to visualize and debug.

❌ **Cons:**
- Takes too much space for large N.
- Not optimal for sparse graphs.

⏱ **Time Complexity:** `O(N^2)`  
🧠 **Space Complexity:** `O(N^2)`

---

### 🟡 Approach 2: DFS with Adjacency List (Recommended)

📌 **What it does:**
- Use a HashMap (`Map<Integer, List<Integer>>`) as an adjacency list.
- Traverse using Depth First Search (DFS).

🧪 **How it works:**
- Loop over all students.
- If the student is not visited, run DFS and mark all reachable students.
- Each new DFS means a new group.

✅ **Pros:**
- Simple to implement.
- Efficient and memory-friendly.
- Best for most competitive coding problems.

⏱ **Time Complexity:** `O(N + E)`  
🧠 **Space Complexity:** `O(N)`

---

### 🟢 Approach 3: BFS with Queue

📌 **What it does:**
- Similar to DFS, but uses a queue to traverse level-by-level using Breadth First Search.

🧪 **How it works:**
- For each unvisited student, start a BFS.
- Use a queue to explore all neighbors.
- Each BFS represents a new group.

✅ **Pros:**
- Great alternative if recursion is limited (stack overflow risk).
- Preferred when you want iterative logic.

⏱ **Time Complexity:** `O(N + E)`  
🧠 **Space Complexity:** `O(N)`

---

### 🔵 Approach 4: Union-Find (Disjoint Set Union - Optimal)

📌 **What it does:**
- Initially treat each student as their own parent (own group).
- Merge students (union) who are friends.
- At the end, count how many unique parents exist — that’s your group count.

🧪 **How it works:**
- Create a `parent[]` array for N students.
- Use `find()` to get parent of a student.
- Use `union(x, y)` to merge two friend groups.
- After processing, use a set to count unique parents.

✅ **Pros:**
- Extremely efficient for large data.
- Scalable for dynamic friendships or frequent queries.

⏱ **Time Complexity:** `O(N * α(N))` *(almost linear)*  
🧠 **Space Complexity:** `O(N)`

---
