// Approach 1: Using a Wrapper Class with Chained Calls

class CurriedAddSubtract {
    private int sum;
    private boolean addNext;

    public CurriedAddSubtract(int start) {
        this.sum = start;
        this.addNext = false; // next will be subtract
    }

    public CurriedAddSubtract apply(int num) {
        if (addNext) sum += num;
        else sum -= num;
        addNext = !addNext; // flip sign
        return this;
    }

    public int result() {
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new CurriedAddSubtract(5).apply(6).apply(7).result()); // 4
        System.out.println(new CurriedAddSubtract(1).apply(2).apply(3).result()); // 0
    }
}


// Approach 2: Using Lambdas (Functional Interface)


import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> addSubtract =
            a -> b -> c -> a + b - c;

        System.out.println(addSubtract.apply(1).apply(2).apply(3)); // 0
    }
}



// Approach 3: Using Varargs (Simpler but Not Pure Currying)


public class Main {
    public static int addSubtract(int... nums) {
        int result = nums[0];
        boolean add = true;

        for (int i = 1; i < nums.length; i++) {
            if (add) result += nums[i];
            else result -= nums[i];
            add = !add;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addSubtract(5, 6, 7)); // 4
        System.out.println(addSubtract(1, 2, 3)); // 0
        System.out.println(addSubtract(-5, 10, 3, 9)); // 11
    }
}
