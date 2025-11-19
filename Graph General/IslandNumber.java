//? https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150

// ! Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

public class IslandNumber {

    static class Solution {
        int m, n;

        // Depth-First Search to mark visited land
        void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }

            // Mark as visited
            grid[i][j] = '0';

            // Explore neighbors
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
        // Count number of islands in the grid
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            m = grid.length;
            n = grid[0].length;

            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        Solution sol = new Solution();
        int islands = sol.numIslands(grid);

        System.out.println("Number of islands: " + islands);
    }
}
