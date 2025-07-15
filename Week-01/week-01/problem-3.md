# 🏠 Problem-3 – Ruby Second House (Paint House Problem)

## 🧩 Problem Statement

You are given `n` houses in a row, and each house can be painted in one of `k` different colors.  
Each painting option has a cost associated with it. However, **no two adjacent houses can have the same color**.

Your task is to **paint all the houses** such that the **total painting cost is minimized**.

---

## 📥 Input Format

- First line: Two integers `n` (number of houses) and `k` (number of colors)
- Next `n` lines: Each line contains `k` space-separated integers denoting painting costs of that house with each color

### Example:
2 3
1 5 3
2 9 4


## ✅ Output:
5


---

## ✅ Explanation

There are two valid minimum-cost combinations:

- Paint house 0 with color 0 (cost = 1), house 1 with color 2 (cost = 4) → total = 5  
- Paint house 0 with color 2 (cost = 3), house 1 with color 0 (cost = 2) → total = 5

Hence, the minimum cost is `5`.

---

## 💡 Approach 1: Brute Force + Greedy

### 🔹 Idea:
- Try every color for the first house.
- For each choice, greedily pick the minimum-cost color for the next house (excluding the previous color).
- Track the minimum cost across all such combinations.

### 🔸 Time Complexity: O(n × k × k)  
### 🔸 Space Complexity: O(1)

---

## ⚡ Approach 2: Dynamic Programming (Optimal)

### 🔹 Idea:
- Create a 2D `dp[i][j]` table where:
  - `i` = current house
  - `j` = color used
  - `dp[i][j]` = min cost to paint house `i` with color `j`

- For each `dp[i][j]`, check all `dp[i-1][p]` where `p != j` (different from previous color)

### 🔸 Time Complexity: O(n × k × k)  
### 🔸 Space Complexity: O(n × k)

---

## 📌 Final Comparison

| Approach     | Time Complexity | Space Complexity | Accuracy   |
|--------------|------------------|------------------|------------|
| Brute + Greedy | O(n × k × k)    | O(1)             | May fail on edge cases |
| Optimal (DP) | O(n × k × k)     | O(n × k)         | ✅ Always correct   | 

---

