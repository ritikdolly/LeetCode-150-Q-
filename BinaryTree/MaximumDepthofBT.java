// ? https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-interview-150

//! 104. Maximum Depth of Binary Tree

// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

public class MaximumDepthofBT {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
        }
    }
    public static void main(String[] args) {
        MaximumDepthofBT mdbt = new MaximumDepthofBT();
        Solution sol = mdbt.new Solution();
        TreeNode root = mdbt.new TreeNode(3);
        root.left = mdbt.new TreeNode(9);  
        root.right = mdbt.new TreeNode(20);
        root.right.left = mdbt.new TreeNode(15);
        root.right.right = mdbt.new TreeNode(7);    
        System.out.println(sol.maxDepth(root)); // Output: 3
        
    }
}
