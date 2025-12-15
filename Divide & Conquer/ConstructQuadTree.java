// ? https://leetcode.com/problems/construct-quad-tree/?envType=study-plan-v2&envId=top-interview-150

// ! 427. Construct Quad Tree
// Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.
// Return the root of the Quad-Tree representing grid.
// A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
// val: True if the node represents a grid of 1's or False if the node represents a grid of 0's. Notice that you can assign the val to True or False when isLeaf is False, and both are accepted in the answer.
// isLeaf: True if the node is a leaf node on the tree or False if the node has four children.
// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;
// }
// We can construct a Quad-Tree from a two-dimensional area using the following steps:

// If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
// If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
// Recurse for each of the children with the proper sub-grid.

// If you want to know more about the Quad-Tree, you can refer to the wiki.

// Quad-Tree format:

// You don't need to read this section for solving the problem. This is only if you want to understand the output format here. The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies a path terminator where no node exists below.

// It is very similar to the serialization of the binary tree. The only difference is that the node is represented as a list [isLeaf, val].

// If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf or val is False we represent it as 0.

// Example 1:
// Input: grid = [[0,1],[1,0]]
// Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]

import java.util.*;

public class ConstructQuadTree {

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight,
                    Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    class Solution {

        boolean isAllSame(int[][] grid, int x, int y, int n) {
            int val = grid[x][y];
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    if (grid[i][j] != val) {
                        return false;
                    }
                }
            }
            return true;
        }

        Node solve(int[][] grid, int x, int y, int n) {
            if (isAllSame(grid, x, y, n)) {
                return new Node(grid[x][y] == 1, true);
            }

            Node root = new Node(true, false);
            int half = n / 2;

            root.topLeft = solve(grid, x, y, half);
            root.topRight = solve(grid, x, y + half, half);
            root.bottomLeft = solve(grid, x + half, y, half);
            root.bottomRight = solve(grid, x + half, y + half, half);

            return root;
        }

        public Node construct(int[][] grid) {
            return solve(grid, 0, 0, grid.length);
        }
    }

    // 🔹 Helper method to print Quad Tree (Level Order)
    static void printQuadTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) continue;

            System.out.print("[" + (node.isLeaf ? 1 : 0) + "," + (node.val ? 1 : 0) + "] ");

            if (!node.isLeaf) {
                queue.add(node.topLeft);
                queue.add(node.topRight);
                queue.add(node.bottomLeft);
                queue.add(node.bottomRight);
            }
        }
        System.out.println();
    }

    // ✅ Completed main method
    public static void main(String[] args) {
        ConstructQuadTree obj = new ConstructQuadTree();
        Solution sol = obj.new Solution();

        int[][] grid = {
            {0, 1},
            {1, 0}
        };

        Node root = sol.construct(grid);

        printQuadTree(root);
    }
}

