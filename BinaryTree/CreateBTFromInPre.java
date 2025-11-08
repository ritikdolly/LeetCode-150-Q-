//? https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150

//! Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

//* Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//* Output: [3,9,20,null,null,15,7]
package BinaryTree;
import java.util.HashMap;
import java.util.Map;

public class CreateBTFromInPre {

    static class TreeNode {
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

    static Map<Integer, Integer> indexMap = new HashMap<>();
    static int preIndex = 0;

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);

        return helper(preorder, 0, inorder.length - 1);
    }

    static TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int pos = indexMap.get(root.val);

        root.left = helper(preorder, inStart, pos - 1);
        root.right = helper(preorder, pos + 1, inEnd);

        return root;
    }

    // Helper function to print tree in inorder to verify result
    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root= buildTree(preorder, inorder);

        printInorder(root); // expected output: 9 3 15 20 7
    }

}

// class Solution {
// int preIdx=0;
// int inIdx=0;
// public TreeNode buildTree(int[] preorder, int[] inorder) {
// return buildTree(preorder,inorder,Integer.MAX_VALUE);

// }

// TreeNode buildTree(int []preorder,int []inorder,int limit){
// if(preIdx == preorder.length){
// return null;
// }
// if(inorder[inIdx] == limit){
// inIdx++;
// return null;
// }

// TreeNode root=new TreeNode(preorder[preIdx++]);
// root.left=buildTree(preorder,inorder,root.val);
// root.right=buildTree(preorder,inorder,limit);

// return root;
// }
// }
