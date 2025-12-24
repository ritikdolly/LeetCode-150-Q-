// ? https://leetcode.com/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-interview-150

// ! 226. Invert Binary Tree
// Given the root of a binary tree, invert the tree, and return its root.

// Example 1:
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

public class InvertBinaryTree {

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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // Node cur=root;
            if (root.left != null || root.right != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        Solution sol = ibt.new Solution();
        TreeNode root = ibt.new TreeNode(4);
        root.left = ibt.new TreeNode(2);
        root.right = ibt.new TreeNode(7);
        root.left.left = ibt.new TreeNode(1);
        root.left.right = ibt.new TreeNode(3);
        root.right.left = ibt.new TreeNode(6);
        root.right.right = ibt.new TreeNode(9);

        TreeNode invertedRoot = sol.invertTree(root);
        // The inverted tree can be verified by traversing it or printing its structure.
    }
}
