//? https://leetcode.com/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=top-interview-150

//! 63. Unique Paths II
// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// The testcases are generated so that the answer will be less than or equal to 2 * 109.
// Example 1:
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2


public class UniquePathsII {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            // If starting cell is obstacle → no path
            if (obstacleGrid[0][0] == 1)
                return 0;

            obstacleGrid[0][0] = 1; // starting point

            // Fill first row
            for (int j = 1; j < n; j++) {
                obstacleGrid[0][j] = (obstacleGrid[0][j] == 1) ? 0 : obstacleGrid[0][j - 1];
            }

            // Fill first column
            for (int i = 1; i < m; i++) {
                obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
            }

            // Fill the rest
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0; // obstacle
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
            return obstacleGrid[m - 1][n - 1];
        }
    }
    public static void main(String[] args) {
        Solution sol = new UniquePathsII().new Solution();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int result = sol.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Number of unique paths: " + result); // Output: 2
    }
}
