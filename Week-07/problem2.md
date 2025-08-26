# 🧮 Alternating Add and Subtract (Curried Function)

## 📌 Problem Statement
We need to implement a function `add_subtract` that works in a **curried style** and **alternately adds and subtracts** numbers passed to it.

- The **first number** is always **added** (starting point).  
- The **second number** is **subtracted**.  
- The **third number** is **added**.  
- The **fourth number** is **subtracted**.  
- This continues in an **alternating pattern**.

---

## 🏢 Company Tag
**Squarespace**

---

## 📖 Examples
### Example 1
Input: add_subtract(7)
Steps: 7
Output: 7

shell
Copy
Edit

### Example 2
Input: add_subtract(1)(2)(3)
Steps: 1 + 2 - 3 = 0
Output: 0

shell
Copy
Edit

### Example 3
Input: add_subtract(-5)(10)(3)(9)
Steps: -5 + 10 - 3 + 9 = 11
Output: 11

yaml
Copy
Edit

---

## 📥 Input Format
- Input will be a sequence of integers passed as **curried arguments**.

## 📤 Output Format
- Return the **final computed integer** after applying alternating addition and subtraction.

---

## 🔒 Constraints
- Numbers can be **positive or negative**.  
- At least **one number** will always be provided.  
- Function must handle up to **10^5 chained arguments** efficiently.

---

## ✅ Sample Test Case
Input: add_subtract(5)(6)(7)
Steps: 5 + 6 - 7 = 4
Output: 4

yaml
Copy
Edit

---

# 🧑‍🎓 Approaches (Explained in Student Style)

### 🔹 Approach 1: Naive (Simulation)
- Think of it like keeping a **running total**.  
- Start with the first number as the total.  
- For every next number:  
  - If it’s at an **even position**, subtract it.  
  - If it’s at an **odd position**, add it.  
- Works fine, but requires checking **position index** each time.

---

### 🔹 Approach 2: Using a Sign Toggle
- Instead of checking index parity every time:  
  - Use a variable `sign` that starts with **+1**.  
  - Multiply the incoming number by the current `sign` and add it to the total.  
  - Then flip the sign (`sign = -sign`).  
- This avoids condition checking and is **cleaner + efficient**.

---

### 🔹 Approach 3: Functional / Curried Style
- Since the problem is about **currying**:  
  - Treat every input number as a new "layer" that updates the total.  
  - Maintain state of:
    - The **running total**.  
    - The **current sign**.  
  - Each call updates and returns another function until evaluation.  
- Conceptually, think of it as building a **chain of function calls** that keeps alternating operations.

---

# 🚀 Which Approach is Best?
- **Approach 1**: Easy to understand, but slightly less elegant.  
- **Approach 2**: Cleaner, uses sign toggling, avoids index checks.  
- **Approach 3**: The **real interview expectation** because it uses **curried function style** (advanced, but powerful).  

---
