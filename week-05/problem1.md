#problem-1: Deep Clone Linked List with Random Pointer

## Problem
We are given a singly linked list where each node contains:
- `next`: pointer to the next node
- `random`: pointer to any node in the list or null

We must create a deep copy (new list with same structure but different objects).

---

## Example
**Original List:**
7 -> 13 -> 11 -> 10 -> 1
Random Pointers:
13.random -> 7
11.random -> 1
10.random -> 11
1.random -> 7

markdown
Copy
Edit

**Cloned List:**
7' -> 13' -> 11' -> 10' -> 1'
Random Pointers match same structure as original.

yaml
Copy
Edit

---

## Approach 1: Using HashMap (O(n) space)
**Steps:**
1. Create a map to store mapping of original node → cloned node.
2. First pass: Create all cloned nodes and store in the map.
3. Second pass: Use map to assign `next` and `random` pointers.
4. Return cloned head.

**Pros:** Easy to understand.  
**Cons:** Extra space O(n).

---

## Approach 2: Interleaving Method (O(1) space)
**Steps:**
1. Insert cloned nodes right after each original node.
2. Assign random pointers for cloned nodes using original's random.
3. Separate cloned list from original.

**Pros:** O(1) space.  
**Cons:** A bit tricky to implement correctly.

---

## Time & Space Complexity
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| HashMap  | O(n)           | O(n)             |
| Interleaving | O(n)       | O(1)             |

---
