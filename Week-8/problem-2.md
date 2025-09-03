# Reverse Words with Delimiters — Java Solutions

## 📌 Problem Statement
You are given a string `S` consisting of **words** and **delimiters**.  
Your task is to **reverse the order of the words** in the string while keeping the **delimiters in their original positions**.

- Words contain only lowercase alphabets (`a–z`).
- Delimiters are non-alphabetic characters (`/, :, ., !, ?`, etc.).
- The relative positions of delimiters must remain unchanged.

---

## 🎯 Examples

**Example 1**
Input: "hello/world:here"
Output: "here/world:hello"

markdown
Copy code

**Example 2**
Input: "hello/world:here/"
Output: "here/world:hello/"

markdown
Copy code

**Example 3**
Input: "hello//world:here"
Output: "here//world:hello"

yaml
Copy code

---

## ✅ Constraints
- 1 ≤ |S| ≤ 10^5
- Words consist only of lowercase English letters.
- Multiple delimiters and consecutive delimiters are possible.

---

## 💡 Approaches

### 1. Split + Reconstruct (Regex/Parsing)
- Use regex to split words (`split("[^a-z]+")`).
- Collect all words and reverse them.
- Traverse the original string:
  - If character is a letter → insert next reversed word.
  - Else → copy delimiter as-is.

**Complexity:**  
- Time: **O(n)**  
- Space: **O(n)**  

---

### 2. Stack-based Approach
- Traverse string, extract words, and push into a stack.
- Traverse again:
  - If character is a letter → pop a word from stack.
  - Else → copy delimiter.

**Complexity:**  
- Time: **O(n)**  
- Space: **O(n)**  

---

### 3. Two-Pointer Parsing
- Use two pointers to parse and collect words.
- Reverse the list of words.
- Reconstruct string by replacing original words with reversed ones while keeping delimiters.

**Complexity:**  
- Time: **O(n)**  
- Space: **O(n)**  

---

## 🖥️ Usage
