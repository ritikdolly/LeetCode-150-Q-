//? https://leetcode.com/problems/n-queens-ii/description/?envType=study-plan-v2&envId=top-interview-150
//! 52. N-Queens II
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

// Example 1:
// Input: n = 5
// Output: 10
public class NQueens {
    class Solution {
        int ans = 0;

        public int totalNQueens(int n) {
            boolean[] col = new boolean[n];
            boolean[] diag = new boolean[2 * n];
            boolean[] antiDiag = new boolean[2 * n];
            backTrack(0, n, col, diag, antiDiag);
            return ans;
        }

        void backTrack(int row, int n, boolean[] col, boolean[] diag, boolean[] antiDiag) {
            if (row == n) {
                ans++;
                return;
            }

            for (int i = 0; i < n; i++) {
                if (col[i] || diag[row + i] || antiDiag[row - i + n]) {
                    continue;
                }

                col[i] = true;
                diag[row + i] = true;
                antiDiag[row - i + n] = true;

                backTrack(row + 1, n, col, diag, antiDiag);

                col[i] = false;
                diag[row + i] = false;
                antiDiag[row - i + n] = false;

            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        int n = 4;
        int result = solution.totalNQueens(n);
        System.out.println(result); // Output: 2
    }
}
