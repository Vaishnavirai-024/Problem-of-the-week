// Approach 1: Method Chaining (Builder Pattern)
class AddSubtract {
    private int result;   // stores the computed result
    private boolean addNext; // flag to decide whether to add or subtract

    // Constructor starts with first number
    public AddSubtract(int num) {
        this.result = num;
        this.addNext = true; // next number should be added
    }

    // Method to chain next number
    public AddSubtract apply(int num) {
        if (addNext) {
            result += num; // add if flag is true
        } else {
            result -= num; // subtract if flag is false
        }
        addNext = !addNext; // flip flag
        return this; // return same object to allow chaining
    }

    // Final result
    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int ans1 = new AddSubtract(7).getResult();
        System.out.println(ans1); // Output: 7

        // Example 2
        int ans2 = new AddSubtract(1).apply(2).apply(3).getResult();
        System.out.println(ans2); // Output: 0 (1+2-3)

        // Example 3
        int ans3 = new AddSubtract(-5).apply(10).apply(3).apply(9).getResult();
        System.out.println(ans3); // Output: 11 (-5+10-3+9)
    }
}
// Approach 2: Using a Static Helper Function

// Approach 2: Direct Helper Function
class AddSubtractHelper {
    // Takes an array of numbers and applies alternating add/subtract
    public static int addSubtract(int... nums) {
        int result = nums[0]; // start with first number
        boolean addNext = true;

        for (int i = 1; i < nums.length; i++) {
            if (addNext) {
                result += nums[i];
            } else {
                result -= nums[i];
            }
            addNext = !addNext;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addSubtract(7));               // 7
        System.out.println(addSubtract(1, 2, 3));         // 0
        System.out.println(addSubtract(-5, 10, 3, 9));    // 11
    }
}


// Approach 3: Functional Interface (More Advanced Java)

import java.util.function.Function;

// Approach 3: Functional Programming style (simulate currying)
class AddSubtractFunctional {
    public static Function<Integer, Function<Integer, Integer>> curriedAddSubtract() {
        return a -> b -> a + b; // basic idea (can extend with alternating logic)
    }

    public static void main(String[] args) {
        // Demonstration (not full chaining like JS but shows functional style)
        Function<Integer, Function<Integer, Integer>> f = curriedAddSubtract();
        int result = f.apply(5).apply(6); // 5+6
        System.out.println(result); // 11
    }
}
