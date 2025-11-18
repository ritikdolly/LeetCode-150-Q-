// ? https://leetcode.com/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150

//! 98. Validate Binary Search Tree
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//A valid BST is defined as follows:    
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Input: root = [2,1,3]
// Output: true

public class ValidBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // using Inorder Traversal
    class Solution {
        Integer prev = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (prev != null && prev >= root.val) {
                return false;
            }
            prev = root.val;
            return isValidBST(root.right);
        }
    }
    // ---- MAIN for Testing ----
    public static void main(String[] args) {
        // Building BST:
        //        5
        //      /   \
        //     3     6
        //    / \
        //   2   4
        //  /
        // 1

        TreeNode root = new TreeNode(
                5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)
                ),
                new TreeNode(6)
        );

        Solution solution = new ValidBST().new Solution();
        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid);
    }

}