// ? https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150

//! 108. Convert Sorted Array to Binary Search Tree
// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
// Example 1:
// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]


public class ConvertSortedArraytoBST {

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

        TreeNode createTree(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode newNode = new TreeNode(nums[mid]);
            newNode.left = createTree(nums, left, mid - 1);
            newNode.right = createTree(nums, mid + 1, right);
            return newNode;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            return createTree(nums, 0, nums.length - 1);
        }
    }
    public static void main(String[] args) {
        Solution sol = new ConvertSortedArraytoBST().new Solution();
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode bstRoot = sol.sortedArrayToBST(nums);
        // You can add code here to print or verify the structure of the BST if needed
    }

}
