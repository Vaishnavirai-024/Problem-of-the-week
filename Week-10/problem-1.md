# Knight’s Survival Probability – Combined Implementation

## Problem
A knight starts at a given position `(r, c)` on an 8×8 chessboard and makes exactly `k` moves. At each move, it randomly chooses one of the 8 possible knight moves. If it moves off the board, it disappears. The goal is to compute the probability that the knight is still on the board after `k` moves.

---

## Input
- `r`, `c`: Starting position of the knight (`0 ≤ r, c ≤ 7`)
- `k`: Number of moves (`k ≥ 0`)

---

## Output
- A floating-point number between 0 and 1 representing the probability that the knight remains on the board after `k` moves.

---

## Implemented Approaches

### ✅ 1. Dynamic Programming (Bottom-up)
- We use a 2D array to store probabilities for each cell.
- For each move, we compute the next state based on valid knight moves.
- This is efficient and easy to implement.

**Time Complexity:** O(k × 64 × 8)  
**Space Complexity:** O(64)

---

### ✅ 2. Recursion + Memoization (Top-down)
- The knight’s survival probability is computed recursively.
- Results are cached in a map to avoid redundant computations.
- This approach mirrors the DP but uses recursion.

**Time Complexity:** O(k × 64 × 8)  
**Space Complexity:** O(k × 64)

---

### ✅ 3. Matrix Exponentiation (Advanced)
- We model the knight’s moves as a 64×64 transition matrix.
- The final probability is computed by raising the matrix to the `k`th power.
- This method is mathematically elegant but more complex.

**Time Complexity:** O(log k × 64³)  
**Space Complexity:** O(64²)

---

## How to Use
- Input the starting row `r`, column `c`, and number of moves `k`.
- Choose an approach by entering 1, 2, or 3.
- The program outputs the probability that the knight stays on the board.

---

## Example

**Input:**  
`r = 0`, `c = 0`, `k = 1`, `choice = 1`

**Output:**  
`0.25`

---

## Notes
- The DP and Memoization approaches are practical for solving this problem.
- The Matrix Exponentiation approach is useful for learning advanced algorithms but less efficient for small boards.
- The solution can be extended to larger boards or different pieces.

