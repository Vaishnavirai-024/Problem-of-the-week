#  Problem of the Week – Step Words Finder

---

## 📌 Problem Statement

A step word is formed by:
- Adding exactly **one letter** to a base word
- And rearranging the letters to form a valid dictionary word

You are given:
- A base word `W`
- A large dictionary of valid words

Your task is to print all **valid step words** in **lexicographical order**.

---

##  Example

**Input:**
apple
5
appeal
apply
pepla
papple
apples

**Output:**
appeal
papple


---

## 🧠 How I Thought About It (As a Student)

At first, I thought:  
> Let’s try adding every letter from a-z to the input and then check anagrams...

But soon I realized:
- Sorting every word will be slow (O(K log K))
- Dictionary can have up to 1e5 words

Then I learned to **use frequency arrays**!  
Just count letters and compare — super fast!

---

## ✅ Approaches

### 1.  Brute Force (Sorting-Based)

- Add one letter to base word
- Sort and compare with dictionary words

**Time:** O(N * K log K)  
**Space:** O(K)

Works only for small cases  
 Fails for large dictionary due to sorting

---

### 2. ✅ Optimized – Frequency Array Comparison

- Count frequency of base word
- For each dictionary word:
  - Length must be `base + 1`
  - Compare letter counts
  - Only 1 letter can have `+1` frequency

**Time Complexity:** O(N * 26) = O(N)  
**Space Complexity:** O(1) (fixed-size frequency arrays)

✅ Fast even for 100000+ words  
✅ No sorting needed  
✅ Clean and simple logic

---

## 📊 Approach Comparison

| Approach            | Time         | Space | Efficient? |
|---------------------|--------------|-------|------------|
| Brute Force (Sort)  | O(N * K logK) | High  |  No       |
| Frequency Array ✅   | O(N)          | Low   |  Yes      |

---



---

##  Final Thoughts

This problem taught me how anagram-like problems can be solved without sorting by using just frequency arrays.  
This saves a lot of time and is perfect when input sizes are huge.

✅ Learned:
- Frequency-based string comparison
- Greedy filtering using string length
- How to reduce time by avoiding unnecessary work

---

