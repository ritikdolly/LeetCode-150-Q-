//? https://leetcode.com/problems/surrounded-regions/description/?envType=study-plan-v2&envId=top-interview-150

// ! 130. Surrounded Regions
// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

public class SurroundedRegions {

    //? using visited array have to give extra space
    // class Solution {
    //     int m, n;

    //     void dfs(char[][] board, boolean[][] visited, int i, int j) {
    //         if (i < 0 || i >= m || j < 0 || j >= n)
    //             return;
    //         if (board[i][j] == 'X')
    //             return;
    //         if (visited[i][j])
    //             return;

    //         visited[i][j] = true;

    //         dfs(board, visited, i - 1, j);
    //         dfs(board, visited, i + 1, j);
    //         dfs(board, visited, i, j - 1);
    //         dfs(board, visited, i, j + 1);
    //     }

    //     public void solve(char[][] board) {
    //         if (board == null || board.length == 0 || board[0].length == 0)
    //             return;

    //         m = board.length;
    //         n = board[0].length;

    //         boolean[][] visited = new boolean[m][n];

    //         for (int i = 0; i < m; i++) {
    //             if (board[i][0] == 'O')
    //                 dfs(board, visited, i, 0);
    //             if (board[i][n - 1] == 'O')
    //                 dfs(board, visited, i, n - 1);
    //         }

    //         for (int j = 0; j < n; j++) {
    //             if (board[0][j] == 'O')
    //                 dfs(board, visited, 0, j);
    //             if (board[m - 1][j] == 'O')
    //                 dfs(board, visited, m - 1, j);
    //         }

    //         for (int i = 1; i < m - 1; i++) {
    //             for (int j = 1; j < n - 1; j++) {
    //                 if (board[i][j] == 'O' && !visited[i][j]) {
    //                     board[i][j] = 'X';
    //                 }
    //             }
    //         }
    //     }
    // }

    // ? without visited array (Optimized)
    static class Solution {

        // Method to solve the surrounded regions problem
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0)
                return;

            int rows = board.length;
            int cols = board[0].length;

            // Step 1: Mark border-connected 'O' cells as 'E'
            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O')
                    markSafe(board, i, 0);
                if (board[i][cols - 1] == 'O')
                    markSafe(board, i, cols - 1);
            }

            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O')
                    markSafe(board, 0, j);
                if (board[rows - 1][j] == 'O')
                    markSafe(board, rows - 1, j);
            }

            // Step 2: Convert safe 'E' back to 'O' and unsafe 'O' to 'X'
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'E') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        // DFS for marking safe cells
        private void markSafe(char[][] board, int row, int col) {
            int rows = board.length;
            int cols = board[0].length;

            if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O')
                return;

            board[row][col] = 'E'; // Mark as safe

            markSafe(board, row + 1, col);
            markSafe(board, row - 1, col);
            markSafe(board, row, col + 1);
            markSafe(board, row, col - 1);
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        Solution sol = new Solution();
        sol.solve(board);

        System.out.println("Final Board:");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

