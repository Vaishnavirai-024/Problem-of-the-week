//                                       Brute Force (Top-down)

// Brute force approach to count unival subtrees
// Time Complexity: O(N^2) in worst case

public class BruteForce {

    // Main method to run the program
    public static void main(String[] args) {
        // Manually building the example tree from the question
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(0);

        // Call function and print result
        int result = countUnivalSubtrees(root);
        System.out.println("Total Unival Subtrees (Brute Force): " + result);
    }

    // Counts unival subtrees using top-down brute force
    public static int countUnivalSubtrees(TreeNode root) {
        // Base case
        if (root == null) return 0;

        // Count in left and right subtrees
        int leftCount = countUnivalSubtrees(root.left);
        int rightCount = countUnivalSubtrees(root.right);

        // Check if current subtree is unival
        if (isUnival(root)) {
            return leftCount + rightCount + 1; // Count current node
        } else {
            return leftCount + rightCount;     // Only count children
        }
    }

    // Helper function to check if a subtree is unival
    private static boolean isUnival(TreeNode node) {
        if (node == null) return true;

        // Check left child value
        if (node.left != null && node.left.val != node.val) return false;

        // Check right child value
        if (node.right != null && node.right.val != node.val) return false;

        // Recurse to children
        return isUnival(node.left) && isUnival(node.right);
    }
}


// ........................................................................................................................

//                                            Optimized Post-order Approach

// Optimized approach using post-order traversal
// Time Complexity: O(N)

public class OptimizedPostOrder {

    // Wrapper class to keep count in recursion
    static class CountWrapper {
        int count = 0;
    }

    // Main method to run program
    public static void main(String[] args) {
        // Build the binary tree (same as question)
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(0);

        // Count and print the result
        int result = countUnivalSubtrees(root);
        System.out.println("Total Unival Subtrees (Optimized): " + result);
    }

    // Function that counts unival subtrees
    public static int countUnivalSubtrees(TreeNode root) {
        CountWrapper count = new CountWrapper();
        isUnival(root, count); // Start recursion
        return count.count;
    }

    // Recursive helper: returns true if current subtree is unival
    private static boolean isUnival(TreeNode node, CountWrapper count) {
        // Null node is considered unival
        if (node == null) return true;

        // Check left and right subtrees
        boolean isLeftUnival = isUnival(node.left, count);
        boolean isRightUnival = isUnival(node.right, count);

        // If either side is not unival, this can't be unival
        if (!isLeftUnival || !isRightUnival) return false;

        // If left child exists and has different value, not unival
        if (node.left != null && node.left.val != node.val) return false;

        // If right child exists and has different value, not unival
        if (node.right != null && node.right.val != node.val) return false;

        // This node is a root of a unival subtree
        count.count++;
        return true;
    }
}
