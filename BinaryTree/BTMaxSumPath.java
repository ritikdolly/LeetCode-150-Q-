// ? https://leetcode.com/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-interview-150

// !124. Binary Tree Maximum Path Sum
// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.



public class BTMaxSumPath {

    // TreeNode Definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution Class
    static class Solution {
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            helper(root);
            return maxSum;
        }

        int helper(TreeNode node) {
            if (node == null) return 0;

            int left = Math.max(0, helper(node.left));   // ignore negative paths
            int right = Math.max(0, helper(node.right)); // ignore negative paths

            // Maximum path that passes through the current node
            maxSum = Math.max(maxSum, node.val + left + right);

            // Return best one-side path to parent
            return node.val + Math.max(left, right);
        }
    }

    // Main to Test
    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
        Expected Max Path Sum = 2 + 1 + 3 = 6
        */
        TreeNode root = new TreeNode(1,
                            new TreeNode(2),
                            new TreeNode(3));

        Solution sol = new Solution();
        int ans = sol.maxPathSum(root);
        System.out.println("Maximum Path Sum = " + ans); // Output: 6
    }
}
