// ? https://leetcode.com/problems/count-complete-tree-nodes/description/?envType=study-plan-v2&envId=top-interview-150

// !222. Count Complete Tree Nodes
// Given the root of a complete binary tree, return the number of the nodes in the tree.
// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Design an algorithm that runs in less than O(n) time complexity.


public class CountCompleteTreeNode {

    // ---------- Definition for a binary tree node ----------
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

    // ---------- Approach 1: Simple Recursive (DFS) ----------
    static class Solution1 {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // ---------- Approach 2: Optimized for Complete Binary Tree ----------
    // Uses height of left and right subtrees to skip counting full subtrees.
    static class Solution2 {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;

            int leftHeight = getLeftHeight(root);
            int rightHeight = getRightHeight(root);

            if (leftHeight == rightHeight) {
                // Perfect binary tree: nodes = 2^height - 1
                return (1 << leftHeight) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }

        private int getLeftHeight(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.left;
            }
            return height;
        }

        private int getRightHeight(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.right;
            }
            return height;
        }
    }

    // ---------------- MAIN (for Testing) ----------------
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \  /
             4  5 6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), null);

        Solution1 simple = new Solution1();
        Solution2 optimized = new Solution2();

        System.out.println("Total nodes (Simple Recursive): " + simple.countNodes(root));
        System.out.println("Total nodes (Optimized for Complete Tree): " + optimized.countNodes(root));
    }
}
