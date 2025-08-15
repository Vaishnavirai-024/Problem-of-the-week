# problem 2: Flood Fill Algorithm

## Problem
Given an image represented as a 2D matrix of characters and a starting pixel `(sr, sc)`,
change that pixel and all connected pixels of the same original color to a new color.
Connectivity is **4-directional** (up, down, left, right).

---

## Example
**Input:**
image = [
['B', 'B', 'W'],
['W', 'W', 'W'],
['W', 'W', 'W'],
['B', 'B', 'B']
]
sr = 2, sc = 2, C = 'G'

makefile
Copy
Edit

**Output:**
[
['B', 'B', 'G'],
['G', 'G', 'G'],
['G', 'G', 'G'],
['B', 'B', 'B']
]

yaml
Copy
Edit

---

## Approach 1: DFS (Recursive)
### Steps:
1. Get the original color of `(sr, sc)`.
2. If it's already the new color, return.
3. Recursively explore 4 neighbors and color them if they match the original color.

**Time Complexity:** O(n × m)  
**Space Complexity:** O(n × m) in worst case (recursion stack)

---

## Approach 2: BFS (Using Queue)
### Steps:
1. Get the original color of `(sr, sc)`.
2. Use a queue to process pixels iteratively.
3. For each pixel, color it and push its 4 neighbors if they match the original color.

**Time Complexity:** O(n × m)  
**Space Complexity:** O(n × m) for the queue

---

## Complexity Table
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| DFS      | O(n × m)       | O(n × m)         |
| BFS      | O(n × m)       | O(n × m)         |

---

## Notes:
- DFS is easier to write but can cause stack overflow for very large grids.
- BFS avoids recursion and is more stack-safe.
