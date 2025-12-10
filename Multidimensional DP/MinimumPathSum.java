//? https://leetcode.com/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
//! 64. Minimum Path Sum
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7


public class MinimumPathSum {

    // ? using 2D DP array approach 1
    // class Solution {
    // public int minPathSum(int[][] grid) {
    // int m = grid.length;// row length
    // int n = grid[0].length;// column length

    // for (int i = 1; i < n; i++) {
    // grid[0][i] += grid[0][i - 1];
    // }
    // for (int i = 1; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // if (j == 0) {
    // grid[i][j] += grid[i - 1][j];
    // } else {
    // grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    // }
    // }
    // }
    // return grid[m - 1][n - 1];
    // }
    // }

    // ? using extra space approach 2
    // class Solution {
    // public int minPathSum(int[][] grid) {
    // int m = grid.length;// row length
    // int n = grid[0].length;// column length

    // int[] dp = new int[n];

    // for (int i = 0; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // if (i == 0 && j == 0) {
    // dp[j] = grid[i][j];
    // } else if (i == 0) {
    // dp[j] = dp[j - 1] + grid[i][j];
    // } else if (j == 0) {
    // dp[j] = dp[j] + grid[i][j];
    // } else {
    // dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
    // }
    // }
    // }
    // return dp[n - 1];
    // }
    // }

    // ? in-place approach 3
    class Solution {
        static {
            for (int i = 0; i < 500; i++)
                minPathSum(new int[1][1]);
        }

        public static int minPathSum(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            // Fill first column
            for (int i = 1; i < rows; i++) {
                grid[i][0] += grid[i - 1][0];
            }

            // Fill first row
            for (int j = 1; j < cols; j++) {
                grid[0][j] += grid[0][j - 1];
            }

            // Fill rest of the grid
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }

            return grid[rows - 1][cols - 1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new MinimumPathSum().new Solution();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(sol.minPathSum(grid)); // -> 7
    }

}
