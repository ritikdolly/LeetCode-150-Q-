//* 114. Flatten Binary Tree to Linked List

//? https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150

// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

package BinaryTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // Method 1: Iterative (Morris-like) - O(1) space
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // Method 2: Using Stack
    public void flattenUsingStack(TreeNode root) {
        if (root == null) return;

        java.util.Stack<TreeNode> st = new java.util.Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();

            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);

            if (!st.isEmpty()) {
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }

    // Method 3: Reverse Preorder (Recursion)
    TreeNode prev = null;
    public void flattenReversePre(TreeNode root) {
        if (root == null) return;

        flattenReversePre(root.right);
        flattenReversePre(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}

public class FlattenBT {
    public static void main(String[] args) {

        // Create Tree:
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(5,
                        null,
                        new TreeNode(6)));

        Solution sol = new Solution();

        // Choose one method to flatten:
        sol.flatten(root); // Iterative O(1) space
        // sol.flattenUsingStack(root);
        // sol.flattenReversePre(root);

        printRightList(root);
    }

    static void printRightList(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }
}




// //? by using stack 
// class Solution {
//     public void flatten(TreeNode root) {
//         if(root == null){
//             return;
//         }
//         Stack<TreeNode> st=new Stack<>();
//         st.push(root);
//         while(!st.isEmpty()){
//             TreeNode curr=st.peek();
//             st.pop();
//             if(curr.right!= null){
//                 st.push(curr.right);
//             }
//             if(curr.left!= null){
//                 st.push(curr.left);
//             }
//             if(!st.isEmpty()){
//                 curr.right=st.peek();
//                 curr.left=null;
//             }
//         }

//     }
// }

//? by using reverse preorder traversal
// class Solution {

//     TreeNode prev=null;
//     public void flatten(TreeNode root) {
//         if(root ==null){
//             return;
//         }    
//         flatten(root.right);
//         flatten(root.left);
//         root.right=prev;
//         root.left=null;
//         prev=root;
//     }
// }