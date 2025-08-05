# 🧠 Problem of the Week 4– First Recurring Character 

## 📌 Problem Statement

You're given a string. Your task is to **find the first character that appears more than once**, but **you must return the one whose second appearance happens first**.

If **no character repeats**, return `null`.

This problem is useful in real-world scenarios like autocomplete systems, where we want to detect early repeating typing patterns.

---

## 🧾 Input Format

- A single string `s` consisting of uppercase and/or lowercase English letters.
- Length of the string: `1 <= s.length <= 10^5`

## 🎯 Output Format

- A single character (String or char) that repeats first based on **earliest second occurrence**
- If there is no recurring character, return **null**

---

## 🧪 Examples

### Example 1:
Input: "acbbac"
Output: "b"
Explanation:

'a' repeats at index 0 and 4

'b' repeats at index 2 and 3 → b’s second appearance (at 3) comes before a’s (at 4)



### Example 2:
Input: "abcdef"
Output: null
(All characters are unique)


### Example 3:
Input: "abca"
Output: "a"
(‘a’ repeats at index 0 and 3)


---

## 💡 Approaches and Logic

### ✅ 1. HashSet Approach (Optimized – O(n) Time, O(n) Space)

> Think of it like this:  
You're walking through the string left to right, and carrying a notepad.  
Each time you see a new letter, you note it down.  
If you see the same letter again — boom! That’s your answer.

**Steps:**
- Use a `HashSet` to store characters you've already seen.
- Loop through the string.
- If a character is already in the set, return it immediately.
- If the loop finishes, return null.

### ✅ 2. HashMap Approach (Track Index)

> This one records when each character was first seen.  
Then we check: if a char appears again, what's its second index?  
We keep track of the **earliest second appearance**.

**Steps:**
- Use a `HashMap<Character, Integer>` to store the **first index** of each character.
- If a character appears again, compare its index to find the **minimum second index**.
- Return the character with the earliest second appearance.

### ❌ 3. Brute Force Approach (Not efficient – O(n²) Time)

> This one is like checking every character with every other character ahead of it.

**Steps:**
- Use two nested loops.
- For each character, look ahead for duplicates.
- Track the **minimum second index** and return that character.

---

## 📊 Time and Space Complexity

| Approach         | Time Complexity | Space Complexity | Use Case |
|------------------|------------------|-------------------|-----------|
| HashSet          | O(n)             | O(n)              | ✅ Best overall |
| HashMap          | O(n)             | O(n)              | Good if you need index |
| Brute Force      | O(n²)            | O(1)              | ❌ Not recommended for large strings |

---
