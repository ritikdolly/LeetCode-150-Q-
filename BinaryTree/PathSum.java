//* https://leetcode.com/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150

//! Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
// A leaf is a node with no children.

import java.util.Stack;

public class PathSum {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            Stack<TreeNode> path = new Stack<>();
            Stack<Integer> sumStack = new Stack<>();

            path.push(root);
            sumStack.push(root.val);

            while (!path.isEmpty()) {
                TreeNode temp = path.pop();
                int tempSum = sumStack.pop();

                // Check if it's a leaf and sum matches
                if (temp.left == null && temp.right == null && tempSum == targetSum) {
                    return true;
                }

                // Push right child
                if (temp.right != null) {
                    path.push(temp.right);
                    sumStack.push(tempSum + temp.right.val);
                }

                // Push left child
                if (temp.left != null) {
                    path.push(temp.left);
                    sumStack.push(tempSum + temp.left.val);
                }
            }

            return false;
        }
    }

    // Main to test
    public static void main(String[] args) {
        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \      \
          7    2      1
         Target Sum = 22
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Solution sol = new Solution();

        int targetSum = 22;
        System.out.println(sol.hasPathSum(root, targetSum)); // expected output: true
    }
}


// ? using recursion approach
// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if (root == null) return false;

//         // check if it's a leaf node
//         if (root.left == null && root.right == null) {
//             return targetSum == root.val;
//         }

//         // subtract current node value and move down
//         int remaining = targetSum - root.val;

//         return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
//     }
// }