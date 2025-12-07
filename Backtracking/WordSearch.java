//? https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-interview-150

//! 79. Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:1
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

public class WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int index) {
            // If full word matched
            if (index == word.length())
                return true;

            // Boundary & character check
            if (i < 0 || i >= board.length ||
                    j < 0 || j >= board[0].length ||
                    board[i][j] != word.charAt(index)) {
                return false;
            }

            // Mark current cell visited
            char temp = board[i][j];
            board[i][j] = '#';

            // Explore 4 directions
            boolean found = dfs(board, word, i + 1, j, index + 1) ||
                    dfs(board, word, i - 1, j, index + 1) ||
                    dfs(board, word, i, j + 1, index + 1) ||
                    dfs(board, word, i, j - 1, index + 1);

            // Restore cell
            board[i][j] = temp;

            return found;
        }
    }
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        System.out.println(result); // Output: true
    }
}
