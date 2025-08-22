class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MaximumPathSum {
    
    // Global variable to store the result
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;  // initially very small
        helper(root);
        return maxSum;
    }

    // Helper function using post-order DFS
    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Recurse left & right (ignore negatives by taking max with 0)
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // Current path including both sides
        int currentPath = node.val + left + right;

        // Update global max
        maxSum = Math.max(maxSum, currentPath);

        // Return max path sum including only one child
        return node.val + Math.max(left, right);
    }
