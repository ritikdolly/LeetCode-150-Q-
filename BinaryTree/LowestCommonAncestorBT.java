// ? https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


public class LowestCommonAncestorBT {

    // ---------- Definition for a binary tree node ----------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // ---------- Solution Class ----------
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Base Case
            if (root == null || root == p || root == q) {
                return root;
            }

            // Search in left and right subtrees
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // If both sides return non-null → root is LCA
            if (left != null && right != null) {
                return root;
            }

            // Otherwise, return the non-null result
            return (left != null) ? left : right;
        }
    }

    // ---------------- MAIN (for Testing) ----------------
    public static void main(String[] args) {
        /*
                    3
                   / \
                  5   1
                 / \ / \
                6  2 0  8
                  / \
                 7   4
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution sol = new Solution();

        TreeNode p = root.left;             // Node 5
        TreeNode q = root.left.right.right; // Node 4

        TreeNode lca = sol.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        // Expected Output: 5
    }
}
