#  Problem 3 – Word Search in 2D Matrix (Easy)

> ✅ Asked in Microsoft Interview  
> 📚 Difficulty: Easy  
> 💡 Topics: 2D Arrays, Word Matching, Grid Traversal

---

## 🧩 Problem Description

You're given:
- A **2D matrix** (`M x N`) of **uppercase English letters**
- A **target word**

You have to check whether the word exists in the matrix in **either of two ways**:
1. **Horizontally** (left to right) in any row
2. **Vertically** (top to bottom) in any column

> ✅ No need to search diagonally, backwards, or wrap-around

---

## 📥 Input Format

- A 2D matrix `char[][] matrix`
- A string `word`

---

## 📤 Output Format

- Return `true` if the word is found (in any row or column)
- Otherwise, return `false`

---

## 🧪 Example

### Matrix:
F A C I
O B Q P
A N O B
M A S S



### Target Word: `"FOAM"`

### ✅ Output: `true`

---

### ✅ Explanation:

The word `"FOAM"` appears **vertically** (top to bottom) in the **first column**:

F
O
A
M



So, we return `true`.

---

## 💡 What Are We Trying to Do?

We need to:
- Check every **row** from **left to right** to see if it contains the word
- Check every **column** from **top to bottom** to see if it contains the word

> 🔎 We're basically scanning each line (row/column) as a string and checking for a match.

---

## 🧪 Approach 1: Using Strings (Simple and Clean)

### 🔧 How It Works:

1. For each **row** in the matrix:
   - Convert it into a string
   - Check if the target word exists using `.contains()`

2. Repeat the same for each **column**:
   - Build the column as a string by looping row-wise
   - Use `.contains()` again to check

### ✅ Time Complexity:
- `O(M × N)` → One full scan of each row and column

### ✅ Space Complexity:
- `O(N)` → For the temporary string built per row/column


---

## ⚡ Approach 2: Manual Character Matching (No String Methods)

### 🔧 How It Works:

1. For every row:
   - Slide a window of size equal to the word
   - Compare characters **one by one**
   - If all characters match → return `true`

2. Repeat the same logic for every column:
   - Slide a vertical window
   - Compare character-by-character

### ✅ Time Complexity:
- `O(M × N × L)` where `L` is the length of the target word  
  (Each starting position can take up to `L` comparisons)

### ✅ Space Complexity:
- `O(1)` → No extra space used
