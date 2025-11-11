//? https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150

//! Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree

//* Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//* Output: [3,9,20,null,null,15,7]

import java.util.HashMap;
import java.util.Map;

public class CreateBTFromInPost {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private Map<Integer, Integer> nodeToIdx = new HashMap<>();
    private int postIdx = 0;

    TreeNode createTree(int[] post, int inSt, int inEnd) {
        if (inSt > inEnd)
            return null;

        TreeNode root = new TreeNode(post[postIdx--]); // take root from postorder (right to left)

        int pos = nodeToIdx.get(root.val); // index in inorder

        // build right subtree first, because we are moving from end of postorder
        root.right = createTree(post, pos + 1, inEnd);
        root.left = createTree(post, inSt, pos - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++)
            nodeToIdx.put(inorder[i], i);
        return createTree(postorder, 0, inorder.length - 1);
    }

    // inorder print to verify
    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        CreateBTFromInPost obj = new CreateBTFromInPost();
        TreeNode root = obj.buildTree(inorder, postorder);

        printInorder(root); // expected output: 9 3 15 20 7
    }
}
