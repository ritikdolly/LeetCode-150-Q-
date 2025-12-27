// ?https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150

//! 106. Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

import java.util.HashMap;
import java.util.Map;

public class ConstructBTInorderPostorderTraversal {

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
        private Map<Integer, Integer> nodeToIdx = new HashMap<>();
        private int postIdx = 0;

        TreeNode createTree(int[] post, int inSt, int inEnd) {
            if (inSt > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(post[postIdx--]);

            int pos = nodeToIdx.get(root.val);
            root.right = createTree(post, pos + 1, inEnd);
            root.left = createTree(post, inSt, pos - 1);

            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            postIdx = postorder.length - 1;
            for (int i = 0; i < inorder.length; i++) {
                nodeToIdx.put(inorder[i], i);
            }
            return createTree(postorder, 0, inorder.length - 1);
        }
    }

}