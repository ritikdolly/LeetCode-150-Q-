//? https://leetcode.com/problems/binary-search-tree-iterator/description/?envType=study-plan-v2&envId=top-interview-150

// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
// BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
// boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
// int next() Moves the pointer to the right, then returns the number at the pointer.
// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
// You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.


import java.util.*;

// Definition for a binary tree node
class TreeNode {
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

public class BSTIterator {

    // ---------- Approach 1: Using Inorder Traversal (Preprocessing) ----------
    private List<Integer> list;
    private int i = 0;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    public int next() {
        return list.get(i++);
    }

    public boolean hasNext() {
        return i < list.size();
    }

    // ---------- Approach 2: On-demand Traversal Using Stack ----------
    /*
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode top = st.pop();
        if (top.right != null) {
            pushLeft(top.right);
        }
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    */

    // --------------------- MAIN (for Testing) ---------------------
    public static void main(String[] args) {
        /*
                7
               / \
              3   15
                 /  \
                9   20
         */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15, new TreeNode(9), new TreeNode(20));

        BSTIterator iterator = new BSTIterator(root);

        System.out.println("Inorder Traversal using BSTIterator:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");  // Output: 3 7 9 15 20
        }
    }
}
