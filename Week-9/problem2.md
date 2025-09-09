# 📘 Problem of the Week – Swap Even and Odd Bits

## ✅ Problem Statement
In computer systems, bitwise operations are crucial for performance in areas like networking, cryptography, and compression. Cisco wants you to demonstrate your bit manipulation skills.

You are given an unsigned 8-bit integer (0 ≤ n ≤ 255). Your task is to swap every even-positioned bit with the adjacent odd-positioned bit.

- Bits are counted from the right, starting at position 1.
- Example:
    - `10101010` → `01010101`
    - `11100010` → `11010001`

---

## 🔢 Input Format
- A single integer `n` where `0 ≤ n ≤ 255`.

## ✅ Output Format
- An integer representing the result after swapping even and odd bits.

---

## 📚 Example

**Sample Input 0**
170

markdown
Copy code

**Sample Output 0**
85

yaml
Copy code
**Explanation:**  
Binary of `170 = 10101010`. After swapping → `01010101 = 85`.

---

**Sample Input 1**
226



**Sample Output 1**
209

markdown
Copy code
**Explanation:**  
Binary of `226 = 11100010`. After swapping → `11010001 = 209`.

---

## ✅ Approaches

### 🟠 Approach 1 – Brute Force Bit-by-Bit Swap

**Idea:**
- Loop through all 8 bits in steps of 2.
- For each pair of bits `(i, i+1)`, extract and swap them.
- Rebuild the result by setting bits in the swapped positions.

**Time Complexity:** O(8) → Constant time  
**Space Complexity:** O(1)

---

### ✅ Approach 2 – Efficient Bitmasking (One-liner)

**Idea:**
- Separate even and odd bits using masks:
    - **Even bit mask:** `0xAA = 10101010` (extracts even bits).
    - **Odd bit mask:** `0x55 = 01010101` (extracts odd bits).
- Shift even bits right by 1 and odd bits left by 1.
- Combine using bitwise OR.

**Formula:**
((n & 0xAA) >> 1) | ((n & 0x55) << 1)



**Time Complexity:** O(1)  
**Space Complexity:** O(1)

---

## ✅ Key Learnings

- Bit manipulation can solve problems efficiently without using loops.
- Masks are useful tools to extract and manipulate specific bits.
- One-liner solutions using bitwise operations are both elegant and fast.
