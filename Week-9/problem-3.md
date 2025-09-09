# 📘 Problem of the Week – Autocomplete System

## ✅ Problem Statement
Autocomplete is a commonly used feature in search engines and apps like Twitter and Google. Given a prefix and a dictionary of known words, you are to return all words that start with that prefix.

---

## 🔢 Input Format
- First line: Integer `N`, number of words in the dictionary.
- Second line: `N` space-separated strings (the dictionary).
- Third line: A string `s`, the query prefix.

## ✅ Output Format
- List of words from the dictionary that start with the given prefix.

---

## 📚 Constraints
- \( 1 \leq N \leq 10^5 \)
- Each word length ≤ 50
- Query string length ≤ 50

---

## 📜 Example

**Sample Input 0**
3
dog deer deal
de



**Sample Output 0**
deer deal


---

## ✅ Approaches

### 🟠 Approach 1 – Brute Force Search

**Idea:**
- Iterate through every word in the dictionary.
- Check if it starts with the prefix `s`.
- Add matching words to the result list.

✔ **Time Complexity:** O(N * L), where `N` is the number of words and `L` is the length of the prefix.  
✔ **Space Complexity:** O(1) extra space apart from the output list.

---

### ✅ Approach 2 – Trie (Prefix Tree)

**Idea:**
- Build a Trie from the dictionary.
- Traverse the Trie using the prefix `s`.
- Use DFS to collect all words from that point.

✔ **Time Complexity:** O(L + K), where `L` is the prefix length and `K` is the number of matching words.  
✔ **Space Complexity:** O(N * L) for storing the Trie.

**Steps:**
1. Insert all dictionary words into the Trie.
2. Navigate the Trie using the prefix.
3. Perform DFS to find all valid words.

---

## ✅ Key Learnings

- The brute-force approach is simple but inefficient for large dictionaries.
- Trie structures offer significant speedups for prefix-based searches.
- DFS traversal is a powerful tool to explore tree structures like Tries.

---

## 📂 Implementation Notes

- The brute-force approach is useful for understanding the problem and testing correctness.
- The Trie-based solution is preferred for scalable applications, such as search engines.

---
