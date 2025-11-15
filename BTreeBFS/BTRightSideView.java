// ? https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-interview-150

//! 199. Binary Tree Right Side View
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {

    // TreeNode definition
    static class TreeNode {
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

    // ---------------- BFS Solution ----------------
    static class SolutionBFS {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();

                    // First added is the rightmost since we push right child first
                    if (i == 0) {
                        res.add(curr.val);
                    }

                    // Push right first, then left
                    if (curr.right != null) q.offer(curr.right);
                    if (curr.left != null) q.offer(curr.left);
                }
            }
            return res;
        }
    }

    // ---------------- DFS Solution ----------------
    static class SolutionDFS {

        private void dfs(TreeNode root, int level, List<Integer> res) {
            if (root == null) return;

            // First time reaching this level means this node is rightmost
            if (level == res.size()) {
                res.add(root.val);
            }

            // Go right first
            dfs(root.right, level + 1, res);
            dfs(root.left, level + 1, res);
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, 0, res);
            return res;
        }
    }

}
