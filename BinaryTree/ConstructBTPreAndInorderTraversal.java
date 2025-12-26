//? https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150

//! 105. Construct Binary Tree from Preorder and Inorder Traversal
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Example 1:

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

import java.util.HashMap;
import java.util.Map;

public class ConstructBTPreAndInorderTraversal {

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
        private Map<Integer, Integer> indexMap = new HashMap<>();
        private int preIndex = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++)
                indexMap.put(inorder[i], i);

            return helper(preorder, inorder, 0, inorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
            if (inStart > inEnd)
                return null;

            TreeNode root = new TreeNode(preorder[preIndex++]);
            int pos = indexMap.get(root.val);

            root.left = helper(preorder, inorder, inStart, pos - 1);
            root.right = helper(preorder, inorder, pos + 1, inEnd);

            return root;
        }
    }
    public static void main(String[] args) {
        ConstructBTPreAndInorderTraversal cbt = new ConstructBTPreAndInorderTraversal();
        Solution sol = cbt.new Solution();
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = sol.buildTree(preorder, inorder);
        // The tree is constructed. You can add code here to print or verify the tree structure.
    }

}
