// ? https://leetcode.com/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150

//! 637. Average of Levels in Binary Tree 
// Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
// Input: root = [3,9,20,null,null,15,7]
// Output: [3.00000,14.50000,11.00000]

import java.util.ArrayList;
import java.util.List;

public class AvgLevelsBT {

    // ---- TreeNode definition ----
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

    // ---- Final Solution class ----
    static class Solution {

        class Info {
            double val = 0;
            int count = 0;
        }

        Info[] data = new Info[10000]; // fixed array (as per your logic)

        public List<Double> averageOfLevels(TreeNode root) {
            int height = getData(root, 0);
            List<Double> output = new ArrayList<>();

            for (int i = 0; i <= height; i++) {
                output.add(data[i].val / data[i].count);
            }
            return output;
        }

        public Integer getData(TreeNode root, int height) {
            if (root != null) {

                if (data[height] == null) {
                    data[height] = new Info();
                }

                data[height].val += root.val;
                data[height].count++;

                int left = getData(root.left, height + 1);
                int right = getData(root.right, height + 1);

                return Math.max(left, right);
            }

            return height - 1;
        }
    }

    // -------------- MAIN METHOD --------------
    public static void main(String[] args) {

        // Build a sample tree:
        //        3
        //      /   \
        //     9     20
        //          /  \
        //         15   7

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        Solution sol = new Solution();
        List<Double> result = sol.averageOfLevels(root);

        System.out.println("Average of Levels: " + result);
    }
}
