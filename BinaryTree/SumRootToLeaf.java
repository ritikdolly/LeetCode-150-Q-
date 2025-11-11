//? https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150

//* 

import java.util.Stack;

public class SumRootToLeaf {

    // Definition for a binary tree node.
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

    static class Solution {

        //? Method 1 to solve using Iterative Approach using Stack
        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;

            Stack<TreeNode> path = new Stack<>();
            Stack<Integer> pathSum = new Stack<>();

            path.push(root);
            pathSum.push(root.val);

            int sum = 0;

            while (!path.isEmpty()) {
                TreeNode temp = path.pop();
                int tempVal = pathSum.pop();

                if (temp.left == null && temp.right == null) {
                    sum += tempVal;
                }

                if (temp.left != null) {
                    path.push(temp.left);
                    pathSum.push(tempVal * 10 + temp.left.val);
                }

                if (temp.right != null) {
                    path.push(temp.right);
                    pathSum.push(tempVal * 10 + temp.right.val);
                }
            }
            return sum;
        }

        //? Menthod 2 to solve using Recursive approach
        public int sumNumbersRecursive(TreeNode root) {
            return helper(root, 0);
        }

        private int helper(TreeNode node, int current) {
            if (node == null) return 0;

            current = current * 10 + node.val;

            if (node.left == null && node.right == null) {
                return current;
            }

            return helper(node.left, current) + helper(node.right, current);
        }
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3

           Root-to-leaf numbers: 12 + 13 = 25
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution sol = new Solution();

        System.out.println("Iterative Sum: " + sol.sumNumbers(root));
        System.out.println("Recursive Sum: " + sol.sumNumbersRecursive(root));
    }
}
