// ? https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-interview-150

// ! 230. Kth Smallest Element in a BST
// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
// Input: root = [3,1,4,null,2], k = 1
// Output: 1


public class KthSmallElmBST {

    // ---- Correct TreeNode Definition ----
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

    // using Inorder Traversal
    static class Solution {

        int count = 0;
        int answer = 0;

        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return answer;
        }

        private void inorder(TreeNode root, int k) {
            if (root == null) return;

            inorder(root.left, k);

            count++;
            if (count == k) {
                answer = root.val;
                return;
            }

            inorder(root.right, k);
        }
    }

    // ---- MAIN for Testing ----
    public static void main(String[] args) {

        // Building BST:
        //        5
        //      /   \
        //     3     6
        //    / \
        //   2   4
        //  /
        // 1

        TreeNode root = new TreeNode(
                5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)
                ),
                new TreeNode(6)
        );

        Solution sol = new Solution();
        int k = 3;
        int result = sol.kthSmallest(root, k);

        System.out.println("Kth Smallest (" + k + "): " + result);
    }
}
