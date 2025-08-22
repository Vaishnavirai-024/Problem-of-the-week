Nim (Misère Version) — First Player Win Check  

## 📌 Problem Title
**Nim (misère version) — determine if the first player has a forced win**  

**Company:** Google  

---

## 🎮 Problem Description
We are playing a special variant of the **Nim game** with 3 heaps of stones.  

- Two players play alternately.  
- On each turn, a player **must** remove one or more stones from exactly one heap.  
- **Twist (Misère Rule):**  
  The player who takes the **last stone loses** (opposite of normal Nim).  

👉 Task: Given heap sizes `[a, b, c]`, decide if the **first player** has a forced win (assuming both play optimally).  

---

## 📥 Input Format
- An array of 3 positive integers `[a, b, c]`, each > 0  

## 📤 Output Format
- Return `True` if the first player has a forced win  
- Return `False` otherwise  

---

## 🧩 Examples

### Example 1
Input: [3, 4, 5]
Output: True

yaml
Copy
Edit
✅ First player has a winning move under optimal play.  

---

### Example 2
Input: [1, 1, 1]
Output: False

yaml
Copy
Edit
❌ With 3 heaps of size 1, first player **always loses** under misère rules.  

---

### Example 3
Input: [1, 1, 2]
Output: True

yaml
Copy
Edit
✅ First player can force a win.  

---

## 🔑 Key Observations (Misère Nim Theory)

1. **Case 1: All heaps are of size 1**  
   - If *all heaps = 1*, then:  
     - First player **wins** if the total number of heaps is **even**.  
     - First player **loses** if the total number of heaps is **odd**.  
   - Why? Because each move removes exactly one heap, so the **parity** of heaps determines the outcome (last move = loss).

   Example:  
   - `[1,1,1]` → 3 heaps (odd) → first player loses  
   - `[1,1]` → 2 heaps (even) → first player wins  

---

2. **Case 2: At least one heap ≥ 2**  
   - The game behaves like **normal Nim**.  
   - Compute **Nim-sum** (XOR of heap sizes):  
     ```
     xor = a ^ b ^ c
     ```
   - Rules:  
     - If `xor != 0` → First player **wins**  
     - If `xor == 0` → First player **loses**  

   Example:  
   - `[3,4,5]` → xor = 3 ^ 4 ^ 5 = 2 ≠ 0 → first player wins  

---

## ⚙️ Algorithm (Step by Step)

1. Let heaps = `[a, b, c]`  
2. If all heaps == 1:  
   - Return `True` if heap count is even  
   - Else return `False`  
3. Otherwise:  
   - Compute `xor = a ^ b ^ c`  
   - If `xor != 0` → return `True`  
   - Else → return `False`  

---

## 🧮 Complexity Analysis
- **Time Complexity:** `O(1)` (only XOR + checks for 3 heaps)  
- **Space Complexity:** `O(1)`  

---

## 📝 Example Walkthroughs

### Example A: `[1,1,1]`
- All heaps = 1  
- Count = 3 (odd) → First player loses  
- Output: `False`  

---

### Example B: `[1,1,2]`
- Not all heaps = 1 (since one heap = 2)  
- xor = 1 ^ 1 ^ 2 = 2 ≠ 0 → First player wins  
- Output: `True`  

---

### Example C: `[3,4,5]`
- Not all heaps = 1  
- xor = 3 ^ 4 ^ 5 = 2 ≠ 0  
- Output: `True`  

---

## 🚀 Approaches Compared

### 1. **Brute Force (Naive Simulation)** ❌ (Not practical)
- Try all possible moves recursively.  
- Extremely slow (exponential).  
- Only works for very tiny heap sizes.  

### 2. **Mathematical Misère Nim Solution** ✅ (Optimal)
- Use misère Nim theory:  
  - Check if all heaps = 1  
  - Else use XOR (nim-sum).  
- Runs in `O(1)` time.  
