# 🔢 Validate Number in a String

## 🏢 Company
**LinkedIn**

## ⚡ Difficulty
Medium

---

## 📝 Problem Statement
We need to check if a given string `s` represents a **valid number**.  

The validator should accept:
- **Integers** → `"10"`, `"-10"`
- **Decimals** → `"10.1"`, `"-10.1"`, `".5"`, `"3."`
- **Scientific notation** → `"1e5"`, `"-3.2E-7"`

It should reject invalid/malformed inputs such as:
- `"a"`, `"x 1"`, `"a -2"`, `"-"`, `"1e"`, `"e9"`

---

## 📥 Input Format
- A single string `s`

## 📤 Output Format
- Return **true** if `s` is a valid number  
- Return **false** otherwise

---

## 🔒 Constraints
- `1 ≤ len(s) ≤ 10^4`
- Characters may include:
  - digits (`0-9`)
  - sign (`+/-`)
  - decimal point (`.`)
  - exponent marker (`e/E`)
  - spaces (only allowed at start/end, not in between)
- No thousands separators (e.g., `1,000` is invalid)

---

## ✅ Examples

### Example 1
Input: "10"
Output: true
Explanation: Valid positive integer


### Example 2
Input: "-10.1"
Output: true
Explanation: Valid signed decimal



### Example 3
Input: "1e5"
Output: true
Explanation: Valid scientific notation


### Example 4
Input: "a -2"
Output: false
Explanation: Invalid due to space and character



### More Edge Cases
| Input      | Output | Reason |
|------------|--------|--------|
| `" -90e3 "` | true   | trims spaces, valid scientific |
| `"1e-3"`    | true   | exponent with sign |
| `".1"`      | true   | fractional without leading digit |
| `"3."`      | true   | trailing decimal allowed |
| `"."`       | false  | needs at least one digit |
| `"1e"`      | false  | exponent missing digits |
| `"e9"`      | false  | mantissa missing |
| `"-"`       | false  | sign alone not valid |
| `"+"`       | false  | same as above |
| `" 1 2 "`   | false  | internal space invalid |

---

# 🔎 Approaches

## ✅ Approach 1: One-Pass Parser with Flags
1. **Trim spaces**.  
2. Track flags:  
   - `seen_digit` → Have we seen a digit before?  
   - `seen_dot` → Have we seen a decimal point?  
   - `seen_exp` → Have we seen an `e`/`E`?  
   - `digit_after_exp` → Ensure digits appear after exponent.  
3. Rules:
   - **Digits**: always valid; set flags.  
   - **Signs (`+/-`)**: only at start or after `e/E`.  
   - **Dot (`.`)**: allowed once, not after exponent.  
   - **Exponent (`e/E`)**: only once, must follow digit, and must be followed by integer.  
4. Final check → valid if we saw digits, and exponent (if present) had digits after.

**Complexity:**  
- Time: `O(n)` (scan once)  
- Space: `O(1)`  

---

## ✅ Approach 2: DFA (Finite State Machine)
- Design states like:  
  - `START`, `SIGN`, `INTEGER`, `DECIMAL`, `EXPONENT`, `EXP_SIGN`, `EXP_INTEGER`, `END`.  
- Transition rules define what comes next (digit, sign, dot, e/E, space).  
- If string ends in a valid state → return true.  

**Complexity:**  
- Time: `O(n)`  
- Space: `O(1)`  
- More formal and scalable but harder to implement.

---

## ✅ Approach 3: Regex
Use a compact regex to validate directly.  

Example pattern:
^\s*[+-]?((\d+(.\d*)?)|(.\d+))([eE][+-]?\d+)?\s*$


Explanation:
- `^\s*` → optional leading spaces  
- `[+-]?` → optional sign  
- `(\d+(\.\d*)?)|(\.\d+)` → digits with optional decimal OR just decimal with digits  
- `([eE][+-]?\d+)?` → optional exponent part  
- `\s*$` → optional trailing spaces  

**Complexity:**  
- Time: `O(n)` (regex engine scan)  
- Space: `O(1)`  

---

# 🧪 Edge Cases to Test
- Only a sign (`"+"`, `"-"`) → false  
- Only a dot (`"."`) → false  
- Decimal without leading digit (`".5"`) → true  
- Decimal without trailing digit (`"3."`) → true  
- Exponent without digits after (`"1e"`) → false  
- Exponent without digits before (`"e5"`) → false  
- Leading/trailing spaces valid, but no internal spaces  

---

# 🎯 Conclusion
- **Use Approach 1 (One-Pass Parser)** if you want **clear logic**.  
- **Use Approach 2 (DFA)** if interviewer prefers **formal parsing**.  
- **Use Approach 3 (Regex)** if interviewer allows **short elegant solution**.  


---
