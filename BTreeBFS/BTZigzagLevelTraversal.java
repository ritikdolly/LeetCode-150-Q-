//? https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150

//! 103. Binary Tree Zigzag Level Order Traversal
// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigzagLevelTraversal {

    // ---- TreeNode Definition ----
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

    // ---- Optimized Solution: Using Deque (No Reverse) ----
    static class SolutionDeque {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            boolean leftToRight = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                Deque<Integer> level = new ArrayDeque<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    if (leftToRight)
                        level.addLast(node.val);
                    else
                        level.addFirst(node.val);

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

                result.add(new ArrayList<>(level));
                leftToRight = !leftToRight;
            }

            return result;
        }
    }

    // ---- Normal Solution: Using Reverse() ----
    static class SolutionReverse {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean rightSide = false;

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> levelElm = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    levelElm.add(node.val);

                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }

                if (rightSide) {
                    Collections.reverse(levelElm);
                }

                res.add(levelElm);
                rightSide = !rightSide;
            }

            return res;
        }
    }

    // ---- MAIN for Testing ----
    public static void main(String[] args) {

        // Building sample tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );

        System.out.println("Using Optimized Deque Method:");
        SolutionDeque sol1 = new SolutionDeque();
        System.out.println(sol1.zigzagLevelOrder(root));

        System.out.println("\nUsing Reverse Method:");
        SolutionReverse sol2 = new SolutionReverse();
        System.out.println(sol2.zigzagLevelOrder(root));
    }
}
