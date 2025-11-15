// ? https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150

//! 102. Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {

    // ---- TreeNode class ----
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

    // ---- BFS Solution ----
    static class SolutionBFS {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null)
                return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> level = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    level.add(node.val);

                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }

                res.add(level);
            }

            return res;
        }
    }

    // ---- DFS Solution ----
    static class SolutionDFS {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<>();
            rec(root, 0, levels);
            return levels;
        }

        private void rec(TreeNode root, int level, List<List<Integer>> levels) {
            if (root == null)
                return;

            if (levels.size() == level)
                levels.add(new ArrayList<>());

            levels.get(level).add(root.val);

            rec(root.left, level + 1, levels);
            rec(root.right, level + 1, levels);
        }
    }

    // ---- Main method for testing ----
    public static void main(String[] args) {

        // Building a sample tree:
        //        1
        //     /     \
        //    2       3
        //   / \     / \
        //  4   5   6   7

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );

        // BFS Result
        SolutionBFS bfs = new SolutionBFS();
        List<List<Integer>> bfsOutput = bfs.levelOrder(root);
        System.out.println("BFS Level Order: " + bfsOutput);

        // DFS Result
        SolutionDFS dfs = new SolutionDFS();
        List<List<Integer>> dfsOutput = dfs.levelOrder(root);
        System.out.println("DFS Level Order: " + dfsOutput);
    }
}
